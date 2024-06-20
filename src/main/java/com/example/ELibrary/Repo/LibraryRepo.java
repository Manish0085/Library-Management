package com.example.ELibrary.Repo;


import com.example.ELibrary.Model.Library1;
import com.example.ELibrary.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryRepo extends JpaRepository<Library1, Integer> {


    Library1 deleteStudentByStId(String stId);


    Library1 getStudentByStId(String stId);
    List<Library1> findStudentByStId(String stId);

    boolean existsByStId(String stId);

    void deleteByStId(String stId);

    <T> Optional<T> findByStId(String stId);

}

