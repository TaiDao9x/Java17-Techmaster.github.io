public class MethodDemo {
    public static void main(String[] args) {
        // Công việc A: tốn 20 dòng code
        // Thực hiện cv A 20 lần: Tốn 200 dòng code
        //Có method: tốn thêm 20 dòng để gọi

        int data = sumTwoNumber(3, 4);
        System.out.println("data = " + data);

        System.out.println(sumTwoNumber(10, 20));

        sayHello();

        // cách 2: Định nghĩa đối tượng -> gọi method của đối tượng (thể hiện, íntance
        // Class : Khuôn bánh (chỉ có 1)
        // Object : Bánh sinh ra từ khuôn (có nhiều)
        MethodDemo methodDemo = new MethodDemo();
        methodDemo.sayHelloWithName("Đào Tài");

    }

        // Tính tổng 2 số : trả về kết quả là tổng của 2 số a, b
        // Tham số : parameter (giá trị chưa biết trước, chưa biết trước khi định nghĩa method)
        // Đối số : argument (giá trị thật khi gọi method)
    public static int sumTwoNumber(int a, int b) {
        return a + b;
        // Những câu lệnh sau từ khóa "return" sẽ không được thực thi
    }

    public static void sayHello() {
        System.out.println("Xin chào các bạn");
    }

    public void sayHelloWithName(String name) {
        System.out.println("Xin chào " + name);
    }
}
