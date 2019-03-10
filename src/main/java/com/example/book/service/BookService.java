package com.example.book.service;

import com.example.book.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    boolean addBook(Book book);
    boolean deleteBook(int bookid);
    boolean editBook(Book book);
}
