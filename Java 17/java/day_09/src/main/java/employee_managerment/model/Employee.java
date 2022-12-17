package employee_managerment.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class Employee {
    private int id;
    private String name;
    private String email;
    private int salary;

    @Override
    public String toString() {
        System.out.printf("%-5d %-20s %-20s %-15d", this.getId(), this.getName(), this.getEmail(), this.getSalary());
        return "";
    }
}
