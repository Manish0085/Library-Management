package com.example.ELibrary.Service;


import com.example.ELibrary.Model.Book;
import com.example.ELibrary.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo ;



    public List<Book> getAllBook(){
        return bookRepo.findAll();
    }


    public String addBook(Book book){
        bookRepo.save(book);
        return "Book has been added successfully...";
    }
    public Book getBookByBookNameAndBookAuthor(String bookName, String bookAuthor) {
        return bookRepo.getBookByBookNameAndBookAuthor(bookName, bookAuthor);
    }

    public Book deleteBookByBookName(String bookName) {

        return bookRepo.deleteBookByBookName(bookName);
    }
}
