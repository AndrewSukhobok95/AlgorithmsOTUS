package Assignment5_Sorting;

public class Sort {

    public static void SelectionSort(int[] array) {
        /*
        Idea:
            Split array on sorted and unsorted parts
            Find local min (max) element in unsorted part
            Swap this element with first (last) element in unsorted part
            Repeat until all elements are sorted
         */
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
        /*
        Idea:
            Split array on sorted and unsorted parts
            Take first element in unsorted part
            Put this element in the appropriate place in sorted part
            Repeat until all elements are sorted
         */
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

    private static void gapInsertionSort(int[] arr, int gap) {
        for (int i=0; i<gap; i++) {
            for (int j=i; j<arr.length; j+=gap) {
                int cur = arr[j];
                int k = j - gap;
                while (k >= 0 && arr[k] > cur) {
                    arr[k + gap] = arr[k];
                    k = k - gap;
                }
                arr[k + gap] = cur;
            }
        }
    }

    public static void ShellSort(int[] array, int gap_type) {
        /*
        Idea:
            Perform Insertion sort with gap until gap = 1
        Time Complexity: O(N log(N)), O(N^2) - worst, O(N log^2(N)) - best
        Stability: False
        Online: False
        Adaptive: False
         */
        if (gap_type==0)
            for (int gap = array.length / 2; gap >= 1; gap = gap / 2)
                gapInsertionSort(array, gap);

        if (gap_type==1) {
            int k = 1;
            int gap;
            while (true) {
                gap = 2 * (int)(array.length / Math.pow(2, k+1)) + 1;
                gapInsertionSort(array, gap);
                k++;
                if (gap == 1) break;
            }
        }

        if (gap_type==2) {
            int k = array.length;
            int gap;
            while (true) {
                gap = (int)Math.pow(2, k) - 1;
                gapInsertionSort(array, gap);
                k--;
                if (k==-1) break;
            }
        }
    }

    public static void HeapSort(int[] array) {
        /*
        Idea:
            Create heap (element in root is higher then leafs)
            Change first element (root) (which is max) with last element
            Adjust the heap
            Repeat on the new heap without the last element
         */
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
