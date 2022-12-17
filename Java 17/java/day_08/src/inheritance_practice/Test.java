package inheritance_practice;

public class Test {
    public static void main(String[] args) {

        Developer dev1 = new Developer(1, "Tài", 30, "0969957697", "a@gmail.com", 10000000, 30);
        Developer dev2 = new Developer(2, "Tài", 30, "0969957697", "a@gmail.com", 10000000, 30);
        Tester test1 = new Tester(3, "A", 25, "123456789", "b@gmail.com", 3000000, 50);
        Tester test2 = new Tester(4, "A", 25, "123456789", "b@gmail.com", 3000000, 50);


        System.out.println(dev1);
        System.out.println();
        System.out.println(test1);

    }

}
