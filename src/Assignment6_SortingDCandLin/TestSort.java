package Assignment6_SortingDCandLin;

import java.util.Random;

public class TestSort {
    public static void main(String[] args) {
        System.out.println("Test QuickSort:");
        short[] arr = createRandomArray(20, 15);
        printArray(arr);
        Sort.QuickSort(arr);
        printArray(arr);

        System.out.println("Test MergeSort:");
        arr = createRandomArray(20, 15);
        printArray(arr);
        Sort.MergeSort(arr);
        printArray(arr);

        System.out.println("Test RadixSort:");
        arr = createRandomArray(20, 15);
        printArray(arr);
        Sort.RadixSort(arr);
        printArray(arr);
    }

    public static short[] createRandomArray(int n, int max_val) {
        short[] arr = new short[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = (short) random.nextInt(max_val);
        }
        return arr;
    }

    public static void printArray(short[] array) {
        String s = "[ ";
        for (int i=0; i<array.length; i++) {
            s += array[i] + " ";
        }
        s += "]";
        System.out.println(s);
    }
}
