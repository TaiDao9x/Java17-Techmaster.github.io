package onlab.practise;

public class Test {
    public static void main(String[] args) {

        Caculator result = new Caculator();

        result.number1 = 10;
        result.number2 = 2;

        result.printInfo();
        System.out.println("Tổng hai số bằng: " + result.addition());
        System.out.println("Number1 trừ Number2 bằng: " + result.subtract());
        System.out.println("Number1 nhân Number2 bằng: " + result.multi());
        System.out.println("Number1 chia Number2 bằng: " + result.division());

        System.out.println("-------------");
        Employee employe1 = new Employee("Đào Văn Tài", 30, "Hà Nội", 90);

        employe1.printInfo();
        System.out.println(employe1.getSalary());

    }
}
