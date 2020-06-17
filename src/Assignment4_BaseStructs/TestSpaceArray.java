package Assignment4_BaseStructs;

import Assignment4_BaseStructs.Array.SpaceArray;

import java.util.Random;

public class TestSpaceArray {
    public static void main(String[] args) {
        testSpaceArray();
    }

    public static void testSpaceArray() {
        SpaceArray<Integer> sa = new SpaceArray<Integer>(4, 2);
        Random rn = new Random();
        for (int i=0; i<7; i++)
            sa.add(rn.nextInt(100));
        System.out.println(sa);

        System.out.println("  Element 0 = " + sa.get(0));
        System.out.println("  Element 3 = " + sa.get(3));
        System.out.println("  Element 100 (last) = " + sa.get(100));

        for (int i=199; i>190; i--)
            sa.add(i, 3);

        System.out.println(sa);

        for (int i=0; i<5; i++)
            System.out.println("  Removed element = " + sa.remove(6));

        System.out.println(sa);

        sa.clear();

        System.out.println(sa);
        System.out.println();
    }
}
