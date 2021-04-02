package com.wind.moon.search;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left, right;
        int N;
        boolean color;

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            N = n;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value value) {
        if (h == null) return new Node(key, value, 1, RED);

        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, value);
        else if (cmp > 0) h.right = put(h.right, key, value);
        else h.value = value;
        if (!isRed(h.left) && isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        if (cmp > 0) return get(x.right, key);
        return x.value;
    }

    public boolean isEmpty() {
        return root.N == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return size(x.left) + size(x.right) + 1;
    }

    public Key select(int i) {
        return select(root, i);
    }

    private Key select(Node x, int i) {
        if (x == null) return null;
        int cmp = i - size(x.left);
        if (cmp < 0) return select(x.left, i);
        if (cmp > 0) return select(x.right, i - size(x.left) - 1);
        return x.key;
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(x.left, key);
        if (cmp > 0) return rank(x.right, key);
        return size(x.left);
    }

    public Key floor(Key key) {
        return floor(root, key);
    }

    private Key floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return floor(x.left, key);
        if (cmp > 0) {
            Key t = floor(x.right, key);
            if (t != null) return t;
        }
        return x.key;
    }

    public Key ceiling(Key key) {
        return ceiling(root, key);
    }

    private Key ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) return ceiling(x.right, key);
        if (cmp < 0) {
            Key t = ceiling(x.left, key);
            if (t != null) return t;
        }
        return x.key;
    }

    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node deleteMin(Node h) {
        if (h.left == null) return null;
        if (!isRed(h.left)&&!isRed(h.left.left))
            h = moveRedLeft(h);
        h.left = deleteMin(h.left);
        return h;
    }

    private Node moveRedLeft(Node h) {
        flipColors(h);
        if (!isRed(h.left)&&!isRed(h.left.left))
            h = rotateRight(h);
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

}
