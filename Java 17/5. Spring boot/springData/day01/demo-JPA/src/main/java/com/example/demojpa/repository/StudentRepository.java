package com.example.demojpa.repository;

import com.example.demojpa.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Tìm kiếm theo tên và phân trang

    Page<Student> findByName(String name, Pageable pageable);

    Page<Student> findByNameContainingIgnoreCase(String name, Pageable pageable);

    // Sử dụng navetive query
    @Query(
            nativeQuery = true,
            value = "select * from students",
            countQuery = "select count(id) from students"
    )
    Page<Student> getAllStudent(Pageable pageable);

    @Query(nativeQuery = true,
            value = "select * from students s where s.name like %:name%",
            countQuery = "select count(id) from  students s where s.name like %:name%")
    Page<Student> findByNameContainingUsingNq(@Param("name") String name, Pageable pageable);


    List<Student> findByNameOrderByNameDesc(String name);// nhanh nhat

    List<Student> findByName(String name, Sort sort);//dung cho nhieu truong hop khac nhau

    @Query(nativeQuery = true, value = "select * from students where name=?1 order by name desc ")
    List<Student> findByNameUsingNQ(String name);

}
