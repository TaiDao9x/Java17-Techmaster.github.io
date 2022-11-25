public class Main {
    public static void getName() {
        System.out.println("Xin chào các bạn");
    }

    static void getName1(String x) {
        System.out.println("Xin chào " + x);
    }

    static void getName2(String x2) {
        System.out.println("Xin chào " + "" + x2 + "");
    }

    static int sum(int a, int b) {
        return a + b;
    }

    static double square(double a) {
        return a * a;
    }

    static double getBMI(double a, double b) {
        return a / (b * b);
    }


    public static void main(String[] args) {
        getName();

        getName1("Tài");

        getName2("Kiên");

        int tong = sum(10, 20);
        System.out.println("Tổng 2 số bằng: " + tong);

        double binhPhuong = square(9.5);
        System.out.println("Bình phương bằng: " + binhPhuong);

        double BMI = getBMI(54, 1.64);
        System.out.println("BMI = " + BMI);
    }

}