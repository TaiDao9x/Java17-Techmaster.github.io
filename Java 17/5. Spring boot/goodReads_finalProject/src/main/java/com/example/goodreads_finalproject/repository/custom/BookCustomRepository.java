package com.example.goodreads_finalproject.repository.custom;

import com.example.goodreads_finalproject.entity.Category;
import com.example.goodreads_finalproject.model.request.BookSearchRequest;
import com.example.goodreads_finalproject.model.response.BookResponse;
import com.example.goodreads_finalproject.model.response.BookSearchResponse;
import com.example.goodreads_finalproject.repository.BaseRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookCustomRepository extends BaseRepository {
    public List<BookResponse> searchBook(BookSearchRequest request) {

        StringBuilder sql = new StringBuilder();
        HashMap<String, Object> parameters = new HashMap<>();
        sql.append("select ");
        sql.append("b.id, ");
        sql.append("b.image, ");
        sql.append("b.title, ");
        sql.append("GROUP_CONCAT(category.name SEPARATOR ', ') categories, ");
        sql.append("b.author, ");
        sql.append("b.description, ");
        sql.append("b.rating, ");
        sql.append("b.published, ");
        sql.append("b.buy_book buyBook ");
        sql.append("from books b ");
        sql.append("left join book_category AS book_cat ON b.id=book_cat.book_id ");
        sql.append("left join categories AS category ON book_cat.category_id=category.id ");
        sql.append("where 1=1");

        if (request.getTitle() != null && !request.getTitle().trim().equals("")) {
            sql.append(" and lower(b.title) like :title");
            parameters.put("title", "%" + request.getTitle().toLowerCase() + "%");
        }
        if (request.getAuthor() != null && !request.getAuthor().trim().equals("")) {
            sql.append(" and lower(b.author) like :author");
            parameters.put("author", "%" + request.getAuthor().toLowerCase() + "%");
        }

        sql.append(" group by b.id");

        List<BookSearchResponse> bookSearchResponses = getNamedParameterJdbcTemplate().query(sql.toString(), parameters, BeanPropertyRowMapper.newInstance(BookSearchResponse.class));

        List<BookResponse> bookResponseList = new ArrayList<>();
        bookSearchResponses.forEach(bookSearchResponse -> {
            BookResponse bookResponse = BookResponse.builder()
                    .image(bookSearchResponse.getImage())
                    .title(bookSearchResponse.getTitle())
                    .author(bookSearchResponse.getAuthor())
                    .categories(convertCategory(bookSearchResponse.getCategories()))
                    .description(bookSearchResponse.getDescription())
                    .buyBook(bookSearchResponse.getBuyBook())
                    .published(bookSearchResponse.getPublished())
                    .rating(bookSearchResponse.getRating())
                    .build();
            bookResponseList.add(bookResponse);
        });
        return bookResponseList;
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
}
