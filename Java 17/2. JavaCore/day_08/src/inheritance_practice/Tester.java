package inheritance_practice;

public class Tester extends Employee {
    private int error;

    public Tester(int id, String name, int age, String phone, String email, int salaryBasic, int error) {
        super(id, name, age, phone, email, salaryBasic);
        this.error = error;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public int getSalary() {
        return super.getSalaryBasic() + getError() * 200000;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", phone='" + super.getPhone() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                ", salaryBasic=" + super.getSalaryBasic() +
                ", salary=" + getSalary() +
                '}';
    }
}
