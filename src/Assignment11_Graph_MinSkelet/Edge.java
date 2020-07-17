package Assignment11_Graph_MinSkelet;

public class Edge implements Comparable<Edge> {
    private Vertex v1;
    private Vertex v2;
    private int weight;

     Edge(Vertex v1, Vertex v2, int weight) {
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

    public int getWeight() {
        return weight;
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
