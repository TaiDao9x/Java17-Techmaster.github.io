import java.util.Scanner;

public class WhilePractise {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int option;
//        boolean isquit = false;
//        System.out.println("Nhập vào một số: ");
//        option = sc.nextInt();
//        while (true) {
//            if (option == 0) {
//                System.out.println("Số phải khác 0. Nhập lại!");
//                System.out.println("Nhập vào một số bất kỳ: ");
//                option = sc.nextInt();
//            } else {
//                System.out.println("Số vừa nhập là: " + option);
//                break;
//            }
//        }

        double randomNumber = Math.ceil(Math.random() * 101);
        System.out.println(randomNumber);
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số: ");
        int userNumbe = sc.nextInt();

        while (true) {
            if (userNumbe == randomNumber) {
                System.out.println("Chúc mừng bạn nhập đúng rồi!");
                break;
            } else if (userNumbe > randomNumber) {
                System.out.println("Bạn nhập số lớn hơn rồi, cho nhập lại");
                System.out.println("Nhập số: ");
                userNumbe = sc.nextInt();
            } else {
                System.out.println("Bạn nhập số nhỏ hơn rồi, cho nhập lại");
                System.out.println("Nhập số: ");
                userNumbe = sc.nextInt();
            }
        }
    }
}
