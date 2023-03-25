package exception_demo;


public class HandleException {
    public static void main(String[] args) {
        try {
            methodOne();
            methodTwo();
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println("Lỗi chia cho 0");
            System.out.println(e.getMessage());
            e.printStackTrace();

        } finally {
            System.out.println("final");
        }

        System.out.println("Code.....");
    }

    public static void methodOne() {
        int number = 9;
        int zero = 1;
        int result = number / zero;
        System.out.println(result);
    }


    public static void methodTwo() {
        String str = "ac";
        System.out.println(str.length()); //NullPointerException
    }

}
