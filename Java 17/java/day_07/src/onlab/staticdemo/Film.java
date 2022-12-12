package onlab.staticdemo;


public class Film {
    // Property bình thường
    public String name;
    public int length;

    // Property với static keyword
    public static String category = "Action";

    // Hàm khởi tạo

    public Film() {
    }

    public Film(String name, int length) {
        this.name = name;
        this.length = length;
    }

    // Phương thức bình thường thay đổi được biến Static
    public void methodNormal() {
        System.out.println("Method Normal");
    }

    // Phương thức static thay đổi được biến Static
    public static void methodStatic() {
        System.out.println("Method static");
//        this.methodStatic();
    }

    public static void changeCategory() {
        category = "Love";
    }

    // Khối static đưuọc gọi trước main
    static {
        System.out.println("Đây là khối static");
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", length=" + length +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("Phương thức main trong Film");
    }
}


