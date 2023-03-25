package onlab.practise;

public class Caculator {
    public int number1;
    public int number2;

    public void printInfo() {
        System.out.println("Số number1 là: " + number1);
        System.out.println("Số number2 là: " + number2);
    }

    public int addition() {
        return number1 + number2;
    }

    public int subtract() {
        return number1 - number2;
    }

    public int multi() {
        return number1 * number2;
    }

    public double division() {
        if (number2 == 0) {
            System.out.println("Không thực hiện được phép chia cho 0");
        }
        return (double) (number1 / number2);
    }
}
