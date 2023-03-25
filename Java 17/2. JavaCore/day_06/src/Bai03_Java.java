import java.util.Random;

//Viết chương trình sinh ra một số ngẫu nhiên, kiểm tra số đó có là số nguyên tố không.

public class Bai03_Java {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(20);
        if (isPrimeNumber(n)) {
            System.out.printf("Số %d là số nguyên tố.", n);
        } else {
            System.out.printf("Số %d không phải là số nguyên tố.", n);
        }
    }

    public static boolean isPrimeNumber(int n) {
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
