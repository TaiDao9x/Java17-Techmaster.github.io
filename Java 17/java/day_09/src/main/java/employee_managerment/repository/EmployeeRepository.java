package employee_managerment.repository;

import employee_managerment.database.EmployeeDatabase;
import employee_managerment.model.Employee;

import java.util.ArrayList;

public class EmployeeRepository {
    public ArrayList<Employee> findAll() {
        return EmployeeDatabase.employee;
    }

    public void save(Employee employee) {
        EmployeeDatabase.employee.add(employee);
    }

    public ArrayList<Employee> findByName(String name) {
        ArrayList<Employee> rs = new ArrayList<>();
        for (Employee e : EmployeeDatabase.employee) {
            if (e.getName().toLowerCase().contains(name.toLowerCase())) {
                rs.add(e);
            }
        }
        return rs;
    }

    public Employee findById(int id) {
        for (Employee e : EmployeeDatabase.employee) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        ArrayList<Employee> toRemove = new ArrayList<>();
        for (Employee e : EmployeeDatabase.employee) {
            if (e.getId() == (id)) {
                toRemove.add(e);
            }
        }
        if (toRemove.size() > 0) {
            EmployeeDatabase.employee.removeAll(toRemove);
        }else {
            System.out.println("Không có nhân viên nào có ID = "+id);
        }

    }

    public ArrayList<Employee> findBySalary(int minSalary, int maxSalary) {
        ArrayList<Employee> arrayList = new ArrayList<>();
        for (Employee e : EmployeeDatabase.employee) {
            if (e.getSalary() >= minSalary && e.getSalary() <= maxSalary) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }
}
