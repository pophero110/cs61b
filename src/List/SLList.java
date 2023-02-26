package List;

/**
 * A SLList is a list of integers, which hides the terrible truth of the nakedness within.
 */
public class SLList {

    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first;


    public SLList(int x) {
        first = new IntNode(x, null);
    }

    // Adds x to the front of the list
    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    // Adds x to the end of the list
    public void addLast(int x) {
        IntNode p = first;
        // Advance p to the end of the list
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    private static int size(IntNode p) {
        if (p.next == null) {
            return 1;
        }
        return 1 + size(p.next);
    }

    // get size of the list - recursive
    public int size() {
        return size(first);
    }

    // get size of the list - iterative
    public int iterativeSize() {
        int size = 0;
        IntNode p = first;
        while (p != null) {
            size += 1;
            p = p.next;
        }
        return size;
    }

    public int getFirst() {
        return first.item;
    }

    public static void main(String[] args) {
        // Creates a list of one integer, namely 10
        SLList L = new SLList(15);
        L.addLast(10);
        System.out.println(L.getFirst());
        System.out.println(L.size());
    }
}
