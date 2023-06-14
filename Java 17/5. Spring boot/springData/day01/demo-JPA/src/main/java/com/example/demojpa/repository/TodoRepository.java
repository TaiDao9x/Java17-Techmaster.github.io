package com.example.demojpa.repository;

import com.example.demojpa.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
//    @Transactional
    @Modifying
    @Query(value = "update todos t set t.title = ?2, t.status=?3 where t.id=?1",nativeQuery = true)
    void updateTodo(Integer id, String title, Boolean status);

    @Transactional
    @Modifying
    @Query(value = "delete from todos t where t.id=?1", nativeQuery = true)
    void deleteTodo(Integer id);
}
