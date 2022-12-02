import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int options = 0;
        boolean isquit = false;

        while (!isquit) {
            showMenu();
            options = sc.nextInt();
            switch (options) {
                case 1: {
                    doFunctionOne();
                    break;
                }
                case 2: {
                    doFunctionTwo();
                    break;
                }
                case 3: {
                    doFunctionThree();
                    break;
                }
                case 4: {
                    isquit = true;
                    break;
                }
                default: {
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
                }
            }
        }

    }

    public static void showMenu() {
        System.out.println("-------MENU--------");
        System.out.println("1. Tạo mảng");
        System.out.println("2. Nhập các phần tử mảng");
        System.out.println("3. In mảng ra màn hình");
        System.out.println("4. Thay đổi các phần tử là số chẵn tăng lên 1 đơn vị");
        System.out.println("5. Thoát");
        System.out.print("Nhập lựa chọn: ");
    }

    public static void doFunctionOne() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào số phần tử của mảng: ");
        int n = sc.nextInt();
    }

    public static void doFunctionTwo() {
        System.out.println("Thực hiện lựa chọn 2.");
    }

    public static void doFunctionThree() {
        System.out.println("Thực hiện lựa chọn 3.");
    }

    public static void doFunctionFour() {
        System.out.println("Thực hiện lựa chọn 3.");
    }
}
