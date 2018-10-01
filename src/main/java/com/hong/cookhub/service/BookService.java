package com.hong.cookhub.service;

import com.hong.cookhub.model.Book;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hong2 on 2018. 10. 2.
 * Time : AM 12:03
 */

@Service
public class BookService {

    private final Map<String, Book> bookRepository = new ConcurrentHashMap<String, Book>();

    @PostConstruct
    public void loadDummyData() {
        Book book = new Book();
        book.setBookId("1234");
        book.setName("슬랙으로 살아남기");
        book.setAuthor("hongE");

        bookRepository.put(book.getBookId(), book);
    }

    public Book find(String bookId) {
        Book book = bookRepository.get(bookId);
        return book;
    }

    public Book create(Book book) {
        String bookId = UUID.randomUUID().toString();
        book.setBookId(bookId);
        bookRepository.put(book.getBookId(), book);

        return book;
    }
}
