public class TestSort {
    public static void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};

        Sort.sort(input);

        org.junit.Assert.assertArrayEquals(expected, input);
    }

    /** Test the Sort.findSmallest method */
    public static void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;
        int actual = Sort.findSmallest(input, 0);
        org.junit.Assert.assertEquals(expected, actual);

        String[] input2 = {"pigs", "many", "there", "are"};
        int expected2 = 3;
        int actual2 = Sort.findSmallest(input2, 2);
        org.junit.Assert.assertEquals(expected2, actual2);
    }

    /** Test the Sort.swap method */
    public static void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"egg", "have", "an", "i"};
        int a = 0;
        int b = 3;
        Sort.swap(input, a, b);

        org.junit.Assert.assertArrayEquals(expected, input);
    }

    public static void main(String[] args) {
        testSort();
        testFindSmallest();
        testSwap();
    }
}
