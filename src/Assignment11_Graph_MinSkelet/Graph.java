package Assignment11_Graph_MinSkelet;

import Assignment11_Graph_MinSkelet.graphUtils.Edge;
import Assignment11_Graph_MinSkelet.graphUtils.SPP;
import Assignment11_Graph_MinSkelet.graphUtils.Vertex;

import java.util.Arrays;
import static java.util.Arrays.sort;

public class Graph {
    private int numEdges;
    private int numVertices;
    private Edge[] edges;
    private Vertex[] vertices;

    public Graph() {
        numEdges = 0;
        numVertices = 0;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public Edge[] findMST() {
        sort(edges);
        DSU verticesDSU = new DSU(numVertices);
        int numEdgesMST = 0;
        Edge[] mst = new Edge[numEdges];
        for (Edge e : edges) {
            int v1_key = e.getV1().getKey();
            int v2_key = e.getV2().getKey();
            if (verticesDSU.union(v1_key, v2_key)) {
                mst[numEdgesMST] = e;
                numEdgesMST++;
            }
        }
        return Arrays.copyOf(mst, numEdgesMST);
    }

    public Edge[] findShortPath(int start, int end) {
        if (vertices[start].getSpp() == null) {
            SPP spp = new SPP(vertices[start], this);
            vertices[start].setSpp(spp);
            return spp.getShortPath(end);
        }
        return vertices[start].getSpp().getShortPath(end);
    }

    public void readFromAdjVector(int[][][] AdjVector) {
        /*
        Example:
            3 vertices: v1, v2, v3
            3 edges:
                v1 - v2 weight 1
                v1 - v3 weight 3
                v2 - v3 weight 4
        Representation:
            {
                {{2,1},{2,3}},  // v1
                {{3,4}},        // v2
                {{}}            // v3
            }
        */
        for (int[][] v : AdjVector) {
            numVertices++;
            for (int[] e : v)
                if (e.length != 0) numEdges++;
        }

        this.vertices = new Vertex[numVertices];
        this.edges = new Edge[numEdges];

        for (int v = 0; v < numVertices; v++)
            vertices[v] = new Vertex(v);

        int edgeIndex = 0;
        for (int v = 0; v < numVertices; v++) {
            for (int[] e : AdjVector[v]) {
                if (e.length != 0) {
                    edges[edgeIndex] = new Edge(vertices[v], vertices[e[0]], e[1]);
                    edgeIndex++;
                }
            }
        }

        for (Edge e : edges) {
            vertices[e.getV1().getKey()].addEdge(e);
            vertices[e.getV2().getKey()].addEdge(e);
        }
    }

    @Override
    public String toString() {
        return "Graph (numEdges=" + numEdges + ", numVertices=" + numVertices + ") {" +
                "\n Edges=" + Arrays.toString(edges) +
                "\n Vertices=" + Arrays.toString(vertices) + "\n}";
    }
}
