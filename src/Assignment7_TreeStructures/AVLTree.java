package Assignment7_TreeStructures;

public class AVLTree<Key extends Comparable<Key>, Value> extends BinaryTree<Key, Value> {

    public AVLTree() {
        super();
    }

    public AVLTree(boolean printKey) {
        super(printKey);
    }

    int getHeight(Node<Key, Value> node) {
        return node==null ? 0 : node.getHeight();
    }

    void recalculateHeight(Node<Key, Value> node) {
        int hL = getHeight(node.getLeft());
        int hR = getHeight(node.getRight());
        int newH = Math.max(hL, hR) + 1;
        node.setHeight(newH);
    }

    int getBalance(Node<Key, Value> node) {
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    Node<Key, Value> rebalance(Node<Key, Value> node) {
        recalculateHeight(node);
        if (getBalance(node)>=2) {
            if (getBalance(node.getLeft())>=0) {
                return smallRightRotation(node);
            } else {
                return bigRightRotation(node);
            }
        }
        if (getBalance(node)<=-2) {
            if (getBalance(node.getRight())<=0) {
                return smallLeftRotation(node);
            } else {
                return bigLeftRotation(node);
            }
        }
        return node;
    }

    Node<Key, Value> smallRightRotation(Node<Key, Value> node) {
        Node<Key, Value> N = node.getLeft();
        Node<Key, Value> C = N.getRight();
        changeNodes(node, N);
        N.setRight(node);
        node.setParent(N);
        node.setLeft(C);
        if (C!=null) C.setParent(node);
        recalculateHeight(node);
        recalculateHeight(N);
        return N;
    }

    Node<Key, Value> smallLeftRotation(Node<Key, Value> node) {
        Node<Key, Value> N = node.getRight();
        Node<Key, Value> C = N.getLeft();
        changeNodes(node, N);
        N.setLeft(node);
        node.setParent(N);
        node.setRight(C);
        if (C!=null) C.setParent(node);
        recalculateHeight(node);
        recalculateHeight(N);
        return N;
    }

    private void changeNodes(Node<Key, Value> nodeP, Node<Key, Value> nodeC) {
        Node<Key, Value> P = nodeP.getParent();
        nodeC.setParent(P);
        if (P!=null && P.getLeft()!=null) {
            if (P.getLeft().getKey() == nodeP.getKey()) {
                P.setLeft(nodeC);
            } else {
                P.setRight(nodeC);
            }
        }
    }

    Node<Key, Value> bigRightRotation(Node<Key, Value> node) {
        smallLeftRotation(node.getLeft());
        return smallRightRotation(node);
    }

    Node<Key, Value> bigLeftRotation(Node<Key, Value> node) {
        smallRightRotation(node.getRight());
        return smallLeftRotation(node);
    }

    @Override
    Node<Key, Value> insert(Node<Key, Value> currentNode, Key k, Value v) {
        int comparisonResult = currentNode.getKey().compareTo(k);
        if (comparisonResult==0) {
            currentNode.setValue(v);
        } else if (comparisonResult>0) {
            if (currentNode.getLeft()==null) {
                Node<Key, Value> newNode = new Node<>(k, v, currentNode);
                currentNode.setLeft(newNode);
            } else {
                insert(currentNode.getLeft(), k, v);
            }
        } else {
            if (currentNode.getRight()==null) {
                Node<Key, Value> newNode = new Node<>(k, v, currentNode);
                currentNode.setRight(newNode);
            } else {
                insert(currentNode.getRight(), k, v);
            }
        }
        return rebalance(currentNode);
    }

    @Override
    void insert(Node<Key, Value> parentNode, Node<Key, Value> insertNode) {
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
        rebalance(insertNode);
    }

    @Override
    public String toString() {
        String s = "AVLTree{ ";
        s += toString(super.getRoot(), super.getPrintKey());
        s += " }";
        return s;
    }
}
