package Assignment11_Graph_MinSkelet;

public class Vertex<K> {
    private K key;

    public Vertex(K key) {
        this.key = key;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key.toString();
    }
}
