package Assignment5_Sorting;

public class Sort {

    public static void SelectionSort(int[] array) {
        for (int i=0; i<array.length; i++){
            int min_element = array[i];
            int min_ind = i;
            for (int j=i; j<array.length; j++) {
                if (array[j] < min_element) {
                    min_element = array[j];
                    min_ind = j;
                }
            }
            swap(array, i, min_ind);
        }
    }

    public static void InsertionSort(int[] array) {
        for (int i=0; i<array.length; i++) {
            int cur_element = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > cur_element) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = cur_element;
        }
    }

    public static void ShellSort(int[] array) {}

    public static void HeapSort(int[] array) {
        int size = array.length;
        int start_index = size / 2 - 1;

        for (int i=start_index; i>=0; i--)
            goDown(array, i, size);

        for (int i=size-1; i>=0; i--) {
            swap(array, 0, i);
            goDown(array, 0, i);
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

    private static void goDown(int[] arr, int root, int size) {
        int X = root;
        int L = 2 * root + 1;
        int R = L + 1;

        if (L < size && arr[L] > arr[X]) X = L;
        if (R < size && arr[R] > arr[X]) X = R;

        if (X == root) return;
        swap(arr, X, root);
        goDown(arr, X, size);
    }
}
