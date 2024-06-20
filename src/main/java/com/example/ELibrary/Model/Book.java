package com.example.ELibrary.Model;


import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;


@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String bookName;
    String bookSubject;
    String bookAuthor;
    String isbn;
    double price;
    String bookPublisher;
    String bookEdition;
}
