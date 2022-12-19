package homework_10_student_managerment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Student {
    private int id;
    private String name;
    private int age;
    private String address;
    private double point;
    private String classroom;

    @Override
    public String toString() {
        System.out.printf("%-5d %-20s %-5d %-15s %-10.1f %-10s", this.getId(), this.getName(),
                this.getAge(), this.getAddress(), this.getPoint(), this.getClassroom());
        return "";
    }
}
