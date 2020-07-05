package Assignment10_GraphTopSort_Demurkon;

import java.util.Arrays;

public class TestTopSort {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        System.out.println("Test Demurkon Topological Sort:");

        int[][] gav = getGraphAdjV();

        Graph G = new Graph(gav.length);
        G.setAdjVector(gav);
        G.convertAdjVectorToAdjMatrix();

        G.printAdjVector();
        G.printAdjMatrix();

        int[][] sortedNodes = G.topSortDemurkon();
        System.out.println("Levels: " + Arrays.deepToString(sortedNodes));
    }

    public static int[][] getGraphAdjV() {
        int[][] G = {
                {2},       // 0
                {2},       // 1
                {3,4,5},   // 2
                {6},       // 3
                {6},       // 4
                {7},       // 5
                {7},       // 6
                {}         // 7
        };
        return G;
    }
}
