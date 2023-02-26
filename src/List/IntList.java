package List;

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
        int totalSize = 0;
        IntList p = this;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /** Returns the ith value in this list. */
    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    /**
     * Returns an IntList identical to L, but with each element incremented by x. L is not allowed
     * to change.
     */
    public static IntList incrList(IntList L, int x) {
        if (L.rest == null) {
            return new IntList(L.first + x, null);
        }
        return new IntList(L.first + x, incrList(L.rest, x));
    }

    /**
     * Returns an IntList identical to L, but with each element incremented by x. Not allowed to use
     * the 'new' keyword.
     */
    public static IntList dincrList(IntList L, int x) {
        // iterative
        // IntList p = L;
        // while (p != null) {
        // p.first -= x;
        // p = p.rest;
        // }
        // return L;

        // recursive
        L.first -= x;
        if (L.rest == null) {
            return L;
        }
        L.rest = dincrList(L.rest, x);
        return L;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.first = 5;
        L.rest = null;

        L.rest = new IntList(10, null);
        L.rest.first = 10;

        L.rest.rest = new IntList(15, null);
        L.rest.rest.first = 15;

        // refactor by using constructor
        IntList M = new IntList(5, null);
        M = new IntList(10, M);
        M = new IntList(15, M);

        System.out.println(L.size());
        System.out.println(M.iterativeSize());
        System.out.println(L.get(2));
        System.out.println(M.get(2));

        // incrList test
        IntList N = new IntList(5, null);
        N = new IntList(10, N);
        N = new IntList(15, N);
        IntList increList = IntList.incrList(N, 3);
        System.out.println("N[0] " + N.get(0));
        System.out.println("N[1] " + N.get(1));
        System.out.println("N[2] " + N.get(2));
        System.out.println("increList[0] " + increList.get(0));
        System.out.println("increList[1] " + increList.get(1));
        System.out.println("increList[2] " + increList.get(2));

        // dincrList test
        IntList O = new IntList(5, new IntList(10, new IntList(15, null)));
        IntList dincreList = IntList.dincrList(O, 3);
        System.out.println("O[0] " + O.get(0));
        System.out.println("O[1] " + O.get(1));
        System.out.println("O[2] " + O.get(2));
        System.out.println("dincreList[0] " + dincreList.get(0));
        System.out.println("dincreList[1] " + dincreList.get(1));
        System.out.println("dincreList[2] " + dincreList.get(2));
    }
}
