public class Conditionals {
    public static void main(String[] args) {
        int x = 5;
        if (x < 10)
            x = x + 10;
        if (x < 10)
            x = x + 10;
        System.out.println(x);
        int bottles = 5;
        while (bottles > 0) {
            System.out.println(bottles + " bottles of beer on the wall.");
            bottles = bottles - 1;
        }
    }
}