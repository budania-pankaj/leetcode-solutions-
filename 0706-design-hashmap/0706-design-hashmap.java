import java.util.*;

class Pair<U, V> {
    U first;
    V second;

    public Pair(U f, V s) {
        first = f;
        second = s;
    }
}

class Bucket {
    private LinkedList<Pair<Integer, Integer>> list;

    public Bucket() {
        list = new LinkedList<>();
    }

    public int get(int key) {
        for (Pair<Integer, Integer> p : list) {
            if (p.first == key) {
                return p.second;
            }
        }
        return -1; // key not found
    }

    public void put(int key, int value) {
        for (Pair<Integer, Integer> p : list) {
            if (p.first == key) {
                p.second = value;
                return;
            }
        }
        list.addFirst(new Pair<>(key, value));
    }

    public void remove(int key) {
        list.removeIf(p -> p.first == key);
    }
}

class MyHashMap {
    private Bucket[] buckets;
    private int keyRange = 769;

    public MyHashMap() {
        buckets = new Bucket[keyRange]; // allocate the array first
        for (int i = 0; i < keyRange; i++) {
            buckets[i] = new Bucket();
        }
    }

    private int getBucketIndex(int key) {
        return key % keyRange;
    }

    public void put(int key, int value) {
        buckets[getBucketIndex(key)].put(key, value);
    }

    public int get(int key) {
        return buckets[getBucketIndex(key)].get(key);
    }

    public void remove(int key) {
        buckets[getBucketIndex(key)].remove(key);
    }
}