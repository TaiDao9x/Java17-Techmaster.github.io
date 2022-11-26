public class FinalDemo {
    // Khai báo hằng global
    public static final String EMAIL = "daotai221192@gmail.com";

    public static void main(String[] args) {
        final String name = "Bob";
        final String FIRST_NAME = "Anna";

        final int NUMBER;
        NUMBER = 10;

        System.out.println(name);
        System.out.println(FIRST_NAME);
        System.out.println(NUMBER);
        System.out.println(EMAIL);

//        NUMBER = 12; không thể thay đổi giá trị hằng

        System.out.println(sumTwoNumber(10, 20));
    }

    // Method final thì không th overide
    public static final int sumTwoNumber(int a, int b) {
        return a + b;
    }
}
