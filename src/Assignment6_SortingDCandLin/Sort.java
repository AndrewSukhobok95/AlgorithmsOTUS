package Assignment6_SortingDCandLin;

/*
Described parameters od algorithms:
- Time Complexity
- Stable (true): don't change the relative position of equal elements
- Online (true): can work with part of the array (don't need full array)
- Adaptive (true): if array is (almost) sorted, then sorting will be faster
*/

public class Sort {
    public static void QuickSort(short[] arr) {
        /*
        Idea:
            split by greater then pivot and less then pivot
        Time Complexity: O(N log(N))
        Stable: False
        Online: False
        Adaptive: False
        */
        QuickSort(arr, 0, arr.length - 1);
    }

    public static void QuickSort(short[] arr, int start, int end) {
        if (end > start) {
            int[] ind = partition(arr, start, end);
            QuickSort(arr, start, ind[0]);
            QuickSort(arr, ind[1], end);
        }
    }

    private static int[] partition(short[] arr, int start, int end) {
        /*
        3-Way partitioning: split array into 3 parts:
            < pivot
            = pivot
            > pivot
        */
        short pivot = arr[end];

        int i = start - 1;
        int j = end;
        int pi = start - 1;
        int pj = end;

        while (true) {
            while (arr[++i] < pivot);

            while (arr[--j] > pivot)
                if (j==start) break;

            if (i >= j) break;

            swap(arr, i , j);

            if (arr[i] == pivot) {
                pi++;
                swap(arr, pi, i);
            }

            if (arr[j] == pivot) {
                pj--;
                swap(arr, pj, j);
            }
        }

        swap(arr, i, end);

        j = i-1;
        for (int k = start; k <= pi; k++, j--)
            swap(arr, k, j);

        i = i+1;
        for (int k = end - 1; k >= pj; k--, i++)
            swap(arr, k, i);

        return new int[]{j, i};
    }

    public static void MergeSort(short[] arr) {
        /*
        Idea:
            Recursive calls, merging sorted parts
        Time Complexity: O(N log(N))
        Stable: True
        Online: True
        Adaptive: False
        */
        MergeSort(arr, 0, arr.length - 1);
    }

    public static void MergeSort(short[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            MergeSort(arr, start, mid);
            MergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(short[] arr, int start, int mid, int end) {
        int sL = start;
        int eL = mid;
        int sR = mid + 1;
        int eR = end;

        int nL = eL - sL + 1;
        int nR = eR - sR + 1;

        short[] L = new short[nL];
        short[] R = new short[nR];
        System.arraycopy(arr, sL, L, 0, nL);
        System.arraycopy(arr, sR, R, 0, nR);

        int i=0, j=0, k=start;
        while (i < nL && j < nR) {
            if (L[i] < R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < nL) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < nR) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void RadixSort(short[] arr) {
        /*
        Idea:
            LSD (less significant direction) implementation
        Time Complexity: O(N)
        Stable: True
        Online: False
        Adaptive: False
        */
        short maxV = findMax(arr);
        for (int div=1; maxV / div > 0; div*=10)
            countSort(arr, div);
    }

    private static short findMax(short[] arr) {
        short maxV = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (arr[i]>maxV) maxV = arr[i];
        }
        return maxV;
    }

    private static void countSort(short[] arr, int div) {
        int[] countArr = {0,0,0,0,0,0,0,0,0,0};
        short[] resultArr = new short[arr.length];

        for (int i=0; i<arr.length; i++)
            countArr[(arr[i] / div) % 10]++;

        for (int i=1; i<10; i++)
            countArr[i] += countArr[i-1];

        for (int i=arr.length-1; i>=0; i--) {
            int divr = (arr[i] / div) % 10;
            resultArr[countArr[divr] - 1] = arr[i];
            countArr[divr]--;
        }

        System.arraycopy(resultArr, 0, arr, 0, arr.length);
    }

    private static void swap(short[] arr, int i1, int i2) {
        short tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}
