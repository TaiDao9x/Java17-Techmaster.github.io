package com.example.day01.repository.custom;

import com.example.day01.model.request.UserSearchRequest;
import com.example.day01.model.response.UserResponse;
import com.example.day01.repository.BaseRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class UserCustomRepository extends BaseRepository {
    public List<UserResponse> searchUser(UserSearchRequest request) {
        StringBuilder sql = new StringBuilder();
        HashMap<String, Object> parameters = new HashMap<>();
        sql.append("select ");
        sql.append("b.id, ");
        sql.append("b.email, ");
        sql.append("b.full_name, ");
        sql.append("b.phone ");
        sql.append("from users b ");

        sql.append("where 1=1");

        if (request.getEmail() != null && !request.getEmail().trim().equals("")) {
            sql.append(" and lower(b.email) like :email");
            parameters.put("email", "%" + request.getEmail().toLowerCase() + "%");
        }
        if (request.getFullName() != null && !request.getFullName().trim().equals("")) {
            sql.append(" and lower(b.full_name) like :fullName");
            parameters.put("fullName", "%" + request.getFullName().toLowerCase() + "%");
        }

        return getNamedParameterJdbcTemplate().query(sql.toString(), parameters, BeanPropertyRowMapper.newInstance(UserResponse.class));
    }
}
