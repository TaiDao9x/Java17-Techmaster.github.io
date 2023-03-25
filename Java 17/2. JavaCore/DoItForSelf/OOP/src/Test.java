public class Test {
    public static void main(String[] args) {
        HoaDonCaPhe hd = new HoaDonCaPhe("Trung Nguyên", 100, 1.5);
        System.out.println("Tong tien: " + hd.tinhTongTien());

        System.out.println("Kiểm tra khối lượng: " + hd.kiemTraKhoiLuongLonHon(1));
    }
}
