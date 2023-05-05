package rectangle;

public class Rectangle {
    private double dai;
    private double rong;

    public Rectangle() {
    }

    public Rectangle(double dai, double rong) {
        this.dai = dai;
        this.rong = rong;
    }

    public double getDai() {
        return dai;
    }

    public void setDai(double dai) {
        this.dai = dai;
    }

    public double getRong() {
        return rong;
    }

    public void setRong(double rong) {
        this.rong = rong;
    }

    public double tinhChuVi() {
        return (this.dai + this.rong) * 2;
    }

    public double tinhDienTich() {
        return this.dai * this.rong;
    }
}
