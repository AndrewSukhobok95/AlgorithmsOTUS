package Assignment4_BaseStructs.List;

public class LinkedList<T> implements IList<T> {
    private int size = 0;
    private Node<T> first;
    private Node<T> last;
    private Node<T> current;
    private int current_iter = 0;

    public LinkedList() {
        first = null;
        last = null;
        current = first;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) return null;
        return first.getValue();
    }

    @Override
    public T getLast() {
        if (isEmpty()) return null;
        return last.getValue();
    }

    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.setPrevious(null);
        if (isEmpty()) {
            newNode.setNext(null);
            last = newNode;
        } else {
            newNode.setNext(first);
            first.setPrevious(newNode);
        }
        first = newNode;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.setNext(null);
        if (isEmpty()) {
            newNode.setPrevious(null);
            first = newNode;
        } else {
            newNode.setPrevious(last);
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) return null;
        T value = first.getValue();
        if (first.getNext()==null) {
            first = null;
            last = null;
        } else {
            first.getNext().setPrevious(null);
            first = first.getNext();
        }
        size--;
        return value;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) return null;
        T value = last.getValue();
        if (last.getPrevious()==null) {
            first = null;
            last = null;
        } else {
            last.getPrevious().setNext(null);
            last = last.getPrevious();
        }
        size--;
        return value;
    }

    static class NodeIter<T> {
        public Node<T> node;
        public int index;

        public NodeIter(Node<T> node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    private NodeIter<T> findNearestNode(int index) {
        int right_steps;
        int left_steps;
        if (current_iter >= index) {
            right_steps = current_iter - index;
            left_steps = index;
            if (right_steps >= left_steps) return new NodeIter(first, 0);
            return new NodeIter(current, current_iter);
        } else {
            right_steps = size - index - 1;
            left_steps = index - current_iter;
            if (right_steps >= left_steps) return new NodeIter(current, current_iter);
            return new NodeIter(last, size - 1);
        }
    }

    private Node<T> node(int index) {
        NodeIter<T> start = findNearestNode(index);
        current_iter = start.index;
        current = start.node;
        if (current==null) current = first;
        while (current_iter != index) {
            if (current_iter <= index) {
                current = current.getNext();
                current_iter++;
            } else {
                current = current.getPrevious();
                current_iter--;
            }
        }
        return current;
    }

    @Override
    public T get(int index) {
        if (isEmpty()) return null;
        if (index > size-1) index = size-1;
        Node<T> current = node(index);
        return current.getValue();
    }

    @Override
    public void add(T item, int index) {
        if (isEmpty()) {
            addFirst(item);
        } else if (index > size-1) {
            addLast(item);
        } else if (index == 0) {
            addFirst(item);
        } else {
            Node<T> newNode = new Node<>(item);
            current = node(index);
            newNode.setNext(current);
            newNode.setPrevious(current.getPrevious());
            current.getPrevious().setNext(newNode);
            current.setPrevious(newNode);
            size++;
        }
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public String toString() {
        String s = "LinkedList[ ";
        Node current = first;
        while (current != null) {
            s += current.getValue().toString() + " ";
            current = current.getNext();
        }
        s += "]";
        return s;
    }
}
