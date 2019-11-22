package com.kalotclub.demo.algorithms.tree;

/**
 * Date: 2019-10-27 22:05
 *
 * @author hongchen.cao
 */
public interface BinarySearchTree<K extends Comparable<K>, V> {
    V put(K key, V val);

    V get(K key);

    V delete(K key);
}
