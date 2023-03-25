import java.util.Scanner;

public class Prepair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        System.out.print("Nhập vào chiều cao: ");
//        double height = sc.nextDouble();
//
//        System.out.print("Nhập vào cân nặng: ");
//        double weight = sc.nextDouble();
//
//        double bmi = (weight / Math.pow(height, 2));
//
//        if (bmi < 18.5) {
//            System.out.println(bmi + ". Thiếu cân");
//        } else {
//            if (bmi > 24.9) {
//                System.out.println(bmi + ". Thừa cân");
//            } else {
//                System.out.println(bmi + ". Bình thường");
//            }
//        }

//        System.out.println("Nhập vào số:");
//        int mark = sc.nextInt();
//
//        if (mark >= 85) {
//            System.out.println("A");
//        } else {
//            if (mark >= 70) {
//                System.out.println("B");
//            } else {
//                if (mark >= 40) {
//                    System.out.println("C");
//                } else {
//                    System.out.println("D");
//                }
//            }
//        }

//        System.out.print("Nhập vào số a: ");
//        int a = sc.nextInt();
//        System.out.print("Nhập vào số b: ");
//        int b = sc.nextInt();
//
//        System.out.printf("Số có giá trị lớn hơn là: %d", Math.max(a, b));

//        System.out.print("Nhập một số bất kỳ: ");
//        int number = sc.nextInt();
//        if (number == 0) {
//            System.out.println("Là số 0");
//        } else {
//            if (number > 0) {
//                System.out.println("Là số dương");
//            } else {
//                System.out.println("Là số âm");
//            }
//
//        }

        System.out.print("Nhập vào số a: ");
        int a = sc.nextInt();
        if (a % 3 == 0 && a % 5 == 0) {
            System.out.printf("Số %d đồng thời chia hết cho 3 và 5", a);
        } else {
            if (a % 3 == 0) {
                System.out.printf("Số %d chỉ chia hết cho 3", a);
            } else {
                if (a % 5 == 0) {
                    System.out.printf("Số %d chỉ chia hết cho 5", a);
                } else {
                    System.out.printf("Số %d không chia hết cho 3, 5", a);
                }
            }

        }


    }
}
