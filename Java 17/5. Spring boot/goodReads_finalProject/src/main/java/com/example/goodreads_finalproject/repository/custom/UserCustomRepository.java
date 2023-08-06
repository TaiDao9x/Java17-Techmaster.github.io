package com.example.goodreads_finalproject.repository.custom;

import com.example.goodreads_finalproject.entity.Category;
import com.example.goodreads_finalproject.model.request.BookSearchRequest;
import com.example.goodreads_finalproject.model.request.UserSearchRequest;
import com.example.goodreads_finalproject.model.response.BookResponse;
import com.example.goodreads_finalproject.model.response.BookSearchResponse;
import com.example.goodreads_finalproject.model.response.UserResponse;
import com.example.goodreads_finalproject.repository.BaseRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserCustomRepository extends BaseRepository {
    public List<UserResponse> searchUser(UserSearchRequest request) {

        StringBuilder sql = new StringBuilder();
        HashMap<String, Object> parameters = new HashMap<>();
        sql.append("select ");
        sql.append("b.id, ");
        sql.append("b.email, ");
        sql.append("b.activated, ");
        sql.append("r.name, ");
        sql.append("b.avatar, ");
        sql.append("b.fullName, ");
        sql.append("b.gender, ");
        sql.append("b.dob, ");
        sql.append("b.phone, ");
        sql.append("w.full_name AS ward_name, ");
        sql.append("d.full_name AS district_name, ");
        sql.append("p.full_name AS province_name ");
        sql.append("from users b ");
        sql.append("left join user_role AS ur ON b.id=ur.user_id ");
        sql.append("left join roles AS r ON ur.role_id=r.id ");
        sql.append("left join wards AS w ON b.ward_code=w.code ");
        sql.append("left join districts d AS w ON w.district_code = d.code ");
        sql.append("left join provinces p AS w ON d.province_code = p.code ");

        sql.append("where 1=1");

        if (request.getEmail() != null && !request.getEmail().trim().equals("")) {
            sql.append(" and lower(b.title) like :title");
            parameters.put("title", "%" + request.getEmail().toLowerCase() + "%");
        }
        if (request.getFullname() != null && !request.getFullname().trim().equals("")) {
            sql.append(" and lower(b.author) like :author");
            parameters.put("author", "%" + request.getFullname().toLowerCase() + "%");
        }

//        sql.append(" group by b.id");

        List<UserResponse> userResponses = getNamedParameterJdbcTemplate().query(sql.toString(), parameters, BeanPropertyRowMapper.newInstance(UserResponse.class));

        return userResponses;
    }

    private Set<Category> convertCategory(String CategoryString) {
        Set<Category> categorySet = new HashSet<>();
        if (CategoryString != null && !CategoryString.isEmpty()) {
            String[] categoriesArray = CategoryString.split(", ");
            for (String c : categoriesArray) {
                Category category = new Category();
                category.setName(c);
                categorySet.add(category);
            }
        }
        return categorySet;
    }

    public void deleteBookCategories(Long bookId) {
        String sql = "delete from book_category where book_id=:bookId";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("bookId", bookId);
        getNamedParameterJdbcTemplate().update(sql, parameters);
    }
}
