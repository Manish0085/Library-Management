package com.example.ELibrary.Service;

import com.example.ELibrary.Model.ContactDetails;
import com.example.ELibrary.Repo.ContactDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactDetailService {


    @Autowired
    ContactDetailsRepo contactDetailsRepo;
    public ResponseEntity<ContactDetails> getContactDetailsByStId(String stId) {
        try {
            return new ResponseEntity<>(contactDetailsRepo.getContactDetailsByStId(stId), HttpStatus.OK);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ContactDetails(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<ContactDetails>> getAllStudentsContactDetails() {
        try {
            return new ResponseEntity<>(contactDetailsRepo.findAll(), HttpStatus.OK);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_GATEWAY);

    }
}
