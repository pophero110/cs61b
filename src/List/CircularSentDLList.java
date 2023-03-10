package List;

public class CircularSentDLList<Item> {
    private static class Node<Item> {
        public Item item;
        public Node<Item> next;
        public Node<Item> prev;

        public Node(Item i, Node<Item> p, Node<Item> n) {
            item = i;
            // allow fast remove last node with prev
            prev = p;
            next = n;
        }
    }

    // The first item (if it exists) is at sentinel.next.
    private Node<Item> sentinel;

    // refactor size method
    private int size;

    // allow empty list
    public CircularSentDLList() {
        sentinel = new Node<Item>(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public CircularSentDLList(Item x) {
        Node<Item> node = new Node<Item>(x, null, null);
        sentinel = new Node<Item>(null, node, node);
        node.next = sentinel;
        node.prev = sentinel;
        size = 1;
    }

    public void addFirst(Item x) {
        Node<Item> oldFirst = sentinel.next;
        Node<Item> newFirst = new Node<>(x, sentinel, oldFirst);
        oldFirst.prev = newFirst;
        sentinel.next = newFirst;
        size += 1;
    }

    public void addLast(Item x) {
        Node<Item> oldLast = sentinel.prev;
        Node<Item> newLast = new Node<>(x, oldLast, sentinel);
        oldLast.next = newLast;
        sentinel.prev = newLast;
        size += 1;
    }

    public Node<Item> removeLast() {
        Node<Item> oldLast = sentinel.prev;
        Node<Item> newLast = oldLast.prev;
        newLast.next = sentinel;
        sentinel.prev = newLast;
        oldLast.next = null;
        oldLast.prev = null;
        size -= 1;
        return oldLast;
    }

    public Item getFirst() {
        return sentinel.next.item;
    }

    public Item getLast() {
        return sentinel.prev.item;
    }

    public int size() {
        return size;
    }

    public void print() {
        Node<Item> head = sentinel.next;
        while (head != sentinel) {
            System.out.print(head.item + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularSentDLList<Integer> list = new CircularSentDLList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(4);
        System.out.println(list.size()); // 4
        System.out.println(list.getFirst()); // 3
        System.out.println(list.getLast()); // 4
        list.print(); // 3 2 1 4
        CircularSentDLList<Integer> list2 = new CircularSentDLList<>();
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);
        list2.addLast(4);
        list2.removeLast();
        System.out.println(list2.size()); // 4
        System.out.println(list2.getFirst()); // 1
        System.out.println(list2.getLast()); // 3
        list2.print(); // 1 2 3

    }
}
