package asbtract;

public class Tester extends Employee {
    private int error;

    public Tester(int id, String name, int age, int salaryBasic, int error) {
        super(id, name, age, salaryBasic);
        this.error = error;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", salaryBasic=" + super.getSalaryBasic() +
                ", salary=" + this.calculateSalaryBasic() +
                '}';
    }

    @Override
    public int calculateSalaryBasic() {
        return this.getSalaryBasic() + this.getError() * 200000;
    }

    void showInfo() {
        String message = String.format("íd : %d, name : %s , age : %d , salaryBasic : %d , error : %d , salary : %d",
                this.getId(), this.getName(), this.getAge(), this.getSalaryBasic(), this.getError(), calculateSalaryBasic());
        System.out.println(message);
    }
}
