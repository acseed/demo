package com.kalotclub.demo.algorithms.tree;

/**
 * Date: 2019-10-28 00:11
 *
 * @author hongchen.cao
 */
public class RBTreeTest {
    public static void main(String[] args) {
        RBTree<String, String> rbTree = RBTree.create();
        rbTree.put("A", "A");
        rbTree.put("B", "B");
        rbTree.put("C", "C");
        rbTree.put("C", "E");
        rbTree.put("D", "D");
        rbTree.put("E", "E");
        rbTree.put("F", "F");
        rbTree.put("G", "G");
        rbTree.put("H", "H");
    }
}
