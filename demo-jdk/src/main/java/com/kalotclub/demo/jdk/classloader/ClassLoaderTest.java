package com.kalotclub.demo.jdk.classloader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.ProtectionDomain;

/**
 * Date: 2019-11-01 13:14
 *
 * @author hongchen.cao
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";

                InputStream is = null;
                if (name.contains("Integer")) {
                    try {
                        is = new FileInputStream("/Users/hongchen.cao/projects/personal/demo/demo-jdk/src/main/resources/Integer.class");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else {
                    is = getClass().getResourceAsStream(fileName);
                }
                if (is == null) {
                    return super.loadClass(name);
                }

                try {
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                throw new ClassNotFoundException(name);
            }


        };

        Integer integer = (Integer) classLoader.loadClass("java.lang.Integer").newInstance();
        System.out.println(integer.toString());


    }
}
