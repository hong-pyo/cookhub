package com.hong.cookhub.service;

import com.hong.cookhub.controller.BookResourceNotFoundException;
import com.hong.cookhub.model.Book;
import com.hong.cookhub.model.BookPublisher;
import com.hong.cookhub.model.BookResourceQuery;
import com.hong.cookhub.utils.StringFormatter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

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
        BookPublisher bookPublisher = getInitBookPublisher();

        //book.setLocalDate(LocalDate.now());
        book.setPublisher(bookPublisher);

        bookRepository.put(book.getBookId(), book);
    }

    private BookPublisher getInitBookPublisher() {
        BookPublisher bookPublisher = new BookPublisher();
        bookPublisher.setName("Kyu Publisher");
        bookPublisher.setTel(StringFormatter.format("%s-%s-%s","010","3954","0597"));

        return bookPublisher;
    }

    public Book find(String bookId) {
        Book book = bookRepository.get(bookId);
        if (book == null) {
            throw new BookResourceNotFoundException(bookId);
        }
        return book;
    }

    public Book create(Book book) {
        String bookId = UUID.randomUUID().toString();
        book.setBookId(bookId);
        bookRepository.put(book.getBookId(), book);

        return book;
    }

    public Book update(Book book) {
        return bookRepository.put(book.getBookId(), book);
    }

    public Book delete(String bookId) {
        return bookRepository.remove(bookId);
    }


    public List<Book> findAllByCreteria(BookResourceQuery criteria) {
        return bookRepository.values().stream().filter(book ->
                (criteria.getName() == null || book.getName().contains(criteria.getName())) &&
                (criteria.getAuthor() == null || book.getAuthor().equals(criteria.getAuthor())))
                .collect(Collectors.toList());
    }
}
