package student_managerment;

import java.util.ArrayList;
import java.util.Arrays;

public class DanhSachSinhVien {
    private ArrayList<SinhVien> danhSach;

    public DanhSachSinhVien() {
        this.danhSach = new ArrayList<SinhVien>();
    }

    public DanhSachSinhVien(ArrayList<SinhVien> danhSach) {
        this.danhSach = danhSach;
    }

    // Thêm sinh viên vào danh sách
    public void themSinhVien(SinhVien sv) {
        this.danhSach.add(sv);
    }

    // In danh sách sinh viên ra màn hình
    public void inDanhSachSinhVien() {
        for (SinhVien sv : danhSach) {
            System.out.println(sv);
        }
    }

    // Kiểm tra danh sách sinh viên có rỗng
    public boolean kiemTraDanhSachRong() {
        return this.danhSach.isEmpty();
    }

    // Lấy ra số lượng sinh viên trong danh sách
    public int laySoLuongSinhVient() {
        return this.danhSach.size();
    }

    // Làm rỗng danh sách sinh viên
    public void lamRongDanhSach() {
        this.danhSach.removeAll(danhSach);
    }
}
