package com.example.demojparelationship.repository;

import com.example.demojparelationship.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FileRepository extends JpaRepository<Image, Integer> {

    @Query(nativeQuery = true, value = "select * from image i where i.user_id=?1")
    List<Image> findAllImageByUserId(Integer id);
}
