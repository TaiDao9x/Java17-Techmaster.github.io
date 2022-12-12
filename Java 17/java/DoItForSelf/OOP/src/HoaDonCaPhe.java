public class HoaDonCaPhe {
    private String tenLoaiCaPhe;
    private double giatTien1Kg;
    private double khoiLuong;

    public HoaDonCaPhe(String ten, double gia, double kl) {
        this.tenLoaiCaPhe = ten;
        this.giatTien1Kg = gia;
        this.khoiLuong = kl;
    }

    public double tinhTongTien() {
        return this.giatTien1Kg * this.khoiLuong;
    }

    public boolean kiemTraKhoiLuongLonHon(double kl) {
        return this.khoiLuong > kl;

    }

}
