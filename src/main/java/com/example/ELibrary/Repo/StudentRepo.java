package com.example.ELibrary.Repo;

import com.example.ELibrary.Model.ContactDetails;
import com.example.ELibrary.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    //Student deleteStudentByStId(String stId);

    List<Student> findStudentByStId(String stId);


    Student getStudentByStId(String stId);
}


