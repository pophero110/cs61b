package List;

import java.util.NoSuchElementException;

/**
 * A SLList is a list of integers, which hides the terrible truth of the nakedness within.
 */
public class SLList<Item> implements List61B<Item> {

    private static class IntNode<Item> {
        public Item item;
        public IntNode<Item> next;

        public IntNode(Item i, IntNode<Item> n) {
            item = i;
            next = n;
        }

        public IntNode(int i, Object n) {}
    }

    // The first item (if it exists) is at sentinel.next.
    private IntNode<Item> sentinel;
    // refactor size method
    private int size;


    public SLList(Item[] x) {
        sentinel = new IntNode<Item>(63, null);
        size = 0;
        for (int i = 0; i < x.length; i++) {
            addLast(x[i]);
        }
    }

    public SLList() {
        sentinel = new IntNode<Item>(63, null);
        size = 0;
    }

    public SLList(Item x) {
        sentinel = new IntNode<Item>(63, null);
        sentinel.next = new IntNode<Item>(x, null);
        size = 1;
    }

    // Adds x to the front of the list
    public void addFirst(Item x) {
        size += 1;
        sentinel.next = new IntNode<Item>(x, sentinel.next);
    }

    // Adds x to the end of the list
    @Override
    public void addLast(Item x) {
        size += 1;
        IntNode<Item> p = sentinel;
        // Advance p to the end of the list
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode<Item>(x, null);
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
    @Override
    public int size() {
        return size;
    }

    // get size of the list - iterative
    public int iterativeSize() {
        int size = 0;
        IntNode<Item> p = sentinel;
        while (p != null) {
            size += 1;
            p = p.next;
        }
        return size;
    }

    public Item getFirst() {
        return sentinel.next.item;
    }

    // delete the first item in the list
    public void deleteFirst() {
        size -= 1;
        sentinel.next = sentinel.next.next;
    }


    @Override
    public Item getLast() {
        if (sentinel.next == null) {
            throw new NoSuchElementException("List is empty");
        }
        IntNode<Item> lastNode = sentinel.next;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        return lastNode.item;
    }

    @Override
    public Item get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        IntNode<Item> node = sentinel;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

    @Override
    public Item removeLast() {
        if (sentinel.next == null) {
            return null;
        }
        size -= 1;
        IntNode<Item> p = sentinel;
        while (p.next.next != null) {
            p = p.next;
        }
        Item last = p.next.item;
        p.next = null;
        return last;
    }

    @Override
    public void print() {
        IntNode<Item> p = sentinel.next;
        while (p != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
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
        SLList<Integer> L = new SLList<>(10);
        L.addLast(5);
        System.out.println(L.size());

    }
}
