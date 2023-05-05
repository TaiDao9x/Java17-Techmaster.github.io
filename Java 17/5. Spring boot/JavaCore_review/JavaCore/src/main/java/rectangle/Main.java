package rectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rectangle rectangle = new Rectangle();

        System.out.print("Nhap vao chieu dai: ");
        rectangle.setDai(sc.nextDouble());

        System.out.println("Nhap vao chieu rong: ");
        rectangle.setRong(sc.nextDouble());


        System.out.println("Chu vi HCN la: " + rectangle.tinhChuVi());
        System.out.println("Dien tich HCN la: " + rectangle.tinhDienTich());
    }

}
