package com.example.day01.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.*;

@RestControllerAdvice
public class CustomExceptionHandler {
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<?> handlerNotFoundException(NotFoundException ex, WebRequest req) {
//        // Log err
//
//        ErrorResponse err = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
//        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(BadRequestException.class)
//    public ResponseEntity<?> handlerBadRequestException(BadRequestException ex, WebRequest req) {
//        // Log err
//
//        ErrorResponse err = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
//        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(InternalServerException.class)
//    public ResponseEntity<?> handlerInternalServerException(InternalServerException ex, WebRequest req) {
//        // Log err
//
//        ErrorResponse err = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
//        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    // Xử lý tất cả các exception chưa được khai báo
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> handlerException(Exception ex, WebRequest req) {
//        // Log err
//
//        ErrorResponse err = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
//        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
    @Autowired
    private MessageSource msgSource;

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<?> processValidationError(MethodArgumentNotValidException ex) {
//        BindingResult result = ex.getBindingResult();
//        List<FieldError> fieldErrors = result.getFieldErrors();
//        String msg = "";
//        for (FieldError err : fieldErrors) {
//            String tmp = processFieldError(err);
//            msg = msg + " " + tmp + "\n";
//        }
//        ErrorResponse err = new ErrorResponse(HttpStatus.BAD_REQUEST, msg);
//        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
//    }
//
//    private String processFieldError(FieldError error) {
//        String msg = "";
//        if (error != null) {
//            Locale currentLocale = LocaleContextHolder.getLocale();
//            try {
//                msg = msgSource.getMessage(Objects.requireNonNull(error.getDefaultMessage()), null, currentLocale);
//            } catch (Exception e) {
//                msg = error.getDefaultMessage();
//            }
//        }
//        return msg;
//    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> processValidationError(MethodArgumentNotValidException ex) {
        Map<Object, Object> response = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            response.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, response);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
