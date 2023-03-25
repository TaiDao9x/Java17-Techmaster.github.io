import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        int sum = 0;
        int countEven = 0;
        int countOdd = 0;

        System.out.println("Nhập vào số phần tử của mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập vào phần tử thứ %d: ", i);
            arr[i] = sc.nextInt();
        }

        for (; ; ) {
            showMenu();
            do {
                System.out.print("Hãy lựa chọn: ");
                option = sc.nextInt();
            } while (option < 1 || option > 7);

            switch (option) {
                case 1: {
                    System.out.println("Các phần tử trong mảng là: " + Arrays.toString(arr));
                    break;
                }
                case 2: {
                    for (int i = 0; i < arr.length; i++) {
                        sum += arr[i];
                    }
                    System.out.println("Tổng các phần tử trong mảng là: " + sum);
                    break;
                }
                case 3: {
                    int min = arr[0];
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] < min) {
                            min = arr[i];
                        }
                    }
                    System.out.println("Phần tử nhỏ nhất là: " + min);
                    break;
                }
                case 4: {
                    int max = arr[0];
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] > max) {
                            max = arr[i];
                        }
                    }
                    System.out.println("Phần tử nhỏ nhất là: " + max);
                    break;
                }
                case 5: {

                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] % 2 == 0) {
                            countEven += 1;
                        }
                    }
                    System.out.println("Số lượng phần tử chẵn là: " + countEven);
                    break;
                }
                case 6: {

                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] % 2 != 0) {
                            countOdd += 1;
                        }
                    }
                    System.out.println("Số lượng phần tử lẻ là: " + countOdd);
                    break;
                }
                case 7: {
                    System.exit(0);
                }

            }
        }
    }

    public static void showMenu() {
        System.out.println("\n----------MENU----------");
        System.out.println("1. In ra các phần tử trong mảng");
        System.out.println("2. Tính tổng các phần tử trong mảng:");
        System.out.println("3. Tìm phần tử nhỏ nhất: ");
        System.out.println("4. Tìm phần tử lớn nhât:");
        System.out.println("5. Đếm số lượng phần tử chẵn:");
        System.out.println("6. Đếm số lượng phần tử lẻ:");
        System.out.println("7. Thoát");
    }
}
