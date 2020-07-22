package Assignment11_Graph_MinSkelet.graphUtils;

public class Edge implements Comparable<Edge> {
    private Vertex v1;
    private Vertex v2;
    private double weight;

     public Edge(Vertex v1, Vertex v2, int weight) {
         this.v1 = v1;
         this.v2 = v2;
         this.weight = weight;
     }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }

    public double getWeight() {
        return weight;
    }

    public boolean hasVertex(int vertexKey) {
        return vertexKey == v1.getKey() || vertexKey == v2.getKey();
    }

    @Override
    public int compareTo(Edge edge) {
        if (this.weight != edge.weight)
            return this.weight < edge.weight ? -1 : 1;
        return 0;
    }

    @Override
    public String toString() {
        return "E{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", w=" + weight +
                '}';
    }
}
