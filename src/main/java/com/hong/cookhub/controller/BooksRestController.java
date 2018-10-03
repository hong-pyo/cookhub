package com.hong.cookhub.controller;

import com.hong.cookhub.model.Book;
import com.hong.cookhub.model.BookResource;
import com.hong.cookhub.model.BookResourceQuery;
import com.hong.cookhub.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hong2 on 2018. 10. 2.
 * Time : AM 12:03
 */

@RestController
@RequestMapping(value = "books")
public class BooksRestController {

    private String url = "http://localhost:8080/books";

    @Autowired
    private BookService bookService;

    @RequestMapping(path = "/{bookId}", method = RequestMethod.GET)
    public BookResource getBook(@PathVariable String bookId) {
        Book book = bookService.find(bookId);
        BookResource resource = new BookResource();
        resource.setBookId(book.getBookId());
        resource.setName(book.getName());
        resource.setAuthor(book.getAuthor());
        return resource;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createBook(@RequestBody BookResource newResource) {

        Book newBook = new Book();
        newBook.setName(newResource.getName());
        newBook.setAuthor(newResource.getAuthor());

        Book createdBook = bookService.create(newBook);

        String resourceUri = url + createdBook.getBookId();

        return ResponseEntity.created(URI.create(resourceUri)).build();
    }

    @RequestMapping(path = "{bookId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable String bookId, @Validated @RequestBody BookResource bookResource) {

        Book book = new Book();
        book.setBookId(bookId);
        book.setName(bookResource.getName());
        book.setAuthor(bookResource.getAuthor());
        bookService.update(book);
    }

    @RequestMapping(path = "{bookId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String bookId) {
        bookService.delete(bookId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BookResource> searchBooks(@Validated BookResourceQuery query) {
        BookResourceQuery criteria = new BookResourceQuery();
        criteria.setName(query.getName());
        criteria.setAuthor(query.getAuthor());

        List<Book> books = bookService.findAllByCreteria(criteria);
        return books.stream().map(book -> {
            BookResource resource = new BookResource();
            resource.setBookId(book.getBookId());
            resource.setName(book.getName());
            resource.setAuthor(book.getAuthor());
            return resource;
        }).collect(Collectors.toList());
    }
}
