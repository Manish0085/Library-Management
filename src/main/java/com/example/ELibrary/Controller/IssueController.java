package com.example.ELibrary.Controller;

import com.example.ELibrary.Model.Issue;
import com.example.ELibrary.Model.IssueOut;
import com.example.ELibrary.Service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/issue")
public class IssueController {

    @Autowired
    IssueService issueService;
    @PostMapping("/add/{stId}/{bookName}")
    public String issueBook(@PathVariable String stId, @PathVariable String bookName){
        return issueService.issueBook(stId, bookName);
    }

//    @PostMapping("/{stId}/{bookName}")
//    public String returnBookByStIdAndBookName(@PathVariable String stId, @PathVariable String bookName){
//        return issueService.returnBookByStIdAndBookName(stId, bookName);
//    }
    @DeleteMapping("/return/{stId}/{bookName}")
    public String deleteBookByStIdAndBookName(@PathVariable String stId, @PathVariable String bookName){
        return issueService.deleteBookByStIdAndBookName(stId, bookName);
        //String s = returnBookByStIdAndBookName(stId, bookName);
    }

    @GetMapping("/book/{bookName}")
    public Issue getIssuedBookByBookName(@PathVariable String bookName){
        return issueService.getIssuedBookByBookName(bookName);
    }

    @GetMapping("/allBook")
    public List<Issue> getAllIssuedBook(){
        return issueService.getAllIssuedBook();
    }

}
