package com.example.ELibrary.Repo;

import com.example.ELibrary.Model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface IssueRepo extends JpaRepository<Issue, Integer> {

    //void deleteBookByStIdAndBookName(String stId, String bookName);
    <T>Optional<T> findByStIdAndBookName(String stId, String bookName);
    List<Issue> findBookByStIdAndBookName(String stId, String bookName);

    Issue getIssuedBookByBookName(String bookName);

    //void setReturnDate(Date returnDate);

}
