package com.example.book.service;

import com.example.book.model.Book;
import com.example.book.model.BookRequest;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks();
    boolean addBook(BookRequest book);
    boolean deleteBook(int bookid);
    boolean deleteBookByUuid(String uuid);
    boolean editBook(Book book);
    boolean editBookByUuid(Book book);
    Book getBook(int bookid);
    Book getBookByUuid(String uuid);
    Book getBookByName(String name);
    Book getBookByAuthorAndName(String author, String name);
    List<Book> getBookByAuthor(String author);
}
