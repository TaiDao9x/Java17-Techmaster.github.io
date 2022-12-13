package inheritance_demo;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog("Husky", "white", 4);
        dog.eat();
        dog.display();

        Dog dog1 = new Dog();
        dog1.setName("Pittbull");
        dog1.setColor("Brown");
        dog1.setLegs(4);

        dog1.display();
        dog1.eat();
    }
}
