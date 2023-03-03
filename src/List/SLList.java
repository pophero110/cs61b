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

    // The first item (if it exists) is at sentinel.next.
    private IntNode sentinel;
    // refactor size method
    private int size;


    public SLList(int[] x) {
        sentinel = new IntNode(63, null);
        size = 0;
        for (int i = 0; i < x.length; i++) {
            addLast(x[i]);
        }
    }

    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    // Adds x to the front of the list
    public void addFirst(int x) {
        size += 1;
        sentinel.next = new IntNode(x, sentinel.next);
    }

    // Adds x to the end of the list
    public void addLast(int x) {
        size += 1;
        IntNode p = sentinel;
        // Advance p to the end of the list
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    // private static int size(IntNode p) {
    // if (p.next == null) {
    // return 1;
    // }
    // return 1 + size(p.next);
    // }

    // // get size of the list - recursive
    // public int size() {
    // return size(first);
    // }

    public int size() {
        return size;
    }

    // get size of the list - iterative
    public int iterativeSize() {
        int size = 0;
        IntNode p = sentinel;
        while (p != null) {
            size += 1;
            p = p.next;
        }
        return size;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    // delete the first item in the list
    public void deleteFirst() {
        size -= 1;
        sentinel.next = sentinel.next.next;
    }

    public static void main(String[] args) {
        // Creates a list of one integer, namely 10
        // SLList L = new SLList(15);
        // L.addLast(10);
        // System.out.println(L.getFirst());
        // System.out.println(L.size());

        // SLList M = new SLList();
        // System.out.println(M.size());
        // M.addLast(14);
        // System.out.println(M.size());
        // System.out.println(M.getFirst());

        // deleteFirst test
        // SLList L = new SLList(10);
        // L.addLast(5);
        // System.out.println(L.size());
        // System.out.println(L.getFirst()); // 10
        // L.deleteFirst();
        // System.out.println(L.size()); // 10
        // System.out.println(L.getFirst());

        // // new constructor that take a array of integers
        // int[] x = {1, 2, 3, 4, 5};
        // SLList L = new SLList(x);
        // System.out.println(L.size());
        // System.out.println(L.getFirst());

        // test if sentinel is null
        SLList L = new SLList(10);
        L.addLast(5);
        System.out.println(L.size());

    }
}
