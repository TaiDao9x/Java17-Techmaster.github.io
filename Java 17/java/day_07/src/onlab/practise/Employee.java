package onlab.practise;

public class Employee {

    public String name;
    public int age;
    public String address;
    public int totalHours;

    public Employee() {
    }

    public Employee(String name, int age, String address, int totalHours) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.totalHours = totalHours;
    }

    public void printInfo() {
        System.out.println("Tên: " + name + ", tuổi: " + age + ", địa chỉ: " + address + ", Lương: " + totalHours);
    }

    public int getSalary() {
        int bonus;
        int salary = totalHours * 200000;

        if (totalHours >= 200) {
            bonus = (salary * 20) / 100;
        } else if (totalHours >= 100) {
            bonus = (salary * 10) / 100;
        } else {
            bonus = 0;
        }
        return salary + bonus;
    }


}
