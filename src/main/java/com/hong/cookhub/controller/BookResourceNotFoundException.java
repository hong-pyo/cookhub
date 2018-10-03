package com.hong.cookhub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by hong2 on 2018. 10. 4.
 * Time : AM 1:48
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookResourceNotFoundException extends RuntimeException {
    public BookResourceNotFoundException(String bookId) {
        super("book is not found");
    }
}
