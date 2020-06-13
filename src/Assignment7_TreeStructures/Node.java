package Assignment7_TreeStructures;

public class Node<Key, Value> {
    private Key k;
    private Value v;
    private Node<Key, Value> left;
    private Node<Key, Value> right;
    private Node<Key, Value> parent;

    public Node(Key k) {
        this(k, null, null, null, null);
    }

    public Node(Key k, Value v) {
        this(k, v, null, null, null);
    }

    public Node(Key k, Value v, Node<Key, Value> left, Node<Key, Value> right, Node<Key, Value> parent) {
        this.k = k;
        this.v = v;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public Key getKey() { return k; }
    public Value getValue() { return v; }
    public Node<Key, Value> getLeft() { return left; }
    public Node<Key, Value> getRight() { return right; }
    public Node<Key, Value> getParent() { return parent; }

    public void setKey(Key k) { this.k = k; }
    public void setValue(Value v) { this.v = v; }
    public void setLeft(Node<Key, Value> left) { this.left = left; }
    public void setRight(Node<Key, Value> right) { this.right = right; }
    public void setParent(Node<Key, Value> parent) { this.parent = parent; }
}
