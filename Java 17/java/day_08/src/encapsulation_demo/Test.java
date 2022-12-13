package encapsulation_demo;

public class Test {
    public static void main(String[] args) {
//        Person person = new Person();
//        person.setId(1);
//        person.setName("Tài");
//        person.setAge(30);
//        person.setEmail("Tai@gmail.com");
//
//        System.out.println(person);

        Student std = new Student("MSV12345", 9.8, 30, "36");

        std.showInfo();

        System.out.println(std.checkScholarship(std));

    }
}
