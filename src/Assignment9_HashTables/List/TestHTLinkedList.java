package Assignment9_HashTables.List;

public class TestHTLinkedList {
    public static void main(String[] args) {
        HTLinkedList<String, Integer> ll = new HTLinkedList<>();
        ll.addFirst("c", 3);
        ll.addFirst("b", 2);
        ll.addFirst("a", 1);
        ll.addLast("d", 4);
        ll.addLast("e", 5);
        System.out.println(ll);
        System.out.println();

        System.out.println("ll[b] = " + ll.get("b"));
        System.out.println("ll[d] = " + ll.get("d"));
        System.out.println("ll[a] = " + ll.get("a"));
        System.out.println("ll[e] = " + ll.get("e"));
        System.out.println();

        System.out.println("remove ll[a]: " + ll.remove("a"));
        System.out.println("remove ll[e]: " + ll.remove("e"));
        System.out.println("remove ll[c]: " + ll.remove("c"));
        System.out.println("remove ll[k]: " + ll.remove("k"));
        System.out.println();

        System.out.println(ll);
    }
}
