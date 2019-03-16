package com.example.book.repository;

import com.example.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, Integer> {
//    @Query("SELECT n FROM Book n WHERE n.uuid= ?1")
    Book findByAuthorAndName(String author, String name);
    Book findByName(String name);
    /*
    // Prevents GET /books/:id
    @Override
    Book findOne(Integer id);

    // Prevents GET /books
    @Override
    Page<Book> findAll(Pageable pageable);

    // Prevents POST /books and PATCH /books/:id
    @Override
    Book save(Book s);

    // Prevents DELETE /books/:id
    @Override
    @RestResource(exported = false)
    void delete(Book t);
    */
}