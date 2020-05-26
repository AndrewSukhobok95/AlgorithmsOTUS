package Assignment5_Sorting;

public class TestSort {
    public static void main(String[] args) {
        int[] array = {3,1,2,5,7,6,9,2,5,4,8,10};
        printArray(array);
        //Sort.SelectionSort(array);
        Sort.InsertionSort(array);
        //Sort.HeapSort(array);
        printArray(array);
    }

    public static void printArray(int[] array) {
        String s = "[ ";
        for (int i=0; i<array.length; i++)
            s += array[i] + " ";
        s += "]";
        System.out.println(s);
    }
}
