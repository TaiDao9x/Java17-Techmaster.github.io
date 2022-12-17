package student_managerment;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachSinhVien dssv = new DanhSachSinhVien();
        int luaChon;
        do {
            System.out.println("--------MENU---------");
            System.out.println("Lựa chọn chức năng: ");
            System.out.println(
                    "1. Thêm sinh viên vào danh sách.\n" +
                            "2. In dah sách sinh viên ra màn hình.\n" +
                            "3. Kiểm tra danh sách có rỗng hay không.\n" +
                            "4. Lấy ra số lượng sinh viên.\n" +
                            "5. Làm rỗng danh sách sinh viên.\n" +
                            "6. Kiểm tra sinh viên có tồn tại hay không, dựa vào mã sinh viên.\n" +
                            "7. Xóa một sinh viên ra khỏi danh sách dựa trên mã SV.\n" +
                            "8. Tìm ki tất cả sinh viên dựa trên tên được nhập từ bàn phím.\n" +
                            "9. Xuất r danh sách sinh vin có điẻm từ cao đến thấp.\n" +
                            "0. Thoát khỏi chương trình");
            luaChon = sc.nextInt();
            sc.nextLine();

            if (luaChon == 1) {
                System.out.println("Nhập mã sinh viên: ");
                String maSinhVien = sc.nextLine();
                System.out.println("Nhập họ và tên: ");
                String hoVaTen = sc.nextLine();
                System.out.println("Nhập năm sinh: ");
                int namSinh = sc.nextInt();
                System.out.println("Nhập điểm trung bình: ");
                float diemTrungBinh = sc.nextFloat();
                SinhVien sv = new SinhVien(maSinhVien, hoVaTen, namSinh, diemTrungBinh);
                dssv.themSinhVien(sv);

            } else if (luaChon == 2) {
                dssv.inDanhSachSinhVien();
            } else if (luaChon == 3) {
                System.out.println("Danh sách rỗng: " + dssv.kiemTraDanhSachRong());
            } else if (luaChon == 4) {
                System.out.println("Số lượng SV hiện tại: " + dssv.laySoLuongSinhVient());
            } else if (luaChon == 5) {
                System.out.println("Xóa danh sách sinh viên!");
                dssv.lamRongDanhSach();
            } else if (luaChon == 6) {

            } else if (luaChon == 7) {

            } else if (luaChon == 8) {

            } else if (luaChon == 9) {

            }
        } while (luaChon != 0);
    }
}
