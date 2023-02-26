package hw0;

public class DrawATriangle {
    public static void main(String[] args) {
        int SIZE = 5;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
