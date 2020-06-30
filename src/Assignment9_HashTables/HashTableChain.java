package Assignment9_HashTables;

import Assignment4_BaseStructs.List.LinkedList;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class HashTableChain<K,V> {
    private LinkedList<HTElement<K, V>>[] table;
    private int size = 0;
    private int n;

    public HashTableChain() {
        this(10);
    }

    public HashTableChain(int n) {
        if (n%10!=0) n = (int) pow(10, String.valueOf(n).length());
        this.n = n;
        table = new LinkedList[this.n];
        for (int i=0; i<n; i++)
            table[i] = new LinkedList<>();
    }

    public int size() {
        return size;
    }

    private int keyIndex(K key) {
        int hash = key.hashCode();
        return abs(hash % n);
    }

    public void insert(K key, V value) {
        int index = keyIndex(key);
        table[index].addFirst(new HTElement<>(key, value));
        size++;
    }

    public V delete(K key) {
        int index = keyIndex(key);
        LinkedList<HTElement<K, V>> ll = table[index];
        if (ll.isEmpty()) return null;
        //TODO
        return null;
    }

    public V search(K key) {
        //TODO
        //redo!
        int index = keyIndex(key);
        LinkedList<HTElement<K, V>> ll = table[index];
        if (ll.isEmpty()) return null;
        HTElement<K, V> hte;
        for (int i=0; i<ll.size(); i++) {
            hte = ll.get(i);
            if (hte.getKey().equals(key)) {
                return hte.getValue();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String s = "HashTable[\n";
        for (int i=0; i<table.length; i++) {
            s += "   " + i + ": " + table[i].toString() + "\n";
        }
        s += "]";
        return s;
    }

    static class HTElement<K,V> {
        private K key;
        private V value;

        public HTElement() {
            this(null, null);
        }

        public HTElement(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }
}
