package exception_demo;

public class UncheckedCallStack {
    public static void main(String[] args) {
        methodThree();
    }

    public static void methodOne() {
        System.out.println("1");
        throw new ArithmeticException("Lỗi toán học");
    }

    public static void methodTwo() {
        System.out.println("2");
        methodOne();
    }

    public static void methodThree() {
        System.out.println("3");
        try {
            methodTwo();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

    }
}
