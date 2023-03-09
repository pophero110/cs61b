package List;

/**
 * Array based list.
 * 
 * @author Josh Hug
 */


public class NaiveAList<Item> implements List61B<Item> {

    private Item[] items;
    private int size;

    /** Creates an empty list. */
    public NaiveAList() {
        items = (Item[]) new Object[2];
        size = 0;
    }

    /** Resizes the underlying array to the target capacity */
    private void resize(int capacity) {
        Item[] newItems = (Item[]) new Object[size + 1];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    /** Inserts X into the back of the list. */
    @Override
    public void addLast(Item x) {
        if (size == items.length) {
            // instead of increasing size by 1
            // which give great performance when add billion items
            // also how python implement tht list
            resize(size * 2);
        }
        items[size] = x;
        size = size + 1;
    }

    /** Returns the item from the back of the list. */
    @Override
    public Item getLast() {
        return items[size - 1];
    }

    /** Gets the ith item in the list (0 is the front). */
    @Override
    public Item get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    @Override
    public int size() {
        return size;
    }

    /**
     * Deletes item from back of the list and returns deleted item.
     */
    @Override
    public Item removeLast() {
        Item x = getLast();
        items[size - 1] = null;
        size = size - 1;
        return x;
    }

    public static void main(String[] args) {
        NaiveAList<Integer> list = new NaiveAList<>();
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(5);
        System.out.println(list.getLast());
        System.out.println(list.size());
        System.out.println(list.get(1));
    }
}
