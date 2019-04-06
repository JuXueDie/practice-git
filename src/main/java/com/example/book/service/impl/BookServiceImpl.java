package com.example.book.service.impl;

import com.example.book.model.Book;
import com.example.book.model.BookRequest;
import com.example.book.repository.BookRepository;
import com.example.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public boolean addBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setUuid(UUID.randomUUID().toString());
        book.setAuthor(bookRequest.getAuthor());
        book.setName(bookRequest.getName());
        bookRepository.save(book);
        return true;
    }

    @Override
    public boolean deleteBook(int bookid) {
        bookRepository.deleteById(bookid);
        return true;
    }

    @Override
    public boolean deleteBookByUuid(String uuid) {
//        bookRepository.deleteByUuid(uuid);
//        return true;
        Book bookByUuid = getBookByUuid(uuid);
        if (bookByUuid != null) {
            bookRepository.deleteById(bookByUuid.getBookid());
            return true;
        }
        return false;
    }

    @Override
    public boolean editBook(BookRequest bookRequest, int bookid) {
        Book book = new Book();
        Optional<Book> optionalBook = bookRepository.findById(bookid);
        if (optionalBook.isPresent()) {
            book.setAuthor(bookRequest.getAuthor());
            book.setName(bookRequest.getName());
            book.setBookid(bookid);
            book.setUuid(optionalBook.get().getUuid());
            bookRepository.save(book);
            return true;
        }
        return false;
    }

    @Override
    public boolean editBookByUuid(BookRequest bookRequest, String uuid) {
        Book oldBook = getBookByUuid(uuid);
        if (oldBook != null) {
            oldBook.setAuthor(bookRequest.getAuthor());
            oldBook.setName(bookRequest.getName());
            oldBook.setUuid(uuid);
            bookRepository.save(oldBook);
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
    public Book getBookByUuid(String uuid) {
        return bookRepository.findByUuid(uuid);
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

    @Override
    public List<Book> getBookByAuthor(String author) {
        List book = new ArrayList();
        book = bookRepository.findByAuthor(author);
        return book;
    }
}

