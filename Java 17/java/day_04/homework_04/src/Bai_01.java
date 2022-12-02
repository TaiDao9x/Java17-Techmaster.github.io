import java.util.Scanner;

public class Bai_01 {
    public static void main(String[] args) {
//        Câu 1: Viết chương trình thực hiện công việc:
//
//        Nhập vào từ bàn phím họ và tên bạn
//        Thực hiện chuẩn hóa chuỗi vừa nhập (in hoa chữ cái đầu của họ và tên)
//        Ví dụ: bùi văn hiên -> Bùi Văn Hiên

        Scanner sc = new Scanner(System.in);
        String fullName;
        System.out.print("Nhập vào họ tên cần chuẩn hóa: ");
        fullName = sc.nextLine();

        fullName = fullName.substring(0, 1).toUpperCase() + fullName.substring(1);

        fullName = fullName.replaceAll(" ", "-");

        char[] arr = fullName.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 45) {
                arr[i + 1] = Character.toUpperCase(arr[i + 1]);
            }
        }

        fullName = String.valueOf(arr);
        fullName = fullName.replaceAll("-", " ");
        System.out.println("\nHọ và tên sau khi chuẩn hóa là: " + fullName);
    }

}




