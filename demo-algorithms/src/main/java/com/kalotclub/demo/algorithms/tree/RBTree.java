package com.kalotclub.demo.algorithms.tree;

import lombok.Getter;

/**
 * Date: 2019-10-27 22:06
 *
 * @author hongchen.cao
 */
public class RBTree<K extends Comparable<K>, V> implements BinarySearchTree<K, V> {

    /**
     * root of the tree
     */
    private RBNode<K, V> root;

    public static <K extends Comparable<K>, V> RBTree<K, V> create() {
        return new RBTree<>();
    }

    private RBTree() {
        this.root = null;
    }

    @Override
    public V put(K key, V val) {
        RBNode<K, V> node = new RBNode<>(key, val, Color.Red);
        return insert(node);
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V delete(K key) {
        return null;
    }

    private V insert(RBNode<K, V> x) {
        RBNode<K, V> p = null;
        RBNode<K, V> y = this.root;
        while (y != null) {
            p = y;
            int cmp = x.key.compareTo(y.key);
            if (cmp == 0) {
                V preVal = y.val;
                y.val = x.val;
                return preVal;
            } else if (cmp < 0) {
                y = y.left;
            } else {
                y = y.right;
            }
        }

        x.parent = p;
        if (p == null) {
            this.root = x;
        } else if (p.key.compareTo(x.key) > 0) {
            p.left = x;
        } else {
            p.right = x;
        }

        insertFixUp(x);
        return null;
    }

    private RBNode<K, V> leftRotate(RBNode<K, V> x) {
        if (null == x || null == x.right) {
            return x;
        }

        RBNode<K, V> y = x.right;
        y.parent = x.parent;
        if (null != x.parent) {
            if (x == x.parent.left) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }

        x.right = y.left;
        if (null != y.left) {
            y.left.parent = x;
        }

        x.parent = y;
        y.left = x;
        return y;
    }

    private RBNode<K, V> rightRotate(RBNode<K, V> x) {
        if (null == x || null == x.left) {
            return x;
        }

        RBNode<K, V> y = x.left;
        y.parent = x.parent;
        if (null != x.parent) {
            if (x == x.parent.left) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }

        x.left = y.right;
        if (null != y.right) {
            y.right.parent = x;
        }

        x.parent = y;
        y.right = x;
        return y;
    }

    private void insertFixUp(RBNode<K, V> x) {
        while (null != x
                && x.color == Color.Red
                && null != x.parent
                && null != x.parent.parent
                && x.parent.color == Color.Red) {
            RBNode<K, V> xp = x.parent, xpp = x.parent.parent;

            if (xp == xpp.left) {
                RBNode<K, V> xppr = xpp.right;
                if (null != xppr && xppr.color == Color.Red) {
                    xpp.color = Color.Red;
                    xppr.color = Color.Black;
                    xp.color = Color.Black;
                    x = xpp;
                } else {
                    if (x == xp.right) {
                        leftRotate(xp);
                        x = xp;
                        xp = x.parent;
                    }

                    rightRotate(xpp);
                    xp.color = Color.Black;
                    xp.left.color = Color.Red;
                    xp.right.color = Color.Red;

                    x = xp;
                    if (null == xp.parent) {
                        this.root = xp;
                    }
                }
            } else {
                RBNode<K, V> xppl = xpp.left;
                if (null != xppl && xppl.color == Color.Red) {
                    xpp.color = Color.Red;
                    xpp.left.color = Color.Black;
                    xpp.right.color = Color.Black;
                    x = xpp;
                } else {
                    if (x == xp.left) {
                        rightRotate(xp);
                        x = xp;
                        xp = x.parent;
                    }
                    leftRotate(xpp);
                    xp.color = Color.Black;
                    xp.right.color = Color.Red;
                    xp.left.color = Color.Red;

                    x = xp;

                    if (null == xp.parent) {
                        this.root = xp;
                    }
                }
            }
        }

        this.root.color = Color.Black;
    }

    enum Color {
        Red, Black
    }

    @Getter
    static class RBNode<K extends Comparable<K>, V> {
        private Color color;
        private RBNode<K, V> parent;
        private RBNode<K, V> left;
        private RBNode<K, V> right;

        private K key;
        private V val;

        RBNode(K key, V val, Color color) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.parent = null;
            this.left = this.right = null;
        }
    }
}
