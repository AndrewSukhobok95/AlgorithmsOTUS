package Assignment11_Graph_MinSkelet;

import java.util.Arrays;

public class DSU {
    private int[] set;
    private int[] rank;

    public DSU(int n) {
        set = new int[n];
        rank = new int[n];
        for (int i=0; i<n; i++)
            set[i] = i;
    }

    public int find(int key) {
        if (key==set[key])
            return key;
        set[key] = find(set[key]);
        return set[key];
    }

    public boolean union(int key1, int key2) {
        int setRoot1 = find(key1);
        int setRoot2 = find(key2);
        if (setRoot1!=setRoot2) {
            if (rank[setRoot1] < rank[setRoot2]) {
                int tmp = setRoot1;
                setRoot1 = setRoot2;
                setRoot2 = tmp;
            }
            set[setRoot2] = setRoot1;
            rank[setRoot1] += rank[setRoot2];
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "DSU{" +
                "set=" + Arrays.toString(set) +
                '}';
    }
}
