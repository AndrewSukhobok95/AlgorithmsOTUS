package Assignment11_Graph_MinSkelet.graphUtils;

import java.util.Iterator;
import java.util.LinkedList;

public class Vertex {
    private int key;
    private LinkedList<Edge> edges;
    private SPP spp = null;

    public Vertex(int key) {
        this.key = key;
        this.edges = new LinkedList<>();
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public SPP getSpp() {
        return spp;
    }

    public void setSpp(SPP spp) {
        this.spp = spp;
    }

    public void addEdge(Edge e) {
        edges.add(e);
    }

    public Edge getEdge(int key1, int key2) {
        Iterator<Edge> edgesIter = edgesIterator();
        while (edgesIter.hasNext()) {
            Edge e = edgesIter.next();
            if (e.hasVertex(key1) && e.hasVertex(key2))
                return e;
        }
        return null;
    }

    public Iterator<Edge> edgesIterator() {
        return edges.listIterator();
    }

    @Override
    public String toString() {
        return Integer.toString(key);
    }
}
