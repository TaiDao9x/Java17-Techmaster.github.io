import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số lượng phần tử: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Nhập vào phần tử thứ %d: \n", i);
            arr[i] = sc.nextInt();
        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.printf("Phần tử thứ %d là: %d\n", i, arr[i]);
//        }
//        for (int i = 0; i < arr.length; i++) {
//            sum += arr[i];
//        }
//        System.out.println(sum);

//        System.out.println(Arrays.toString(arr));
//
//        Arrays.sort(arr);
//        System.out.println("sau khi sap xep: " + Arrays.toString(arr));

//        for (int value : arr
//        ) {
//            System.out.printf("Các phần tử trong mảng là:%d \n", value);
//            sum += value;
//        }
//        System.out.println("Tổng mảng là: " + sum);

        // Cách 1 : Khai báo sô lượng phần tử cho mảng
        int[] numbers = new int[3]; // Mảng có 3 phần tử

        // Khai báo giá trị cho các phần tử theo chỉ số
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        System.out.println(Arrays.toString(numbers));

        // Cách 2 : Khai báo và khởi tạo giá trị cho mảng
        String[] names = {"hiên", "an", "huy"};
        System.out.println(Arrays.toString(names));

        // Tương đường
        String[] namesOther = new String[]{"hiên", "an", "huy"};
        System.out.println(Arrays.toString(namesOther));

    }


}
