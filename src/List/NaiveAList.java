package List;

/**
 * Array based list.
 * 
 * @author Josh Hug
 */


public class NaiveAList {

    private int[] items;
    private int size;

    /** Creates an empty list. */
    public NaiveAList() {
        items = new int[2];
        size = 0;
    }

    /** Resizes the underlying array to the target capacity */
    private void resize(int capacity) {
        int[] newItems = new int[size + 1];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (size == items.length) {
            resize(size + 1);
        }
        items[size] = x;
        size = size + 1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return items[size - 1];
    }

    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /**
     * Deletes item from back of the list and returns deleted item.
     */
    public int removeLast() {
        int x = getLast();
        // items[index - 1] = 0; unnecessary
        size = size - 1;
        return x;
    }

    public static void main(String[] args) {
        NaiveAList list = new NaiveAList();
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(5);
        System.out.println(list.getLast());
        System.out.println(list.size());
        System.out.println(list.get(1));
    }
}
