public class Homework_03 {
    // Bài 1:
    public static String repeatString(String text) {
        String rp = "";
        for (int i = 1; i <= 10; i++) {
            rp += text;
        }
        return rp;
    }

    // Bài 2
    public static String repeatStringB2(String text2) {
        String rp2 = "";
        for (int i = 1; i <= 10; i++) {
            if (i == 1) {
                rp2 += text2;
            } else {
                rp2 += "-";
                rp2 += text2;
            }
        }
        return rp2;
    }

    // Bài 3
    public static String repeatStringB3(String text3, int count) {
        String rp3 = "";
        for (int i = 1; i <= count; i++) {
            if (i == 1) {
                rp3 += text3;
            } else {
                rp3 += "-";
                rp3 += text3;
            }
        }
        return rp3;
    }

    // Bài 4
    public static int sumNumber5() {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    // Bài 5:
    public static double volumePherical(double r) {
        double v = (4 * Math.PI * Math.pow(r, 3)) / 3;
        return v;
    }

    public static void main(String[] args) {
        //Bài 1
        System.out.println(repeatString("a"));

        // Bài 2
        System.out.println(repeatStringB2("b"));

        //Bài 3
        System.out.println(repeatStringB3("Tài", 10));

        // Bài 4
        System.out.println(sumNumber5());

        // Bài 5
        System.out.println(volumePherical(3));

    }
}
