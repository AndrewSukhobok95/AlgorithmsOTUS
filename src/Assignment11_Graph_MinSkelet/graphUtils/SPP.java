package Assignment11_Graph_MinSkelet.graphUtils;

import Assignment11_Graph_MinSkelet.Graph;

import java.util.Iterator;
import java.util.Stack;

public class SPP {
    private Vertex startVertex;
    private Graph G;
    private boolean[] usedV;
    private int[] parentV;
    private double[] distToV;
    private int numVertices;
    private final double INF = Double.MAX_VALUE;

    public SPP(Vertex startVertex, Graph G) {
        this.startVertex = startVertex;
        this.G = G;
        this.numVertices = G.getNumVertices();
        usedV = new boolean[numVertices];
        parentV = new int[numVertices];
        distToV = new double[numVertices];
        for (int i=0; i<numVertices; i++) {
            distToV[i] = INF;
            parentV[i] = -1;
        }
        distToV[startVertex.getKey()] = 0;
        buildMap();
    }

    public Edge[] getShortPath(int endVKey) {
        Vertex[] vertices = G.getVertices();
        Stack<Edge> path = new Stack<>();
        int i = endVKey;
        while (i != startVertex.getKey()) {
            path.push(vertices[i].getEdge(i, parentV[i]));
            i = parentV[i];
        }
        Edge[] pathArray = new Edge[path.size()];
        return path.toArray(pathArray);
    }

    private void buildMap() {
        Vertex current;
        Vertex[] vertices = G.getVertices();
        while (true) {
            int v = -1;
            for (int nv=0; nv<numVertices; nv++) {
                if (!usedV[nv] && distToV[nv] < INF && (v == -1 || distToV[nv] < distToV[v]))
                    v = nv;
            }
            if (v == -1) break;
            usedV[v] = true;
            current = vertices[v];
            Iterator<Edge> edgesIter = current.edgesIterator();
            while (edgesIter.hasNext()) {
                Edge e = edgesIter.next();
                int nv = getAlternativeVertexKey(v, e);
                if (!usedV[nv] && distToV[v] + e.getWeight() < distToV[nv]) {
                    distToV[nv] = distToV[v] + e.getWeight();
                    parentV[nv] = v;
                }
            }
        }
    }

    private int getAlternativeVertexKey(int currentKey, Edge e) {
        if (currentKey == e.getV1().getKey())
            return e.getV2().getKey();
        return e.getV1().getKey();
    }
}
