package List;


/**
 * A SLList is a list of integers, which hides the terrible truth of the nakedness within.
 */
public class SentBackDLList<Item> {

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
    // private Node<Item> last;

    // avoiding special case. the last item is at sentinelBack.prev
    private Node<Item> sentinelBack;

    // private Node<Item> backSentinel;

    // allow empty list
    public SentBackDLList() {
        sentinel = new Node<Item>(63, null, null);
        sentinelBack = new Node<Item>(63, sentinel, null);
        sentinel.next = sentinelBack;
        size = 0;
    }

    public SentBackDLList(Item x) {
        Node<Item> node = new Node<Item>(x, null, null);
        sentinel = new Node<Item>(63, null, node);
        sentinelBack = new Node<Item>(63, node, null);
        node.next = sentinelBack;
        node.prev = sentinel;
        size = 1;
    }

    public void addFirst(Item x) {
        Node<Item> newNode = new Node<>(x, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    public void addLast(Item x) {
        Node<Item> newNode = new Node<>(x, sentinelBack.prev, sentinelBack);
        sentinelBack.prev.next = newNode;
        sentinelBack.prev = newNode;
        size += 1;
    }

    public Node<Item> removeLast() {
        Node<Item> oldLast = sentinelBack.prev;
        Node<Item> newLast = oldLast.prev;
        newLast.next = sentinelBack;
        sentinelBack.prev = newLast;
        oldLast.next = null;
        oldLast.prev = null;
        size -= 1;
        return oldLast;
    }

    public Item getFirst() {
        return sentinel.next.item;
    }

    public Item getLast() {
        return sentinelBack.prev.item;
    }

    public int size() {
        return size;
    }

    public void print() {
        Node<Item> head = sentinel.next;
        while (head.next != null) {
            System.out.print(head.item + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SentBackDLList<Integer> list = new SentBackDLList<>();
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
        System.out.println(list2.size()); // 4
        System.out.println(list2.getFirst()); // 1
        System.out.println(list2.getLast()); // 3
        list2.print(); // 1 2 3

    }
}
