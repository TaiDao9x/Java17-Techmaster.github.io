import java.util.Arrays;
import java.util.Scanner;

public class Bai_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        int n = 0;
        int[] arr = new int[n];
        int[] newArr = new int[n];


        for (; ; ) {
            showMenu();

            do {
                System.out.print("Bấm để chọn (1/2/3/4/5): ");
                option = sc.nextInt();
            } while (option < 1 || option > 5);

            switch (option) {
                case 1: {
                    System.out.println("Thực hiện lựa chọn 1: ");
                    System.out.print("Nhập vào số phần tử trong mảng: ");
                    n = sc.nextInt();
                    arr = new int[n];
                    newArr = new int[n];
                    break;
                }
                case 2: {
                    System.out.println("Thực hiện lựa chọn 2: ");
                    if (n == 0) {
                        warning();
                    } else {
                        for (int i = 0; i < n; i++) {
                            System.out.printf("Nhập vào phần tử thứ %d: ", i);
                            arr[i] = sc.nextInt();
                        }
                    }
                    break;
                }
                case 3: {
                    if (n == 0) {
                        warning();
                    } else {
                        System.out.println("Thực hiện lựa chọn 3: ");
                        System.out.println("Mảng vừa nhập là: " + Arrays.toString(arr));
                    }
                    break;
                }
                case 4: {
                    if (n == 0) {
                        warning();
                    } else {
                        for (int i = 0; i < n; i++) {
                            newArr[i] = arr[i];
                            if (arr[i] % 2 == 0) {
                                newArr[i] = arr[i] + 1;
                            }
                        }
                        System.out.println("Thực hiện lựa chọn 4: ");
                        System.out.println("Mảng mới là: " + Arrays.toString(newArr));
                    }
                    break;
                }
                case 5: {
                    System.exit(0);
                    break;
                }
            }

        }
    }

    public static void warning() {
        System.out.println("Chưa tạo mảng, hãy tạo mảng trước!");
    }

    public static void showMenu() {
        System.out.println("\n----------MENU----------");
        System.out.println("1. Nhập số phần tử của mảng");
        System.out.println("2. Nhập các phần tử của mảng");
        System.out.println("3. In mảng ra màn hình");
        System.out.println("4. Thay đổi các phần tử là số chẵn tăng lên 1 đơn vị");
        System.out.println("5. Thoát");
    }
}





