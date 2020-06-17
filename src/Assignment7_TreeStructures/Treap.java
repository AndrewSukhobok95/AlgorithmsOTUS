package Assignment7_TreeStructures;

import java.util.Random;

public class Treap {
    private int k, krand;
    private Treap left, right;
    private int size;
    public Random rand = new Random();;

    public Treap() {
        this.size = 0;
    }

    public Treap(int k, int krand) {
        this.k = k;
        this.krand = krand;
        this.left = null;
        this.right = null;
        this.size = 1;
    }

    public Treap(int k, int krand, Treap left, Treap right) {
        this.k = k;
        this.krand = krand;
        this.left = left;
        this.right = right;
        this.size = 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int getKey() {
        return k;
    }

    public Treap getLeft() {
        return left;
    }

    public Treap getRight() {
        return right;
    }

    private void setSize(int size) {
        this.size = size;
    }

    private static int getSize(Treap t) {
        return t==null ? 0 : t.size();
    }

    public Treap add(int key) {
        if (isEmpty()) {
            Treap newT = new Treap(key, rand.nextInt());
            newT.setSize(1);
            return newT;
        }
        TreapPair pairLR = split(key);
        Treap L = pairLR.getFirst();
        Treap R = pairLR.getSecond();
        Treap m = new Treap(key, rand.nextInt());
        return merge(merge(L, m), R);
    }

    public Treap remove(int k) {
        Treap L, R;
        TreapPair pairLR = split(k-1);
        L = pairLR.getFirst();
        TreapPair pairMR = split(k);
        R = pairMR.getSecond();
        return merge(L, R);
    }

    public static Treap merge(Treap L, Treap R) {
        if (L==null) return R;
        if (R==null) return L;

        if (L.krand > R.krand) {
            Treap newR = merge(L.right, R);
            Treap newTreap = new Treap(L.k, L.krand, L.left, newR);
            newTreap.setSize(getSize(L.left) + getSize(newR));
            return newTreap;
        } else {
            Treap newL = merge(L, R.left);
            Treap newTreap = new Treap(R.k, R.krand, newL, R.right);
            newTreap.setSize(getSize(newL) + getSize(R.right));
            return newTreap;
        }
    }

    private TreapPair split(int k) {
        Treap L = null;
        Treap R = null;
        if (this.k <= k) {
            TreapPair pairNewR = new TreapPair(null, null);
            if (this.right!=null) {
                pairNewR = this.right.split(k);
                R = pairNewR.getSecond();
            }
            L = new Treap(this.k, this.krand, this.left, pairNewR.getFirst());
        } else {
            TreapPair pairLNew = new TreapPair(null, null);
            if (this.left!=null) {
                pairLNew = this.left.split(k);
                L = pairLNew.getFirst();
            }
            R = new Treap(this.k, this.krand, pairLNew.getSecond(), this.right);
        }
        return new TreapPair(L, R);
    }

    private static class TreapPair {
        private Treap first;
        private Treap second;

        public TreapPair(Treap first, Treap second) {
            this.first = first;
            this.second = second;
        }

        public Treap getFirst() { return first; }
        public Treap getSecond() { return second; }
    }

    @Override
    public String toString() {
        String s = "Treap{ ";
        s += toString(this, false);
        s += " }\n    Values sequence: ";
        s += toString(this, true);
        return s;
    }

    String toString(Treap t, boolean seqType) {
        if (t==null) return "";
        String s = "";
        s += t.getKey();
        if (seqType) {
            s += " ";
            s += toString(t.getLeft(), seqType);
            s += toString(t.getRight(), seqType);
        } else {
            String sL = toString(t.getLeft(), seqType);
            String sR = toString(t.getRight(), seqType);
            if (!(sL.equals("") && sR.equals(""))) {
                s += " L{";
                s += sL;
                s += "} R{";
                s += sR;
                s += "}";
            }
        }
        return s;
    }
}
