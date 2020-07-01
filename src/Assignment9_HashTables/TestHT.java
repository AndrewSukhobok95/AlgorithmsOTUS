package Assignment9_HashTables;

public class TestHT {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        HashTableChain<String, Integer> ht = new HashTableChain<>();
        testInsert(ht);
        testSearch(ht);
        testDelete(ht);
        testRehash(ht);
    }

    public static void testInsert(HashTableChain<String, Integer> ht) {
        System.out.println("Test Insert:");
        String s = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < s.length(); i++){
            ht.insert(s.substring(i, i+1), i);
        }
        System.out.println(ht);
        System.out.println();
    }

    public static void testSearch(HashTableChain<String, Integer> ht) {
        System.out.println("Test Searching:");
        System.out.println("  HT[f] = " + ht.search("f"));
        System.out.println("  HT[a] = " + ht.search("a"));
        System.out.println("  HT[g] = " + ht.search("g"));
        System.out.println();
    }

    public static void testDelete(HashTableChain<String, Integer> ht) {
        System.out.println("Test Deleting:");
        System.out.println("  remove HT[x]: " + ht.delete("x"));
        System.out.println("  remove HT[q]: " + ht.delete("q"));
        System.out.println("  remove HT[g]: " + ht.delete("g"));
        System.out.println();
        System.out.println(ht);
        System.out.println();
    }

    public static void testRehash(HashTableChain<String, Integer> ht) {
        System.out.println("Test Rehashing:");
        ht.rehashTable(100);
        System.out.println(ht);
    }
}
