public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /** Return the size of the list using... recursion! */
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    /** Return the size of the list using no recursion! */
    public int iterativeSize() {
        ini totalSize = 0;
        IntList p = this;
        while (p != null) {
            size += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /** Returns the ith value in this list. */
    public int get(int i) {
        return 0;
    }

    public static void main(String[] args) {
        IntList L = new IntList();
        L.first = 5;
        L.rest = null;

        L.rest = new IntList();
        L.rest.first = 10;

        L.rest.rest = new IntList();
        L.rest.rest.first = 15;

        // refactor by using constructor
        IntList M = new IntList(5, null);
        M = new IntList(10, M);
        M = new IntList(15, M);
    }
}
