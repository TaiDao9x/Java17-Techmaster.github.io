public class Homework_day01 {
    public static void getName() {
        System.out.println("Xin chào các bạn");
    }

    static void getName1(String x) {
        System.out.println("Xin chào " + x);
    }

    static void getName2(String x2) {
        char nhay = 34;
        System.out.println("Xin chào " + nhay + x2 + nhay);
    }

    static int sum(int a, int b) {
        return a + b;
    }

    static double square(double a) {
        return a * a;
    }

    static double theKy(double a) {
        return a / 100;
    }

    static double getBMI(double weight, double height) {
        return weight / (height * height);
    }

    public static void main(String[] args) {
        getName();

        getName1("Đào Văn Tài");

        getName2("Kiên");

        int tong = sum(10, 20);
        System.out.println("Tổng 2 số bằng: " + tong);

        double binhPhuong = square(9.5);
        System.out.println("Bình phương bằng: " + binhPhuong);

        short getTheky = (short) Math.ceil(theKy(2001));
        System.out.println("Thế kỷ thứ: " + getTheky);

        double BMI = getBMI(54, 1.64);
        System.out.println("BMI = " + BMI);
    }

}