package Assignment4_BaseStructs;

import Assignment4_BaseStructs.Array.IArray;
import Assignment4_BaseStructs.Array.SingleArray;
import Assignment4_BaseStructs.Array.FactorArray;
//import Assignment4_BaseStructs.Array.VectorArray;
import Assignment4_BaseStructs.Array.MatrixArray;

import java.util.Random;

public class TestArray {

    public static void main(String[] args) {
        testArrayStructures();
    }

    public static void testArrayStructures() {
        System.out.println("SingleArray Testing:");
        IArray<Integer> singleArray = new SingleArray<Integer>();

        testAddIndexArray(singleArray, 4, 10);
        testAddIndexArray(singleArray, 0, 10);
        testAddIndexArray(singleArray, 10, 10);
        testAddIndexArray(singleArray, 100, 10);
        testRemoveIndexArray(singleArray, 5, 10);
        testRemoveIndexArray(singleArray, 0, 10);
        testRemoveIndexArray(singleArray, 10, 10);
        testRemoveIndexArray(singleArray, 100, 10);

        testAddIndexArray(singleArray, 4, 10, false);
        testRemoveIndexArray(singleArray, 5, 0, false);
        testRemoveIndexArray(singleArray, 2, 0, false);
        testAddIndexArray(singleArray, 3, 0, true);

        System.out.println("\nFactorArray Testing:");
        IArray<Integer> factorArray = new FactorArray<Integer>();

        testAddIndexArray(factorArray, 4, 10);
        testAddIndexArray(factorArray, 0, 10);
        testAddIndexArray(factorArray, 10, 10);
        testAddIndexArray(factorArray, 100, 10);
        testRemoveIndexArray(factorArray, 5, 10);
        testRemoveIndexArray(factorArray, 0, 10);
        testRemoveIndexArray(factorArray, 10, 10);
        testRemoveIndexArray(factorArray, 100, 10);

        System.out.println("\nMatrixArray Testing:");
        IArray matrixArray = new MatrixArray(3);
        testAddIndexArray(matrixArray, 4, 10);
        testAddIndexArray(matrixArray, 0, 10);
        testAddIndexArray(matrixArray, 10, 10);
        testAddIndexArray(matrixArray, 100, 10);
        testRemoveIndexArray(matrixArray, 5, 10);
        testRemoveIndexArray(matrixArray, 0, 10);
        testRemoveIndexArray(matrixArray, 10, 10);
        testRemoveIndexArray(matrixArray, 100, 10);

        System.out.println("\nAdd method testing:");
        testAddArray(singleArray, 10_000);
        testAddArray(factorArray, 10_000);
        testAddArray(matrixArray, 10_000);
        System.out.println();
    }

    private static void testAddArray(IArray<Integer> array, int total) {
        testAddArray(array, total, true);
    }

    private static void testAddArray(IArray<Integer> array, int total, boolean clear) {
        long start = System.currentTimeMillis();
        for (int j = 0; j < total; j++)
            array.add(1);
        System.out.println("   " + array.getClass().getCanonicalName() +
                ": time for adding = " + (System.currentTimeMillis() - start));
        if (clear) array.clear();
    }

    private static void testAddIndexArray(IArray<Integer> array, int index, int total) {
        testAddIndexArray(array, index, total, true);
    }

    private static void testAddIndexArray(IArray<Integer> array, int index, int total, boolean clear) {
        System.out.println(String.format("+ Testing add(item=99999, index=%s) for Array:", index));
        System.out.print("   Array before adding: ");
        Random rn = new Random();
        for (int i=0; i<total; i++)
            array.add(rn.nextInt(100));
        System.out.println(array);
        array.add(99999, index);
        System.out.print("   Array after adding: ");
        System.out.println(array);
        System.out.println();
        if (clear) array.clear();
    }

    private static void testRemoveIndexArray(IArray<Integer> array, int index, int total) {
        testRemoveIndexArray(array, index, total, true);
    }

    private static void testRemoveIndexArray(IArray<Integer> array, int index, int total, boolean clear) {
        System.out.println(String.format("+ Testing remove(index=%s) for Array:", index));
        System.out.print("   Array before removing: ");
        Random rn = new Random();
        for (int i=0; i<total; i++)
            array.add(rn.nextInt(100));
        System.out.println(array);
        System.out.println("   Deleted element: " + array.remove(index));
        System.out.print("   Array after removing: ");
        System.out.println(array);
        System.out.println();
        if (clear) array.clear();
    }
}
