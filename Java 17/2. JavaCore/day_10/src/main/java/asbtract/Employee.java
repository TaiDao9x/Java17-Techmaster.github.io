package asbtract;


abstract public class Employee {

    private int id;
    private String name;
    private int age;
    private int salaryBasic;

    public Employee() {
    }

    public Employee(int id, String name, int age,  int salaryBasic) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salaryBasic = salaryBasic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalaryBasic() {
        return salaryBasic;
    }

    public void setSalaryBasic(int salaryBasic) {
        this.salaryBasic = salaryBasic;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salaryBasic=" + salaryBasic +
                '}';
    }


    // Diểm danh (normal method)
    public void register(){
        System.out.println("Register...");
    }

    // Tính lương
    abstract public int calculateSalaryBasic();

    abstract void showInfo();
}
