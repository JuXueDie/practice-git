package com.example.book;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Integer book111id;
    private String name;
    private String author;
}