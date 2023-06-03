package com.example.demojpa;

import com.example.demojpa.entity.Employee;
import com.example.demojpa.entity.User;
import com.example.demojpa.repository.EmployeeRepository;
import com.example.demojpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoJpaApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;



    @Test
    void save_user() {
        User user = new User(null, "Tai", "tai@gmail.com", LocalDate.now().plusYears(30), true);
        userRepository.save(user);
    }

    @Test
    void save_user_list() {
        List<User> users = List.of(
                new User(null, "a", "a@gmail.com", LocalDate.now().minusYears(30), true),
                new User(null, "b", "b@gmail.com", LocalDate.now().minusYears(25), true),
                new User(null, "c", "c@gmail.com", LocalDate.now().minusYears(25), false)
        );
        userRepository.saveAll(users);
    }

    @Test
    void find_user() {
        // findById
        Optional<User> userOptional = userRepository.findById(1);
        userOptional.ifPresent(System.out::println);

        //update
        User user = userOptional.get();
        user.setName("Tai Update");
        userRepository.save(user);

        // findAll
        List<User> userList = userRepository.findAll();
        userList.forEach(System.out::println);
    }
//
//    @Test
//    void test_findByName() {
//        List<User> userList = userRepository.findByName("a");
//        userList.forEach(System.out::println);
//
//        System.out.println("existsByEmail:");
//        System.out.println(userRepository.existsByEmail("a@gmail.com"));
//    }

    @Test
    void example_query_test() {
        User user = userRepository.findByEmail("a@gmail.com").orElse(null);
        User user1 = userRepository.findByEmailUsingJPQL("a@gmail.com").orElse(null);
        User user2 = userRepository.findByEmailUsingNativeQuery("a@gmail.com").orElse(null);

        System.out.println("user: " + user);
        System.out.println("user1: " + user1);
        System.out.println("user2: " + user2);

    }

    // Employee
    @Test
    void save_employee_list() {
        List<Employee> employeeList = List.of(
                new Employee(null, "Tai", "Kinh Doanh", 10000000, LocalDate.now().minusYears(1)),
                new Employee(null, "b", "HCNS", 8000000, LocalDate.now().minusYears(1)),
                new Employee(null, "c", "Ke Toan", 12000000, LocalDate.now().minusYears(1)),
                new Employee(null, "d", "Kho", 7000000, LocalDate.now().minusYears(1)),
                new Employee(null, "e", "kinh doanh", 13000000, LocalDate.now().minusYears(1))
        );
        employeeRepository.saveAll(employeeList);

    }

    @Test
    void test_findByDepartment() {
        List<Employee> employeeList = employeeRepository.findAllByDepartment("kinh doanh");
        List<Employee> employeeList1 = employeeRepository.findAllByDepartmentUsingNativeQuery("Kinh doanh");
        System.out.println("1. Tìm kiếm tất cả các employee thuộc 1 phòng ban được chỉ định:");
        employeeList.forEach(System.out::println);
        employeeList1.forEach(System.out::println);

        List<Employee> employeeList2 = employeeRepository.findAllBySalaryGreaterThanUsingNativeQuery(10000000L);
        System.out.println("2. Tìm kiếm tất cả các employee có salary lớn hơn 1 giá trị được chỉ định:");
        employeeList2.forEach(System.out::println);

        List<Employee> employeeList4 = employeeRepository.findAllByNameContainingUsingNativeQuery("A");
        System.out.println("4. Tìm kiếm tất cả các employee trong tên có chứa 1 keyword được chỉ định (không phân biệt hoa thường):");
        employeeList4.forEach(System.out::println);

        List<Employee> employeeList5 = employeeRepository.findAllByNameStartsWithUsingNativeQuery("b");
        System.out.println("5. Tìm kiếm tất cả các employee có tên được bắt đầu với 1 chuỗi (prefix) được chỉ định:");
        employeeList5.forEach(System.out::println);

        List<Employee> employeeList6 = employeeRepository.findAllBySalaryBetweenUsingNativeQuery(10000000L, 15000000L);
        System.out.println("6.Tìm kiếm tất cả các employee có salary nằm trong khoảng chỉ định:");
        employeeList6.forEach(System.out::println);

        long employeeList7 = employeeRepository.countByDepartmentUsingNativeQuery("hcns");
        System.out.println("7. Đếm số lượng employee thuộc 1 phòng ban được chỉ định:");
        System.out.println(employeeList7);

        List<Employee> employeeList8 = employeeRepository.findAllByNameContainingAndDepartmentUsingNativeQuery("b", "hcns");
        System.out.println("8. Tìm kiếm tất cả các employee trong tên có chứa 1 keyword được chỉ định và thuộc 1 phòng ban được chỉ định:");
        employeeList8.forEach(System.out::println);

        List<Employee> employeeList9 = employeeRepository.findAllByNameOrDepartmentUsingNativeQuery("b", "KINH DOANH");
        System.out.println("9. Tìm kiếm tất cả các employee có tên được chỉ định hoặc thuộc 1 phòng ban được chỉ định:");
        employeeList9.forEach(System.out::println);

        List<Employee> employeeList10 = employeeRepository.findAllByJoiningDateAfterUsingNativeQuery(LocalDate.of(2022, 5, 25));
        System.out.println("10. Tìm kiếm tất cả các employee tham gia công ty sau 1 ngày được chỉ định:");
        employeeList10.forEach(System.out::println);

    }
}
