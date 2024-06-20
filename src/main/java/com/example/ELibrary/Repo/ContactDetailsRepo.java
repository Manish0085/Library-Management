package com.example.ELibrary.Repo;

import com.example.ELibrary.Model.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactDetailsRepo extends JpaRepository<ContactDetails, Integer> {


    List<ContactDetails> findStudentByStId(String stId);

    ContactDetails getContactDetailsByStId(String stId);

    List<ContactDetails> findContactDetailByStId(String stId);
}
