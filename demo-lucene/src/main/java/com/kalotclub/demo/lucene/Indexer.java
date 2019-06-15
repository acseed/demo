package com.kalotclub.demo.lucene;

/**
 * Date: 2019-06-15 10:18
 *
 * @author hongchen.cao
 */
public class Indexer {
    private IndexWriter indexWriter;

    public Indexer(String indexDir, IndexWriterConfig.OpenMode mode) throws IOException {
        Directory dir = FSDirectory.open(Paths.get(indexDir));
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        iwc.setOpenMode(mode);
        indexWriter = new IndexWriter(dir, iwc);
    }

    public void close() throws IOException {
        indexWriter.close();
    }

    public int index(Path path) throws IOException, TikaException, SAXException {
        if (Files.isDirectory(path)) {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    try {
                        if (file.toFile().getName().endsWith(".pdf")) {
                            indexFile(file);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } else {
            indexFile(path);
        }

        return indexWriter.getDocStats().maxDoc;
    }

    private Document getDocument(Path file) throws IOException, TikaException, SAXException {
        Document document = new Document();

        BodyContentHandler bodyContentHandler = new BodyContentHandler(Integer.MAX_VALUE);
        Metadata metadata = new Metadata();
        ParseContext parseContext = new ParseContext();

        PDFParser pdfParser = new PDFParser();
        pdfParser.parse(Files.newInputStream(file), bodyContentHandler, metadata, parseContext);
        String[] metadataNames = metadata.names();
        for(String name : metadataNames) {
            System.out.println(name+ " : " + metadata.get(name));
        }





        document.add(new StringField("fileName", file.toFile().getName(), Field.Store.YES));
        document.add(new LongPoint("modified", Files.getLastModifiedTime(file).toMillis()));
        return document;
    }

    public void indexFile(Path file) throws IOException, TikaException, SAXException {
        Document doc = getDocument(file);
        indexWriter.addDocument(doc);
    }

    public static void main(String[] args) throws IOException, TikaException, SAXException {
        String indexPath = "/Users/hongchen.cao/Desktop/demo/lucene/index";
        String dataPath = "/Users/hongchen.cao/Desktop/demo/lucene/data";

        long start = System.currentTimeMillis();

        Indexer indexer = new Indexer(indexPath, IndexWriterConfig.OpenMode.CREATE);

        int indexed = indexer.index(Paths.get(dataPath));
        System.out.println("indexing " + indexed + " files took " + (System.currentTimeMillis() - start) + " milliseconds");
    }
}

