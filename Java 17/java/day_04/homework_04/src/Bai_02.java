import java.util.Arrays;
import java.util.Scanner;

public class Bai_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

//        for (;;) {
//            System.out.println("-------MENU--------");
//            System.out.println("1. Tạo mảng");
//            System.out.println("2. Nhập các phần tử mảng");
//            System.out.println("3. In mảng ra màn hình");
//            System.out.println("4. Thay đổi các phần tử là số chẵn tăng lên 1 đơn vị");
//            System.out.println("5. Thoát");
//            System.out.print("Nhập lựa chọn: ");
//        }

        System.out.print("Nhập vào n: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập vào phần tử thứ %d: ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                arr[i] += 1;

            }
        }
        System.out.println(Arrays.toString(arr));
    }

//    public static int doFuntionOne() {
//
//    }

//    public static int doFuntionTwo() {
//
//    }
}
