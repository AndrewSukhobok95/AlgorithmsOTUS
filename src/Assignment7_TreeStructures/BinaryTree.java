package Assignment7_TreeStructures;

public class BinaryTree<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;
    private int size = 0;
    private boolean printKey;

    public BinaryTree() {
        this(false);
    }

    public BinaryTree(boolean printKey) {
        this.printKey = printKey;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void insert(Key k) {
        insert(k, null);
    }

    public void insert(Key k, Value v) {
        if (isEmpty()) {
            root = new Node<>(k, v);
        } else {
            insert(root, k, v);
        }
        size++;
    }

    private void insert(Node<Key, Value> currentNode, Key k, Value v) {
        int comparisonResult = currentNode.getKey().compareTo(k);
        if (comparisonResult==0) {
            currentNode.setValue(v);
        } else if (comparisonResult>0) {
            if (currentNode.getLeft()==null) {
                currentNode.setLeft(new Node<>(k, v, null, null, currentNode));
            } else {
                insert(currentNode.getLeft(), k, v);
            }
        } else {
            if (currentNode.getRight()==null) {
                currentNode.setRight(new Node<>(k, v, null, null, currentNode));
            } else {
                insert(currentNode.getRight(), k, v);
            }
        }
    }

    public boolean search(Key k) {
        return !(get(root, k)==null);
    }

    public Node<Key, Value> get(Key k) {
        return get(root, k);
    }

    private Node<Key, Value> get(Node<Key, Value> current, Key k) {
        if (current==null) {
            return null;
        }
        int comparisonResult = current.getKey().compareTo(k);
        if (comparisonResult==0) {
            return current;
        } else if (comparisonResult>0) {
            return get(current.getLeft(), k);
        } else {
            return get(current.getRight(), k);
        }
    }

    public Node<Key, Value> remove(Key k) {
        if (isEmpty()) {
            return null;
        } else {
            Node<Key, Value> nodeToRemove = get(k);
            remove(nodeToRemove);
            return nodeToRemove;
        }
    }

    private void remove(Node<Key, Value> node) {
        if (node.getParent()==null) {
            Node<Key, Value> R = node.getRight();
            if (node.getLeft()!=null) {
                root = node.getLeft();
                if (R!=null) insert(root, R);
            } else {
                root = R;
            }
        } else {
            Node<Key, Value> P = node.getParent();
            if (P.getLeft().getKey()==node.getKey()) {
                P.setLeft(null);
            } else {
                P.setRight(null);
            }
            if (node.getLeft()!=null) insert(P, node.getLeft());
            if (node.getRight()!=null) insert(P, node.getRight());
        }
        node.setLeft(null);
        node.setRight(null);
        node.setParent(null);
        size--;
    }

    private void insert(Node<Key, Value> parentNode, Node<Key, Value> insertNode) {
        int comparisonResult = parentNode.getKey().compareTo(insertNode.getKey());
        if (comparisonResult==0) {
            System.out.println("WARNING: Nodes with identical keys.");
            System.out.println("         insertNode was not inserted.");
        } else if (comparisonResult>0) {
            if (parentNode.getLeft()==null) {
                parentNode.setLeft(insertNode);
                insertNode.setParent(parentNode);
            } else {
                insert(parentNode.getLeft(), insertNode);
            }
        } else {
            if (parentNode.getRight()==null) {
                parentNode.setRight(insertNode);
                insertNode.setParent(parentNode);
            } else {
                insert(parentNode.getRight(), insertNode);
            }
        }
    }

    @Override
    public String toString() {
        String s = "BinaryTree{ ";
        s += toString(root, printKey);
        s += "}";
        return s;
    }

    private String toString(Node<Key, Value> node, boolean printKey) {
        if (node==null) return "";
        String s = "";
        if (printKey) {
            s += node.getKey() + " ";
        } else {
            s += node.getValue() + " ";
        }
        s += toString(node.getLeft(), printKey);
        s += toString(node.getRight(), printKey);
        return s;
    }
}
