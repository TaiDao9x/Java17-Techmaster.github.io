public class Bai04_Java {


    public static void main(String[] args) {

//    Viết chương trình thực hiện:
//    Liệt kê 10 số nguyên tố đầu tiên

        int count = 0;
        int i = 2;
        System.out.print("10 số nguyên tố đầu tiên là:");
        while (count <= 10) {
            if (isPrimeNumber(i)) {
                System.out.print(" " + i);
                count++;
            }
            i++;
        }
        System.out.println();

        //    Liệt kê các số nguyên tố nhỏ hơn 10
        System.out.print("Các số nguyên tố nhỏ hơn 10 là:");
        for (int j = 0; j < 10; j++) {
            if (isPrimeNumber(j)) {
                System.out.print(" " + j);
            }
        }
    }

    public static boolean isPrimeNumber(int n) {
//        Phương thức kiểm tra số nguyên tố

        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
