package com.example.ratingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private long bookId;
    private String isbn;
    private String title;
    private String seriesName;
    private String author;
    private Integer lexile;
    private Integer pageCount;
    private Integer minAge;
    private Integer maxAge;

}
