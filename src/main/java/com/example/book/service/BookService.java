package com.example.book.service;

import com.example.book.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks();
    boolean addBook(Book book);
    boolean deleteBook(int bookid);
    boolean editBook(Book book);
    Book getBook(int bookid);
    Book getBookByName(String name);
    Book getBookByAuthorAndName(String author, String name);
}
