package com.example.ELibrary.Service;


import com.example.ELibrary.Model.*;
import com.example.ELibrary.Repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Service
public class IssueService  {

    @Autowired
    IssueRepo issueRepo;

    @Autowired
    IssueRepo2 issueRepo2;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    BookRepo bookRepo;

    @Autowired
    ContactDetailsRepo contactDetailsRepo;

    public String issueBook(String stId, String bookName) {

        List<Student> data = studentRepo.findStudentByStId(stId);
        List<Book> book = bookRepo.findBookByBookName(bookName);
        List<ContactDetails> contact = contactDetailsRepo.findContactDetailByStId(stId);

        if (data.isEmpty()) {
            return "Student not found";
        }
        if (contact.isEmpty()){
            return "Sorry, But Contact Details not found";
        }

        if (book.isEmpty()) {
            return "Sorry, But Book is not available";
        }

        ContactDetails details = contact.stream()
                .filter(contact1 -> contact1.getStId().equals(stId))
                .findFirst()
                .orElse(null);

        // Assuming book names are unique and finding the first match
        Book matchingBook = book.stream()
                .filter(book1 -> book1.getBookName().equals(bookName))
                .findFirst()
                .orElse(null);

        if (matchingBook == null) {
            return "Sorry, But Book is not available";
        }
        if (details == null){
            return "Sorry, But Contact Details not found";
        }

        for (Student student : data) {
            Issue issue = new Issue();
            issue.setIssuedBy(student.getStName());
            issue.setStId(student.getStId());
            issue.setStCourse(student.getCourseName());
            issue.setBranch(student.getBranch());
            issue.setSemester(student.getSemester());
            issue.setBookName(matchingBook.getBookName());
            issue.setIsbn(matchingBook.getIsbn());
            issue.setEmail(details.getEmail());
            issue.setPhone(details.getPhone());
            issue.setReceivedDate(Date.valueOf(LocalDate.now()));
            issue.setTakingTime(Time.valueOf(LocalTime.now()));
            issue.setPerDayDelayCharge(20.0);
            issue.setReturnDate(Date.valueOf(LocalDate.now().plusDays(20)));
            issueRepo.save(issue);
        }

        return "Book has been issued successfully...";
    }




    public String deleteBookByStIdAndBookName(String stId, String bookName) {
        Issue book = (Issue) issueRepo.findByStIdAndBookName(stId, bookName).orElseThrow(() -> new EntityNotFoundException("Book not found"));


        IssueOut issue = new IssueOut();
        issue.setIssuedBy(book.getIssuedBy());
        issue.setStId(book.getStId());
        issue.setStCourse(book.getStCourse());
        issue.setBranch(book.getBranch());
        issue.setSemester(book.getSemester());
        issue.setBookName(book.getBookName());
        issue.setReceivedDate(book.getReceivedDate());
        issue.setEmail(book.getEmail());
        issue.setPhone(book.getPhone());
        issue.setReturnDate(book.getReturnDate());
        issue.setTakingTime(book.getTakingTime());
        if (book.getReturnDate().getDay() < Date.valueOf(LocalDate.now()).getDay() && book.getReturnDate().getMonth() == Date.valueOf(LocalDate.now()).getMonth() && book.getReturnDate().getYear() == Date.valueOf(LocalDate.now()).getYear()){
            double charge = (Date.valueOf(LocalDate.now()).getDay() - book.getReturnDate().getDay())*20;
            issue.setDelayCharge(charge);
        }
        else if (book.getReturnDate().getDay() <= Date.valueOf(LocalDate.now()).getDay() && book.getReturnDate().getMonth() < Date.valueOf(LocalDate.now()).getMonth() && book.getReturnDate().getYear() == Date.valueOf(LocalDate.now()).getYear()){
            double charge = (Date.valueOf(LocalDate.now()).getMonth() - book.getReturnDate().getMonth())*120;
            issue.setDelayCharge(charge);
        }
        else if (book.getReturnDate().getDay() <= Date.valueOf(LocalDate.now()).getDay() && book.getReturnDate().getMonth() <= Date.valueOf(LocalDate.now()).getMonth() && book.getReturnDate().getYear() < Date.valueOf(LocalDate.now()).getYear()){
            double charge = (Date.valueOf(LocalDate.now()).getYear() - book.getReturnDate().getYear())*500;
            issue.setDelayCharge(charge);
        }
        else {
            issue.setDelayCharge(0.00);
        }
        issue.setToDate(Date.valueOf(LocalDate.now()));

        issueRepo2.save(issue);

        issueRepo.delete(book);

        return "Book returned Successfully";
    }

    public Issue getIssuedBookByBookName(String bookName) {
        return issueRepo.getIssuedBookByBookName(bookName);
    }

    public List<Issue> getAllIssuedBook() {
        return issueRepo.findAll();
    }


//
}
