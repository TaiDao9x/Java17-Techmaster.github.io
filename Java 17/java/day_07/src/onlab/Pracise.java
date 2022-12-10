package onlab;

public class Pracise {
    public static void main(String[] args) {
        Calculator result1 = new Calculator();

        result1.setNumber1(10);
        result1.setNumber2(5);

        result1.printInfo();
        System.out.println("Tổng hai số là: \t" + result1.addition());
        System.out.println("Số Number1 trừ Number2 bằng: " + result1.subtract());
        System.out.println("Số Number1 nhân Numbers bằng: " + result1.multi());
        System.out.println("Số Number1 chia Numbers bằng: " + result1.division());
    }



}

