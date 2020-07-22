package Assignment12_Graph_ShortPath;

import Assignment11_Graph_MinSkelet.Graph;
import Assignment11_Graph_MinSkelet.graphUtils.Edge;

import java.util.Arrays;

public class TestDijkstra {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Graph G = new Graph();
        G.readFromAdjVector(getGraphAdjV());
        System.out.println("+ Shortest Path:");
        Edge[] path = G.findShortPath(6, 3);
        System.out.println(Arrays.toString(path));
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
