package Assignment11_Graph_MinSkelet;

public class TestDSU {
    public static void main(String[] args) {
        DSU dsu = new DSU(5);
        dsu.union(0,4);
        dsu.union(1,3);
        System.out.println(dsu);
    }
}
