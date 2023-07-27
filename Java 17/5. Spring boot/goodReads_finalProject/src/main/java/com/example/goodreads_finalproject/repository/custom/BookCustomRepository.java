package com.example.goodreads_finalproject.repository.custom;

import com.example.goodreads_finalproject.model.request.BookSearchRequest;
import com.example.goodreads_finalproject.model.response.BookSearchResponse;
import com.example.goodreads_finalproject.repository.BaseRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class BookCustomRepository extends BaseRepository {
    public List<BookSearchResponse> searchBook(BookSearchRequest request) {

        StringBuilder sql = new StringBuilder();
        HashMap<String, Object> parameters = new HashMap<>();
        sql.append("select ");
        sql.append("b.id, ");
        sql.append("b.image, ");
        sql.append("b.title, ");
//        sql.append("b.categories, ");
        sql.append("b.author, ");
        sql.append("b.description, ");
        sql.append("b.rating, ");
        sql.append("b.published,");
        sql.append("b.buy_book buyBook ");
        sql.append("from books b ");
        sql.append("where 1=1");

        if (request.getTitle() != null && !request.getTitle().trim().equals("")) {
            sql.append(" and lower(b.title) like :title");
            parameters.put("title", "%" + request.getTitle().toLowerCase() + "%");
        }
        if (request.getAuthor() != null && !request.getAuthor().trim().equals("")) {
            sql.append(" and lower(b.author) like :author");
            parameters.put("author", "%" + request.getAuthor().toLowerCase() + "%");
        }
        return getNamedParameterJdbcTemplate().query(sql.toString(), parameters, BeanPropertyRowMapper.newInstance(BookSearchResponse.class));

    }
}
