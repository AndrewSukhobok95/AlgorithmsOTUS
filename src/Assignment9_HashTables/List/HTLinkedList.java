package Assignment9_HashTables.List;

public class HTLinkedList<K,V> {
    private int size = 0;
    private Node<K,V> first;
    private Node<K,V> last;

    public HTLinkedList() {
        first = null;
        last = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return last == null;
    }

    public V get(K key) {
        Node<K,V> current = find(key);
        if (current==null) return null;
        return current.getValue();
    }

    public Node<K, V> getFirst() { return first; }

    public V remove(K key) {
        Node<K,V> toRemove = find(key);
        if (toRemove==null) return null;
        if (size==1) {
            removeFirst();
        } else if (toRemove.getNext()==null) {
            removeLast();
        } else if (toRemove.getPrevious()==null) {
            removeFirst();
        } else {
            toRemove.getPrevious().setNext(toRemove.getNext());
            toRemove.getNext().setPrevious(toRemove.getPrevious());
            size--;
        }
        toRemove.setNext(null);
        toRemove.setPrevious(null);
        return toRemove.getValue();
    }

    public Node<K,V> find(K key) {
        if (isEmpty()) return null;
        Node<K,V> current = first;
        while (!current.getKey().equals(key)) {
            current = current.getNext();
            if (current==null) return null;
        }
        return current;
    }

    public void addFirst(K key, V value) {
        Node<K,V> newNode = new Node<>(key, value);
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

    public void addLast(K key, V value) {
        Node<K,V> newNode = new Node<>(key, value);
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

    public V removeFirst() {
        if (isEmpty()) return null;
        V value = first.getValue();
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

    public V removeLast() {
        if (isEmpty()) return null;
        V value = last.getValue();
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

    @Override
    public String toString() {
        String s = "LinkedList[ ";
        Node<K,V> current = first;
        while (current != null) {
            s += "(" + current.getKey().toString() + ", " + current.getValue().toString() + ") ";
            current = current.getNext();
        }
        s += "]";
        return s;
    }
}
