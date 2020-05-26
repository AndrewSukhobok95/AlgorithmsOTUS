package Assignment4_BaseStructs.List;

public class Node<T> {
    private T item;
    private Node<T> next;
    private Node<T> previous;

    public Node(T item) {
        this(item, null, null);
    }

    public Node(T item, Node<T> next, Node<T> previous) {
        this.item = item;
        this.next = next;
        this.previous = previous;
    }

    public T getValue() {
        return item;
    }

    public void setValue(T item) {
        this.item = item;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}
