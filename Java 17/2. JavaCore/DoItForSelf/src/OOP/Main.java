package OOP;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Person person1 = new Person("tai", 30, 2);
//        person1.eat("rice");
//        System.out.println(person1);
//        person1.printInfo();
//
        int[] a = {1, 2, 3};
        int[] b = a.clone();
        a[0] = 10;

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        Person newPerson;
    }
}
