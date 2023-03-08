public class Sort {
    /** Sorts string destrctively */
    public static void sort(String[] x) {
        // find the smallest item
        // move it to the front
        // selection sort the rest
        sort(x, 0);
    }

    private static void sort(String[] x, int startAt) {
        if (startAt == x.length)
            return;
        int smallest = findSmallest(x, startAt);
        swap(x, startAt, smallest);
        sort(x, startAt + 1);
    }

    public static int findSmallest(String[] x, int startAt) {
        int smallestIndex = startAt;
        for (int i = startAt; i < x.length; i += 1) {
            // from internet, if x[smallestIndex] > x[i], return positive number
            if (x[smallestIndex].compareTo(x[i]) > 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    /** Swap item a with b */
    public static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

}
