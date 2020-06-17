package Assignment4_BaseStructs;

import Assignment4_BaseStructs.List.LinkedList;

public class TestList {
    public static void main(String[] args) {
        testListStructures();
    }

    public static void testListStructures() {
        LinkedList<Integer> ll = new LinkedList<>();
        testAddFL(ll, false);
        testAdd(ll, false);
        testGet(ll, false);
        testRemoveFL(ll, true);
        testGetFL(ll, false);
        System.out.println();
    }

    public static void testAddFL(LinkedList<Integer> ll, boolean clear) {
        System.out.println("Testing addFirst / addLast:");
        for (int i=4; i<9; i++) {
            ll.addLast(i);
        }
        for (int i=3; i>0; i--) {
            ll.addFirst(i);
        }
        System.out.println("  " + ll);
        if (clear) ll.clear();
    }

    public static void testAdd(LinkedList<Integer> ll, boolean clear) {
        System.out.println("Testing add:");
        ll.add(99, 0);
        ll.add(99, 2);
        ll.add(99, 100);
        System.out.println("  " + ll);
        if (clear) ll.clear();
    }

    public static void testRemoveFL(LinkedList<Integer> ll, boolean clear) {
        System.out.println("Testing removeFirst / removeLast:");
        int cur_size = ll.size();
        for (int i=0; i<cur_size; i++)
            System.out.println("  Removed element: " + ll.removeLast());
        System.out.println("  Removed element: " + ll.removeLast());
        System.out.println("  " + ll);
        if (clear) ll.clear();
    }

    public static void testGetFL(LinkedList<Integer> ll, boolean clear) {
        System.out.println("Testing getFirst / getLast:");
        System.out.println("  " + ll);
        System.out.println("  First element = " + ll.getFirst());
        System.out.println("  Last element = " + ll.getLast());
        if (clear) ll.clear();
    }

    public static void testGet(LinkedList<Integer> ll, boolean clear) {
        System.out.println("Testing get:");
        System.out.println("  0 element = " + ll.get(0));
        System.out.println("  3 element = " + ll.get(3));
        System.out.println("  last (100) element = " + ll.get(100));
        if (clear) ll.clear();
    }
}
