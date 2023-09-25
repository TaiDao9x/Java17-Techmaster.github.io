package com.example.day01.repository;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Getter
@Repository
public abstract class BaseRepository {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
}
