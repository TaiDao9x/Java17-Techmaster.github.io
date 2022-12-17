package employee_managerment.database;

import employee_managerment.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDatabase {
    public static ArrayList<Employee> employee = new ArrayList<>(List.of(
            new Employee(1, "Nguyễn Văn A", "a@gmail.com", 3000000),
            new Employee(2, "Hà Văn B", "b@gmail.com", 5000000),
            new Employee(3, "Đinh Thị C", "cgmail.com", 7000000),
            new Employee(4, "Ngô Thị D", "d@gmail.com", 9000000),
            new Employee(5, "Mã Văn T", "t@gmail.com", 11000000),
            new Employee(6, "Cù Tiến L", "l@gmail.com", 13000000)
    ));
}
