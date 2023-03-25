import java.util.Scanner;

public class Homework_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Bài 1:
        System.out.print("Chiều dài = ");
        int longs = sc.nextInt();
        System.out.println();

        System.out.print("Chiều rộng = ");
        int width = sc.nextInt();
        sc.nextLine();

        System.out.println("Chu vi hình chữ nhật là: " + ((2 * longs) + (2 * width)));
        System.out.println("Diện tích hình chữ nhật là: " + (longs * width));


        // Bài 2:
        System.out.println("---------");
        System.out.print("Họ tên là: ");
        String name = sc.nextLine();
        System.out.println();

        System.out.print("Tuổi: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println();

        System.out.print("Giới tính là: ");
        String gender = sc.nextLine();
        System.out.println();

        System.out.print("Địa chỉ: ");
        String adress = sc.nextLine();
        System.out.println();

        System.out.printf(" Xin chào các bạn, mình tên là %s, năm nay mình %d tuổi, giới tính %s. Hiện tại mình đang sống và làm việc tại %s.", name, age, gender, adress);

//        System.out.println("Xin chào các bạn, mình tên là " + name + ", năm nay mình " + age + " tuổi, giới tính "
//                + gender + ". Hiện tại mình đang sống và làm việc tại " + adress + ".");

    }
}