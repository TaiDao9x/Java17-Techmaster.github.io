package asbtract;

import java.util.ArrayList;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        Employee employe = new Developer(1, "Ta", 24, 5_000_000, 40);
        System.out.println(employe.calculateSalaryBasic());
        System.out.println();

        Employee employe1 = new Tester(2, "B", 26, 10_000_000, 10);
        System.out.println(employe1.calculateSalaryBasic());
        System.out.println();

        // Tạo danh sách nhân viên
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employe);
        employees.add(employe1);
        employees.add(new Developer(3, "C", 30, 8_000_000, 15));
        employees.add(new Tester(4, "D", 29, 30000000, 5));

        System.out.println("In ra lương của từng nhân viên: ");
        for (Employee employee : employees) {
            System.out.println(employee.calculateSalaryBasic());
        }

//        Sắp xếp giảm dần
        for (int i = 0; i < employees.size(); i++) {
            for (int j = i + 1; j < employees.size(); j++) {
                if (employees.get(i).calculateSalaryBasic() < employees.get(j).calculateSalaryBasic()) {

                    Employee middleEmployee = employees.get(j);
                    employees.set(j, employees.get(i));
                    employees.set(i, middleEmployee);
                }
            }
        }
        System.out.println("Lương giảm dần vơ for: ");
        for (Employee e : employees) {
            System.out.println(e.calculateSalaryBasic());
        }

// Sắp xếp theo lương giảm dần

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {

                //1,0,-1
                return o2.calculateSalaryBasic() - o1.calculateSalaryBasic();
            }
        });
        System.out.println("In ra lương giảm dần 1");
        for (Employee employee : employees) {
            System.out.println(employee);

        }

        //Sử dụng stream
        // Method reference, lambda expression
        System.out.println();
        System.out.println("Lương cơ ban tăng dần:");
        employees.stream().sorted(Comparator.comparingInt(Employee::getSalaryBasic)).
                forEach(Employee::showInfo);
    }
}
