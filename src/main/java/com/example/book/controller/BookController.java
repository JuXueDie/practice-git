package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.repository.BookRepository;
import com.example.book.response.BasicSuccessResp;
import com.example.book.response.ErrorResponse;
import com.example.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static com.example.book.utils.ResponseErrorCode.BAD_REQUEST;

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
        boolean result = bookService.addBook(book);
        return getResponseEntity(result);
    }

    @DeleteMapping(value = "/v1/book/{bookid}")
    public ResponseEntity<?> deleteBook(@PathVariable int bookid) {
//        bookRepository.deleteById(bookid);
        boolean result = bookService.deleteBook(bookid);
        return getResponseEntity(result);
    }

    @PutMapping(value = "/v1/book/{bookid}")
    public ResponseEntity<?> editBook(@RequestBody Book book, @PathVariable int bookid) {
        book.setBookid(bookid);
        boolean result = bookService.editBook(book);
        return getResponseEntity(result);

    }


    @GetMapping(value = "/v1/book/{bookid}")
    public ResponseEntity<?> getBook(@PathVariable int bookid) {
        Book book = bookService.getBook(bookid);
        if (book == null) {
            ErrorResponse errorResponse = new ErrorResponse(BAD_REQUEST);
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    private ResponseEntity<?> getResponseEntity(boolean result) {
        if (!result) {
            ErrorResponse errorResponse = new ErrorResponse(BAD_REQUEST);
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        BasicSuccessResp resp = new BasicSuccessResp();
        resp.setSuccess(true);
        return ResponseEntity.ok(resp);
    }
}