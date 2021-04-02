package com.wind.moon.search;

import java.util.HashSet;

public class SequentialSearchST<Key, Value> {
    private int N;
    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) return x.value;
        }
        return null;
    }

    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        N++;
    }

    public void delete(Key key) {
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            N--;
            return x.next;
        } else x.next = delete(x.next, key);
        return x;
    }

    public int size() {
        return this.N;
    }


    public Iterable<Key> keys() {
        HashSet<Key> keys = new HashSet<>();
        for (Node x = first; x != null; x = x.next) {
            keys.add(x.key);
        }
        return keys;
    }

    public static void main(String[] args) {
        SequentialSearchST<Integer, Object> st = new SequentialSearchST<>();
        int N = 5;
        for (int i = 0; i < N; i++) {
            st.put(i, i);
        }
        System.out.println(st.size());
        st.delete(1);
        st.delete(3);
        for (int i = 0; i < N; i++) {
            System.out.println(st.get(i));
        }
        System.out.println(st.size());
        System.out.println("=====");
        for (int i : st.keys()) {
            System.out.println(st.get(i));
        }
    }
}
