package com.example.demojpa.repository;

import com.example.demojpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Method JPA
    List<Employee> findAllByDepartment(String department);

    List<Employee> findAllBySalaryGreaterThan(long salary);

    List<Employee> findAllByName(String name);

    List<Employee> findAllByNameContaining(String keyword);

    List<Employee> findAllByNameStartsWith(String prefix);

    List<Employee> findAllBySalaryBetween(long min, long max);

    List<Employee> countByDepartment(String department);

    List<Employee> findAllByNameContainingAndDepartment(String keyword, String department);

    List<Employee> findAllByNameOrDepartment(String name, String department);

    List<Employee> findAllByJoiningDateAfter(LocalDate date);


    // Native query
    @Query(nativeQuery = true, value = "select * from employee e where e.department=:department")
    List<Employee> findAllByDepartmentUsingNativeQuery(@Param("department") String department);

    @Query(nativeQuery = true, value = "select * from employee e where e.salary>?1")
    List<Employee> findAllBySalaryGreaterThanUsingNativeQuery(@Param("salary") long salary);

    @Query(nativeQuery = true, value = "select * from employee e where e.name=:name")
    List<Employee> findAllByNameUsingNativeQuery(@Param("name") String name);

    @Query(nativeQuery = true, value = "select * from employee e where e.name like %?1%")
    List<Employee> findAllByNameContainingUsingNativeQuery(@Param("keyword") String keyword);

    // TODO: không dùng được @Param
    @Query(nativeQuery = true, value = "select * from employee e where e.name like ?1%")
    List<Employee> findAllByNameStartsWithUsingNativeQuery(@Param("prefix") String prefix);

    @Query(nativeQuery = true, value = "select * from employee e where e.salary between ?1 and ?2 ")
    List<Employee> findAllBySalaryBetweenUsingNativeQuery(@Param("min") long min, @Param("max") long max);

    @Query(nativeQuery = true, value = "select count(*) from employee e where e.department=:department")
    List<Employee> countByDepartmentUsingNativeQuery(@Param("department") String department);

    @Query(nativeQuery = true, value = "select * from employee e where e.name like ?1% and e.department=?2")
    List<Employee> findAllByNameContainingAndDepartmentUsingNativeQuery(@Param("keyword") String keyword, @Param("department") String department);

    @Query(nativeQuery = true, value = "select * from employee e where e.name=:name or e.department=:department")
    List<Employee> findAllByNameOrDepartmentUsingNativeQuery(@Param("name") String name, @Param("department") String department);

    @Query(nativeQuery = true, value = "select * from employee e where (e.joining_date - ?1 >0)")
    List<Employee> findAllByJoiningDateAfterUsingNativeQuery(@Param("date") LocalDate date);
}
