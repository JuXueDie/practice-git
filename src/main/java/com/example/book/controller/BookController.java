package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.repository.BookRepository;
import com.example.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/v1/book", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Book> getAll() {
//        return bookRepository.findAll();
        return bookService.getBooks();
    }

    @PostMapping(value = "/v1/book")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
//        bookRepository.save(book);
        bookService.addBook(book);
        return ResponseEntity.ok("Post successed.");
    }

    @DeleteMapping(value = "/v1/book/{bookid}")
    public ResponseEntity<?> deleteBook(@PathVariable int bookid) {
//        bookRepository.deleteById(bookid);
        bookService.deleteBook(bookid);
        return ResponseEntity.ok("Delete successed.");
    }

    @PutMapping(value = "/v1/book/{bookid}")
    public ResponseEntity<?> editBook(@RequestBody Book book, @PathVariable int bookid) {
        book.setBookid(bookid);
        boolean result = bookService.editBook(book);
        if (result) {
            return ResponseEntity.ok("put: successed.");
        }
        else {
            return ResponseEntity.ok("bookid： " + bookid + "Not found.");
        }
//        Optional<Book> optionalBook = bookRepository.findById(bookid);
//        if (optionalBook.isPresent()) {
//            book.setBookid(bookid);
//            bookRepository.save(book);
//            return ResponseEntity.ok("Put successed.");
//        }
//        else {
//            return ResponseEntity.ok("bookid： " + bookid + "Not found.");
//        }
    }
}