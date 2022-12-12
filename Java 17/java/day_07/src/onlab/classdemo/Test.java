package onlab.classdemo;

import onlab.practise.Caculator;

public class Test {
    public static void main(String[] args) {
        // Tạo ra đối tượng từ class
        Person personOne = new Person();

        System.out.println(personOne.name);
        System.out.println(personOne.age);

        // Gán các giá trị cho thuộc tính của đối tượng
        personOne.name = "Nguyễn Văn A";
        personOne.email = "a@gmail.com";
        personOne.age = 25;
        personOne.address = "Hà Nội";

        // in ra thông tin của đối tượng
        System.out.println(personOne.name + " - " + personOne.email + personOne.age + personOne.address);

        //Gọi phương thức
        personOne.showInfo();
        personOne.eat();
        personOne.play("Bóng đá");

        System.out.println(personOne);


        //KHởi tạo đối tượng phone
        Phone phone = new Phone();
        phone.name = "iPhone 14 pro";
        phone.brand = "Apple";

        personOne.usePhone(phone);

        Caculator result = new Caculator();

        result.number1 = 10;
        result.number2 = 2;

        result.printInfo();
        System.out.println("Tổng hai số bằng: " + result.addition());
        System.out.println("Number1 trừ Number2 bằng: " + result.subtract());
        System.out.println("Number1 nhân Number2 bằng: " + result.multi());
        System.out.println("Number1 chia Number2 bằng: " + result.division());


        Person person1 = new Person("Trần Văn B", "b@gmail.com");
        System.out.println(person1);

        Person person2 = new Person("Trần Văn C", "c@gmail.com", 30, "Hà Nội");
        System.out.println(person2);
    }
}
