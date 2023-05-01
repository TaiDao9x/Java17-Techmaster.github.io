package OOP;

public class Person {
    public String name;
    private int age;
    private float height;

    public Person() {
    }

    public Person(String newName, int newAge, float newHeight) {
        name = newName;
        age = newAge;
        height = newHeight;
    }

    public void eat(String foodName) {
        System.out.println(name + " eat " + foodName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    public void printInfo() {
        System.out.printf("%-20s %-10s %-10s \n", "name", "age", "height");
        System.out.printf("%-20s %-10d %-10.2f", this.name, this.age, this.height);
    }
}
