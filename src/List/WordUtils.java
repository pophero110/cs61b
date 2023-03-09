package List;

public class WordUtils {
    public static String longest(List61B<String> list) {
        int maxDex = 0;
        for (int i = 0; i < list.size(); i += 1) {
            String longestString = list.get(maxDex);
            String thisString = list.get(i);
            if (thisString.length() > longestString.length()) {
                maxDex = i;
            }
        }
        return list.get(maxDex);
    }

    public static void main(String[] args) {
        NaiveAList<String> list = new NaiveAList<>();
        list.addLast("123");
        list.addLast("1234");
        list.addLast("12345");
        System.out.println(longest(list));
        list.print();
    }
}
