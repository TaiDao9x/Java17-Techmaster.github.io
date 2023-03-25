package employee_managerment.repository;

import employee_managerment.database.EmployeeDatabase;
import employee_managerment.exception.InValidSalaryException;
import employee_managerment.exception.NotFoundException;
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
        throw new NotFoundException("Not found employee with id: " + id);
    }

    public void deleteById(int id) {
        Employee employee = findById(id);
        EmployeeDatabase.employee.remove(employee);

    }

    public ArrayList<Employee> findBySalary(int minSalary, int maxSalary) {

        if (minSalary >= maxSalary) {
            throw new InValidSalaryException("minSalary không được lớn hơn hoặc bằng maxSalary");
        }

        ArrayList<Employee> arrayEmployee = new ArrayList<>();
        for (Employee e : EmployeeDatabase.employee) {
            if (e.getSalary() >= minSalary && e.getSalary() <= maxSalary) {
                arrayEmployee.add(e);
            }
        }
        return arrayEmployee;
    }
}
