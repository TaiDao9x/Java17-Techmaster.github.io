package day11_hash_table;

import java.util.LinkedList;
import java.util.List;

public class MyHashMap {

    private static final int SIZE = 10000;
    // Array of buckets
    private List<Node>[] buckets;

    public MyHashMap() {
        buckets = new List[SIZE];
//        for (int i = 0; i < SIZE; i++) {
//            buckets[i] = new LinkedList<>();
//        }
    }

    public void put(int key, int value) {

        // bien key thanh 1 index: hashfunction
        int hashIndex = hashFunction(key);
        // lay ra bucket de chua key
        List<Node> bucket = buckets[hashIndex];
        if (bucket == null) {
            List<Node> newBucket = new LinkedList<>();
            buckets[hashIndex] = newBucket;
            bucket = newBucket;
        }

        // neu bucket chua co key nay
        // check xem cos node nay chua
        Node node = new Node(key, value);
        int indexOfKey = bucket.indexOf(node);
        if (indexOfKey == -1) {
            bucket.add(node);
        } else {
            bucket.get(indexOfKey).value = value;
        }
//        if (bucket.contains(node)) {
//            // bucket da chua key
//            // ghi de value moi
//            int indexOfKey = bucket.indexOf(node);
//            bucket.get(indexOfKey).value = value;
//        } else {
//            // chua co key nay, chi can add
//            bucket.add(node);
//        }

        // neu bucket da co key nay
    }

    public int get(int key) {
        // tim hashIndex
        int hashIndex = hashFunction(key);
        List<Node> bucket = buckets[hashIndex];
        // neu bucket chua co key nay
        // check xem cos node nay chua
        Node node = new Node(key, -1);
        int indexOfKey = bucket.indexOf(node);
        if (indexOfKey == -1) {
            return -1;
        } else {
            return bucket.get(indexOfKey).value;
        }
    }

    public void remove(int key) {
        // tim hashIndex
        int hashIndex = hashFunction(key);
        List<Node> bucket = buckets[hashIndex];
        Node node = new Node(key, -1);
        int indexOfKey = bucket.indexOf(node);
        if (indexOfKey == -1) {
            return;
        } else {
            bucket.remove(node);
        }
    }

    // hash
    private int hashFunction(int key) {
        return key % SIZE;
    }

    static class Node {
        public int key, value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return this.key == node.key;
        }

//        @Override
//        public int hashCode() {
//            return Objects.hash(key, value);
//        }

    }
}
