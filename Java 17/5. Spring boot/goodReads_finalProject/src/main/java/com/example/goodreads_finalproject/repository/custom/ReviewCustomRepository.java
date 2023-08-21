package com.example.goodreads_finalproject.repository.custom;

import com.example.goodreads_finalproject.model.request.ReviewRequest;
import com.example.goodreads_finalproject.model.response.AvgRatingResponse;
import com.example.goodreads_finalproject.repository.BaseRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ReviewCustomRepository extends BaseRepository {

    public void removeRating(Long bookId, Long userId) {
        String sql = "UPDATE reviews rv SET rv.rating=0 WHERE rv.book_id = :bookId AND rv.user_id = :userId";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("bookId", bookId);
        parameters.put("userId", userId);
        getNamedParameterJdbcTemplate().update(sql, parameters);
    }

    public void changeRating(ReviewRequest request, Long userId) {
        String sql = "UPDATE reviews rv SET rv.rating= :rating WHERE rv.book_id = :bookId AND rv.user_id = :userId";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("rating", request.getRating());
        parameters.put("bookId", request.getBookId());
        parameters.put("userId", userId);
        getNamedParameterJdbcTemplate().update(sql, parameters);
    }

    public void removeReview(Long bookId, Long userId) {
        String sql = "DELETE FROM reviews rv WHERE rv.book_id = :bookId AND rv.user_id = :userId";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("bookId", bookId);
        parameters.put("userId", userId);
        getNamedParameterJdbcTemplate().update(sql, parameters);
    }

    public List<AvgRatingResponse> calculateAvgRating(Long bookId) {
        String sql = "SELECT rv.rating, count(rv.rating) AS countOfRating FROM reviews rv WHERE rv.book_id = :bookId AND rv.rating>0 GROUP BY rv.rating";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("bookId", bookId);
        return getNamedParameterJdbcTemplate().query(sql, parameters, BeanPropertyRowMapper.newInstance(AvgRatingResponse.class));
    }

}
