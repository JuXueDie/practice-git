package com.example.book.service.impl;

import com.example.book.model.Book;
import com.example.book.repository.BookRepository;
import com.example.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public boolean addBook(Book book) {
        bookRepository.save(book);
        return true;
    }

    @Override
    public boolean deleteBook(int bookid) {
        bookRepository.deleteById(bookid);
        return true;
    }

    @Override
    public boolean editBook(Book book) {
        int bookid = book.getBookid();
        Optional<Book> optionalBook = bookRepository.findById(bookid);
        if (optionalBook.isPresent()) {
            bookRepository.save(book);
            return true;
        }
        return false;
    }



    @Override
    public Book getBook(int bookid) {
        Book book = null;
        Optional<Book> optionalBook = bookRepository.findById(bookid);
        if (optionalBook.isPresent()) {
            book = optionalBook.get();
        }
        return book;
    }

    @Override
    public Book getBookByName(String name) {
        Book book = null;
        Optional<Book> optionalBook = Optional.ofNullable(bookRepository.findByName(name));
        if (optionalBook.isPresent()) {
            book = optionalBook.get();
        }
        return book;
    }

    @Override
    public Book getBookByAuthorAndName(String author, String name) {
        Book book = null;
        Optional<Book> optionalBook = Optional.ofNullable(bookRepository.findByAuthorAndName(author, name));
        if (optionalBook.isPresent()) {
            book = optionalBook.get();
        }
        return book;
    }
}

