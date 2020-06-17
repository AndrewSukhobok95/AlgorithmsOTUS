package Assignment7_TreeStructures;

public class TestTrees {
    public static void main(String[] args) {
        testBT();
        testAVL();
        testTreap();
    }

    public static void testBT() {
        System.out.println("+ Testing Simple Binary Tree:");
        BinaryTree<Integer, Integer> bt = new BinaryTree<>(true);
        Integer[] a = {5,3,8,2,4,6,10,9};
        for (Integer k : a) {
            bt.insert(k);
        }
        System.out.println("+++ " + bt);
        System.out.println("+++ " + bt.remove(9).getKey());
        System.out.println("+++ " + bt);
        System.out.println("+++ " + bt.remove(3).getKey());
        System.out.println("+++ " + bt);
        System.out.println("+++ " + bt.remove(5).getKey());
        System.out.println("+++ " + bt);
        System.out.println();
    }

    public static void testAVL() {
        System.out.println("+ Testing AVL Tree:");
        AVLTree<Integer, Integer> avl = new AVLTree<>(true);
        Integer[] a = {2,3,4,5,6,7,8,9,1,30,20,25,29,27,21,23,24,40,44,42,43,45,46,48,47};
        for (Integer k : a) {
            avl.insert(k);
        }
        System.out.println("+++ " + avl);
        System.out.println("+++ " + avl.remove(9).getKey());
        System.out.println("+++ " + avl);
        System.out.println("+++ " + avl.remove(3).getKey());
        System.out.println("+++ " + avl);
        System.out.println("+++ " + avl.remove(5).getKey());
        System.out.println("+++ " + avl);
        System.out.println();
    }

    public static void testTreap() {
        System.out.println("+ Testing Treap Tree:");
        Treap treap = new Treap();
        Integer[] a = {2,3,7,8,9,1,30,24,40,44,48,47};
        for (Integer k : a) {
            treap = treap.add(k);
        }
        System.out.println("+++ " + treap);
        treap = treap.remove(24);
        System.out.println("+++ 24");
        System.out.println("+++ " + treap);
        treap = treap.remove(8);
        System.out.println("+++ 8");
        System.out.println("+++ " + treap);
        treap = treap.remove(2);
        System.out.println("+++ 2");
        System.out.println("+++ " + treap);
        System.out.println();
    }
}
