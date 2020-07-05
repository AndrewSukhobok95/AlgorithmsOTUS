package Assignment10_GraphTopSort_Demurkon;

public class Graph {
    private int n;
    private int[][] GAdjV;
    private int[][] GAdjM;
    private boolean[] checkedNodes;
    private int nChecked;

    public Graph(int n) {
        this.n = n;
        GAdjV = new int[this.n][];
        GAdjM = new int[this.n][this.n];
        checkedNodes = new boolean[this.n];
        nChecked = 0;
    }

    public void setAdjVector(int[][] av) { this.GAdjV = av; }
    public void setAdjMatrix(int[][] am) { this.GAdjM = am; }
    public int[][] getAdjVector() { return this.GAdjV; }
    public int[][] getAdjMatrix() { return this.GAdjM; }

    public void convertAdjVectorToAdjMatrix() {
        for (int i=0; i<GAdjV.length; i++) {
            int[] curN = GAdjV[i];
            for (int value : curN) {
                GAdjM[i][value] = 1;
            }
        }
    }

    public int[][] topSortDemurkon() {
        int[][] sortedNodesFull = new int[n][];

        int[] colSum = sumColumns(GAdjM);

        int level = 0;
        while (!allNodesChecked()) {
            int[] nodesToDelete = getUncheckedZeros(colSum);
            colSum = updateColSum(colSum, nodesToDelete);
            sortedNodesFull[level] = nodesToDelete;
            level++;
        }

        int[][] sortedNodes = new int[level][];
        for (int i=0; i<level; i++) {
            sortedNodes[i] = sortedNodesFull[i];
        }
        return sortedNodes;
    }

    private static int[] sumColumns(int[][] M) {
        int[] colSum = new int[M.length];
        for (int i=0; i<M.length; i++) {
            for (int j=0; j<M.length; j++) {
                colSum[i] += M[j][i];
            }
        }
        return colSum;
    }

    private int[] updateColSum(int[] colSum, int[] rowsToDelete) {
        for (int r : rowsToDelete) {
            int[] curRow = GAdjM[r];
            for (int i=0; i<n; i++){
                colSum[i] -= curRow[i];
            }
        }
        return colSum;
    }

    private boolean allNodesChecked() { return n==nChecked; }

    private int[] getUncheckedZeros(int[] src) {
        int[] zeros = new int[n];
        int nz = 0;
        for (int i=0; i<src.length; i++) {
            if (src[i]==0 && !checkedNodes[i]) {
                zeros[nz] = i;
                nz++;
                checkedNodes[i] = true;
                nChecked++;
            }
        }
        return cut(zeros, nz);
    }

    private static int[] cut(int[] src, int n) {
        int[] tgt = new int[n];
        System.arraycopy(src, 0, tgt, 0, n);
        return tgt;
    }

    public void printAdjVector() {
        System.out.println("Adjacency Vector:");
        for (int i=0; i<GAdjV.length; i++) {
            int[] curN = GAdjV[i];
            System.out.print("Node " + i + ": ");
            for (int value : curN) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printAdjMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i=0; i<GAdjM.length; i++) {
            int[] curN = GAdjM[i];
            for (int value : curN) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
