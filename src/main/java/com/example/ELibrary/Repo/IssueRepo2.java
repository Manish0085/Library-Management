package com.example.ELibrary.Repo;

import com.example.ELibrary.Model.IssueOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepo2 extends JpaRepository<IssueOut, Integer> {
}
