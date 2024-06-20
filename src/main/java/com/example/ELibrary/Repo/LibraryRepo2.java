package com.example.ELibrary.Repo;

import com.example.ELibrary.Model.Library2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepo2 extends JpaRepository<Library2, Integer> {
    Library2 findStudentByStId(String stId);


}
