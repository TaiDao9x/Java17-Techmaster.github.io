package com.example.goodreads_finalproject.model.request;

import lombok.Data;

@Data
public class UserSearchRequest extends BaseSearchRequest {
    String email;
    String fullname;
}
