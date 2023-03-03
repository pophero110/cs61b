package List;

import java.util.*;

/**
 * Array based list.
 * 
 * @author Josh Hug
 */

public class AList {

    private List<Integer> list;

    /** Creates an empty list. */
    public AList() {
        list = new ArrayList<>();
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        list.add(x);
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return list.get(size() - 1);
    }

    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return list.get(i);
    }

    /** Returns the number of items in the list. */
    public int size() {
        return list.size();
    }

    /**
     * Deletes item from back of the list and returns deleted item.
     */
    public int removeLast() {
        return list.remove(size() - 1);
    }
}
