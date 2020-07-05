package Assignment9_HashTables;

import Assignment9_HashTables.List.LinkedList;
import Assignment9_HashTables.List.Node;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class HashTableChain<K,V> {
    private LinkedList<K, V>[] table;
    private int size = 0;
    private int n;

    public HashTableChain() {
        this(10);
    }

    private int roundN(int n) {
        if (n%10!=0) n = (int) pow(10, String.valueOf(n).length());
        return n;
    }

    public HashTableChain(int n) {
        this.n = roundN(n);
        table = new LinkedList[this.n];
        for (int i=0; i<n; i++)
            table[i] = new LinkedList<>();
    }

    public void rehashTable(int newN) {
        newN = roundN(newN);
        LinkedList<K, V>[] newTable = new LinkedList[newN];
        for (int i=0; i<newN; i++)
            newTable[i] = new LinkedList<>();

        for (int i=0; i<n; i++) {
            Node<K, V> current = table[i].getFirst();
            while (current!=null) {
                K key = current.getKey();
                int index = keyIndex(key, newN);
                newTable[index].addFirst(key, current.getValue());
                current = current.getNext();
            }
        }
        this.table = newTable;
        this.n = newN;
    }

    public int size() {
        return size;
    }

    private int keyIndex(K key, int n) {
        int hash = key.hashCode();
        return abs(hash % n);
    }

    public void insert(K key, V value) {
        int index = keyIndex(key, this.n);
        table[index].addFirst(key, value);
        size++;
    }

    public V delete(K key) {
        int index = keyIndex(key, this.n);
        return table[index].remove(key);
    }

    public V search(K key) {
        int index = keyIndex(key, this.n);
        return table[index].get(key);
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
}
