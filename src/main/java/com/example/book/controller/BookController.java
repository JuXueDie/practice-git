package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class BookController {

    @Autowired
    private BookRepository bookRepository;


    @GetMapping(value = "/v1/book", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/v1/book")
    public ResponseEntity<?> addBook(@RequestBody final Book book) {
        bookRepository.save(book);
        return ResponseEntity.ok("aaa");
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/v1/book/{bookid}")
    public ResponseEntity<?> deleteBook(@PathVariable int bookid) {
        bookRepository.deleteById(bookid);
        return ResponseEntity.ok("aaa");
    }
}