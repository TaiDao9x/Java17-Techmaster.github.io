package asbtract;

public class Developer extends Employee {

    private int overtimeHours;

    public Developer(int id, String name, int age,  int salaryBasic, int overtimeHours) {
        super(id, name, age, salaryBasic);
        this.overtimeHours = overtimeHours;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
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
        return this.getSalaryBasic() + this.getOvertimeHours() * 200000;
    }

    @Override
    void showInfo() {
        String message = String.format("íd : %d, name : %s , age : %d , salaryBasic : %d , overtimeHOur : %d , salary : %d",
                this.getId(),this.getName(), this.getAge(),this.getSalaryBasic(),this.getOvertimeHours(),calculateSalaryBasic());
        System.out.println(message);
    }
}

