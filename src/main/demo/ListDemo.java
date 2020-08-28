import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        List<Integer> list = new ArrayList();
        for (int i = 0; i <= 10; i++) {
            list.add(i);
        }
        System.out.println(list.size());
        System.out.println(list.get(list.size() - 1));

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }

    }

}
