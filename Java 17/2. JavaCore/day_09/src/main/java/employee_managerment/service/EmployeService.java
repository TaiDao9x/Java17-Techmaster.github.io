package employee_managerment.service;

import employee_managerment.model.Employee;
import employee_managerment.repository.EmployeeRepository;

import java.util.ArrayList;

public class EmployeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    public void printAllEmployee() {
        System.out.printf("%-5s %-20s %-20s %-15s\n", "Id", "Name", "Email", "Salary");
        for (Employee e : employeeRepository.findAll()) {
            System.out.println(e);
        }
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void findByName(String name) {
        System.out.printf("%-5s %-20s %-20s %-15s\n", "Id", "Name", "Email", "Salary");
        for (Employee e : employeeRepository.findByName(name)) {
            System.out.println(e);
        }
    }

    public Employee findById(int id) {
        System.out.printf("%-5s %-20s %-20s %-15s\n", "Id", "Name", "Email", "Salary");
        return employeeRepository.findById(id);
    }

    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    public void findBySalary(int minSalary, int maxSalary) {
        System.out.printf("%-5s %-20s %-20s %-15s\n", "Id", "Name", "Email", "Salary");
        for (Employee e : employeeRepository.findBySalary(minSalary, maxSalary)) {
            System.out.println(e);
        }
    }
}
