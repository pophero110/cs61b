package List;


/**
 * A SLList is a list of integers, which hides the terrible truth of the nakedness within.
 */
public class DLList<Item> {

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

        public Node(int i, Object p, Node<Item> n) {}
    }

    // The first item (if it exists) is at sentinel.next.
    private Node<Item> sentinel;

    // refactor size method
    private int size;

    // allow fast get last node
    private Node<Item> last;

    // private Node<Item> backSentinel;

    // allow empty list
    public DLList() {
        sentinel = new Node<Item>(63, null, null);
        size = 0;
    }

    public DLList(Item x) {
        sentinel = new Node<Item>(63, null, null);
        sentinel.next = new Node<Item>(x, null, null);
        sentinel.next.prev = sentinel;
        last = sentinel.next;
        size = 1;
    }

    public void addFirst(Item x) {
        Node<Item> newNode = new Node<>(x, null, null);
        if (size() == 0) {
            sentinel.next = newNode;
            newNode.prev = sentinel;
            last = newNode;
        } else {
            newNode.next = sentinel.next;
            sentinel.next = newNode;
            newNode.prev = sentinel;
        }
        size += 1;
    }

    public void addLast(Item x) {
        Node<Item> newLast = new Node<>(x, null, null);
        if (size() == 0) {
            sentinel.next = newLast;
            newLast.prev = sentinel;
            last = newLast;
        } else {
            newLast.prev = last;
            last.next = newLast;
            last = newLast;
        }
        size += 1;
    }

    public Node<Item> removeLast() {
        Node<Item> newLast = last.prev;
        Node<Item> oldLast = last;
        newLast.next = null;
        last.prev = null;
        last = newLast;

        return oldLast;
    }

    public Item getFirst() {
        return sentinel.next.item;
    }

    public Item getLast() {
        return last.item;
    }

    public int size() {
        return size;
    }

    public void print() {
        Node<Item> head = sentinel.next;
        while (head != null) {
            System.out.print(head.item + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DLList<Integer> list = new DLList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(4);

        System.out.println(list.size()); // 4
        System.out.println(list.getFirst()); // 3
        System.out.println(list.getLast()); // 4

        list.print(); // 3 2 1 4

        DLList<Integer> list2 = new DLList<>();
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);
        list2.addLast(4);
        list2.removeLast();
        // list.print();

        System.out.println(list2.size()); // 4
        System.out.println(list2.getFirst()); // 1
        System.out.println(list2.getLast()); // 3

        list2.print(); // 1 2 3

    }
}
