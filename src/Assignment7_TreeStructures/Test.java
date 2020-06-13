package Assignment7_TreeStructures;

public class Test {
    public static void main(String[] args) {
        testBT();
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
}
