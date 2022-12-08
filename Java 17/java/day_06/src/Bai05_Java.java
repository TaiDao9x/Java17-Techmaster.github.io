import java.util.Arrays;
import java.util.Scanner;

public class Bai05_Java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào số dòng: ");
        int row = sc.nextInt();
        System.out.print("Nhập vào số cột: ");
        int col = sc.nextInt();

        int arr[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Nhập vào phần tử arr[" + i + "," + j + "] của mảng arr : ");
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nThông tin mảng là: ");
        for (int subRow[] : arr) {
            for (int number : subRow) {
                System.out.print(number + "\t");
            }
            System.out.println();
        }

        int diagonalLine;
        if (row < col) {
            diagonalLine = row;
        } else {
            diagonalLine = col;
        }
        int arrDiagonalLine[] = new int[diagonalLine];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == j) {
                    arrDiagonalLine[i] = arr[i][j];
                }
            }
        }
        System.out.println("Các phần tử nằm trên đường chéo chính là: " + Arrays.toString(arrDiagonalLine));

//        Tạo thêm 1 mảng hai chiều có cùng số dòng và số cột thực hiện cộng hai mảng với nhau
        int result[][] = new int[row][col];
        int arr2[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("\nNhập vào phần tử arr2[" + i + "," + j + "] của mảng arr2 : ");
                arr2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = arr[i][j] + arr2[i][j];
            }
        }

        System.out.println("\nThông tin mảng sau khi cộng là: ");
        for (int subRow[] : result) {
            for (int number : subRow) {
                System.out.print(number + "\t");
            }
            System.out.println();
        }
    }
}
