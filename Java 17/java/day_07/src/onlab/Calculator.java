package onlab;

public class Calculator {
    public int number1;
    public int number2;

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public void printInfo() {
        System.out.println("Số number 1 là: \t" + this.getNumber1());
        System.out.println("Số number 2 là: \t" + this.getNumber2());
    }

    public int addition() {
        return (number1 + number2);
    }

    public int subtract() {
        return (this.getNumber1() - this.getNumber2());
    }

    public int multi() {
        return (this.getNumber1() * this.getNumber2());
    }

    public int division() {
        return (this.getNumber1() / this.getNumber2());
    }
}
