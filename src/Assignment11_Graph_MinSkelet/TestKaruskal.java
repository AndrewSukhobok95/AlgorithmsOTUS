package Assignment11_Graph_MinSkelet;

import java.util.Arrays;

public class TestKaruskal {
    public static void main(String[] args) {
        testKaruskalAlgorithm();
    }

    public static void testKaruskalAlgorithm() {
        System.out.println("Test Karuskal:");

        System.out.println("+ Graph structure:");
        Graph G = new Graph();
        G.readFromAdjVector(getGraphAdjV());
        System.out.println(G);
        System.out.println();

        System.out.println("+ Minimal Spanning Tree (MST):");
        System.out.println(Arrays.toString(G.findMST()));
        System.out.println();
    }

    public static int[][][] getGraphAdjV() {
        // { { vertex, weight }, ... }
        int[][][] G = {
                {{2,2}},               // 0
                {{2,3}},               // 1
                {{3,1},{4,1},{5,1}},   // 2
                {{6,6}},               // 3
                {{6,2}},               // 4
                {{7,5}},               // 5
                {{7,3}},               // 6
                {{}}                   // 7
        };
        return G;
    }
}
