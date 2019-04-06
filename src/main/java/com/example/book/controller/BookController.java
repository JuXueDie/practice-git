package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.model.BookRequest;
import com.example.book.repository.BookRepository;
import com.example.book.response.BasicSuccessResp;
import com.example.book.response.ErrorResponse;
import com.example.book.service.BookService;
import com.example.book.utils.Utils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static com.example.book.utils.ResponseErrorCode.BAD_REQUEST;

@RestController
@RequestMapping(value = "/api")
public class BookController {
    private static final Logger logger = LogManager.getLogger(BookController.class);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @PreAuthorize("hasAuthority('ROLE_NORMAL')")
    @ApiOperation(value = "取得書籍列表")
    @GetMapping(value = "/v1/book", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Book> getAll() {
//        return bookRepository.findAll();
        return bookService.getBooks();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ApiOperation(value = "新增書籍")
    @PostMapping(value = "/v1/book")
    public ResponseEntity<?> addBook(@RequestBody BookRequest body) {
//        bookRepository.save(book);
        boolean result = bookService.addBook(body);
        return Utils.getResponseEntity(result);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ApiOperation(value = "砍掉書籍")
    @DeleteMapping(value = "/v1/book/{bookid}")
    public ResponseEntity<?> deleteBook(@PathVariable int bookid) {
//        bookRepository.deleteById(bookid);
        boolean result = bookService.deleteBook(bookid);
        return Utils.getResponseEntity(result);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ApiOperation(value = "用uuid砍掉書籍")
    @DeleteMapping(value = "/v1/book/uuid/{uuid}")
    public ResponseEntity<?> deleteBookByUuid(@PathVariable String uuid) {
        boolean result = bookService.deleteBookByUuid(uuid);
        return Utils.getResponseEntity(result);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ApiOperation(value = "修改書籍")
    @PutMapping(value = "/v1/book/{bookid}")
    public ResponseEntity<?> editBook(@RequestBody BookRequest bookRequest, @PathVariable int bookid) {
        boolean result = bookService.editBook(bookRequest, bookid);
        return Utils.getResponseEntity(result);

    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ApiOperation(value = "用uuid修改書籍")
    @PutMapping(value = "/v1/book/uuid/{uuid}")
    public ResponseEntity<?> editBookByUuid(@RequestBody BookRequest bookRequest, @PathVariable String uuid) {
        boolean result = bookService.editBookByUuid(bookRequest, uuid);
        return Utils.getResponseEntity(result);

    }

    @PreAuthorize("hasAuthority('ROLE_NORMAL')")
    @ApiOperation(value = "取得一本書籍")
    @GetMapping(value = "/v1/book/{bookid}")
    public ResponseEntity<?> getBook(@PathVariable int bookid) {
        logger.info("bookid: " + bookid);
        Book book = bookService.getBook(bookid);
        return Utils.getResponseEntity(book);
    }

    @PreAuthorize("hasAuthority('ROLE_NORMAL')")
    @ApiOperation(value = "用uuid取得一本書籍")
    @GetMapping(value = "/v1/book/uuid/{uuid}")
    public ResponseEntity<?> getBookByUuid(@PathVariable String uuid) {
        logger.info("uuid: " + uuid);
        Book book = bookService.getBookByUuid(uuid);
        return Utils.getResponseEntity(book);
    }

    @PreAuthorize("hasAuthority('ROLE_NORMAL')")
    @ApiOperation(value = "用書名找書")
    @GetMapping(value = "/v1/book/find")
    public ResponseEntity<?> getBookByName(@RequestParam String name) {
        logger.info("name: " + name);
        Book book = bookService.getBookByName(name);
        return Utils.getResponseEntity(book);
    }

    @PreAuthorize("hasAuthority('ROLE_NORMAL')")
    @ApiOperation(value = "用作者跟書名找書")
    @GetMapping(value = "/v1/book/finds")
    public ResponseEntity<?> findByAuthorAndName(@RequestParam String author, @RequestParam String name) {
        logger.info("author: " + author);
        logger.info("name: " + name);
        Book book = bookService.getBookByAuthorAndName(author, name);
        return Utils.getResponseEntity(book);
    }

    @PreAuthorize("hasAuthority('ROLE_NORMAL')")
    @ApiOperation(value = "用作者找書")
    @GetMapping(value = "/v1/book/find_author")
    public ResponseEntity<?> getBookByAuthor(@RequestParam String author) {
        logger.info("author: " + author);
        List<Book> book = bookService.getBookByAuthor(author);
        if (book.isEmpty()){
            ErrorResponse errorResponse = new ErrorResponse(BAD_REQUEST);
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }



}