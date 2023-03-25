import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        // Khởi tạo đối tượng scanner
        Scanner sc = new Scanner(System.in);

        // Nhập tên từ bàn phím
        System.out.println("Nhập tên: ");
        String name = sc.nextLine();

        System.out.println("Nhập địa chỉ: ");
        String adress = sc.nextLine();

        System.out.println("Nhập tuổi: ");
        // int age = Integer.parseInt(sc.nextLine()); cách 1 sửa lỗi trôi lệnh
        //Cách 2:
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Nhập email: ");
        String email = sc.nextLine();

//        System.out.println("Tên tôi là: " + name
//                + ". Địa chỉ ở: " + adress
//                + ". Tuổi tôi:" + age
//                + ". Email: " + email);

        //Print: không tự động xuống dòng
//        System.out.print("tên: " + name + "\n");
//        System.out.print("tuôỉ: " + age + "\n\t");
//        System.out.print("Email: " + email);

        // Printf: in theo định dạng
        System.out.printf("Tên: %s\n", name);
        System.out.printf("Tuổi: %d\n", age);
        System.out.printf("Địa chỉ: %s\n", adress);
        System.out.printf("Email: %s\n", email);

        System.out.println("--------");
        System.out.printf("%-20s %-18s %-18s\n", "Họ tên", "Email", "Số điện thoại");
        System.out.printf("%-20s %-18s %-18d\n", "Bùi Văn Hiên", "hien@gmail.com", 25);
        System.out.printf("%-20s %18s %-18d\n", "Nguyễn Thị Thu Hằng", "hien@gmail.com", 27);
        System.out.printf("%-20s %-18s %-18d\n", "Bùi Phương Loan", "hien@gmail.com", 18);
    }
}
