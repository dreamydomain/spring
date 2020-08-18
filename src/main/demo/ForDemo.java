public class ForDemo {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        for (int i = 0; i < 1000; i++) {
            if (i == 5) {
                System.out.println(i);
                break;
            }
        }
        boolean firstTime = true;
        for (int i = 0; i < 1000; i++) {
            if (i % 5 != 0 || !firstTime) {
                continue;
            }
            firstTime = false;
            System.out.println(i);
        }
    }
}
