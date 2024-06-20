package com.example.ELibrary.Repo;

import com.example.ELibrary.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    Book getBookByBookNameAndBookAuthor(String bookName, String bookAuthor);

    Book deleteBookByBookName(String bookName);

    List<Book> findBookByBookName(String bookName);
}
