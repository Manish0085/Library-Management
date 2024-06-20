package com.example.ELibrary.Controller;


import com.example.ELibrary.Model.Book;
import com.example.ELibrary.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.io.StringReader;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody Book book){
        return bookService.addBook(book);

    }
    @GetMapping("/all-book")
    public List<Book> getAllBook(){
        return bookService.getAllBook();
    }


    @GetMapping("/{bookName}/{bookAuthor}")
    public Book  getBookByNameAndAuthor(@PathVariable String bookName, @PathVariable String bookAuthor){
        return bookService.getBookByBookNameAndBookAuthor(bookName, bookAuthor);
    }
//



    @DeleteMapping("/delete/{bookName}")
   public Book deleteBookByName(@PathVariable String bookName){
        return bookService.deleteBookByBookName(bookName);
    }
}



//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//
//
//@Controller
//@RequestMapping("/book")
//public class BookController {
//
//    @Autowired
//    private BookService bookService;
//
//    @GetMapping("/all")
//    @PreAuthorize("hasRole('ADMIN')")
//    public String getAllBooks(Model model) {
//        List<Book> books = bookService.getAllBook();
//        model.addAttribute("books", books);
//        return "books";
//    }
//
//    @PostMapping("/add")
//    @PreAuthorize("hasRole('ADMIN')")
//    public String addBook(@ModelAttribute Book book) {
//        bookService.addBook(book);
//        return "redirect:/book/all";
//    }
//}
