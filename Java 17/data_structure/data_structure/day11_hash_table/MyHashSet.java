package day11_hash_table;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MyHashSet {
    private static final int SIZE = 10000;
    private List<Node>[] buckets;

    public MyHashSet() {
        buckets = new List[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        // tim index
        int hashIndex = hashFunction(key);
        List<Node> bucket = buckets[hashIndex];
        Node node = new Node(key);
        int indexOfKey = bucket.indexOf(node);
        if (indexOfKey == -1) {
            bucket.add(node);
        }
    }

    public void remove(int key) {
        int hashIndex = hashFunction(key);
        List<Node> bucket = buckets[hashIndex];
        Node node = new Node(key);
        bucket.remove(node);
    }

    public boolean contains(int key) {
        int hashIndex = hashFunction(key);
        List<Node> bucket = buckets[hashIndex];
        Node node = new Node(key);
        int indexOfKey = bucket.indexOf(node);
        return indexOfKey >=0;
    }

    public int hashFunction(int key) {
        return key % SIZE;
    }

    static class Node {
        int key;

        public Node(int key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key;
        }

//        @Override
//        public int hashCode() {
//            return Objects.hash(key);
//        }
    }
}
