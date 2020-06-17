package Assignment7_TreeStructures;

public class Node<Key, Value> {
    private Key k;
    private Value v;
    private int height;
    private Node<Key, Value> left;
    private Node<Key, Value> right;
    private Node<Key, Value> parent;

    public Node(Key k) {
        this(k, null, 1, null, null, null);
    }

    public Node(Key k, Value v) {
        this(k, v, 1, null, null, null);
    }

    public Node(Key k, Value v, Node<Key, Value> parent) {
        this(k, v, 1, null, null, parent);
    }

    public Node(Key k, Value v, int h, Node<Key, Value> left, Node<Key, Value> right, Node<Key, Value> parent) {
        this.k = k;
        this.v = v;
        this.height = h;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public Key getKey() { return k; }
    public Value getValue() { return v; }
    public int getHeight() { return height; }
    public Node<Key, Value> getLeft() { return left; }
    public Node<Key, Value> getRight() { return right; }
    public Node<Key, Value> getParent() { return parent; }

    public void setKey(Key k) { this.k = k; }
    public void setValue(Value v) { this.v = v; }
    public void setHeight(int height) { this.height = height; }
    public void setLeft(Node<Key, Value> left) { this.left = left; }
    public void setRight(Node<Key, Value> right) { this.right = right; }
    public void setParent(Node<Key, Value> parent) { this.parent = parent; }

    @Override
    public String toString() {
        String s = "Node{ ";
        s += getKey();
        s += "   L{ ";
        s += toString(left);
        s += "}   R{ ";
        s += toString(right);
        s += " } }";
        return s;
    }

    String toString(Node<Key, Value> node) {
        if (node==null) return "";
        String s = "";
        s += node.getKey();
        s += " ";
        s += toString(node.getLeft());
        s += toString(node.getRight());
        return s;
    }
}
