package Assignment5_Sorting;

import java.util.Random;

public class TestSort {
    public static void main(String[] args) {
        testAllSorting();
    }

    public static void testAllSorting() {
        System.out.println("Selection Sort:");
        int[] array = getRndArray(25);
        printArray(array);
        Sort.SelectionSort(array);
        printArray(array);
        System.out.println();

        System.out.println("Insertion Sort:");
        array = getRndArray(25);
        printArray(array);
        Sort.InsertionSort(array);
        printArray(array);
        System.out.println();

        System.out.println("Shell Sort (gap type 0):");
        array = getRndArray(25);
        printArray(array);
        Sort.ShellSort(array, 0);
        printArray(array);
        System.out.println();

        System.out.println("Shell Sort (gap type 1):");
        array = getRndArray(25);
        printArray(array);
        Sort.ShellSort(array, 1);
        printArray(array);
        System.out.println();

        System.out.println("Shell Sort (gap type 2):");
        array = getRndArray(25);
        printArray(array);
        Sort.ShellSort(array, 2);
        printArray(array);
        System.out.println();

        System.out.println("Heap Sort:");
        array = getRndArray(25);
        printArray(array);
        Sort.HeapSort(array);
        printArray(array);
    }

    public static int[] getRndArray(int size) {
        int[] arr = new int[size];
        Random rn = new Random();
        for (int i=0; i<size; i++) {
            arr[i] = rn.nextInt(100);
        }
        return arr;
    }

    public static void printArray(int[] array) {
        String s = "[ ";
        for (int i=0; i<array.length; i++)
            s += array[i] + " ";
        s += "]";
        System.out.println(s);
    }
}
