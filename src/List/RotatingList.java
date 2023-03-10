package List;

public class RotatingList<Item> extends SLList<Item> {
    public void rotateRight() {
        Item x = removeLast();
        addFirst(x);
    }

    public static void main(String[] args) {
        RotatingList<Integer> list = new RotatingList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.rotateRight();
        list.print();
    }
}
