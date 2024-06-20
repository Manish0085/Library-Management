package com.example.ELibrary.Service;

import ch.qos.logback.core.rolling.helper.ArchiveRemover;
import com.example.ELibrary.Model.ContactDetails;
import com.example.ELibrary.Model.Student;
import com.example.ELibrary.Repo.ContactDetailsRepo;
import com.example.ELibrary.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    ContactDetailsRepo contactDetailsRepo;

    public ResponseEntity<List<Student>> getAllRegisteredStudent() {
        try {
            return new ResponseEntity<>(studentRepo.findAll(), HttpStatus.OK);

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }



    public ResponseEntity<String> saveStudentAndContactDetails(Student student, ContactDetails contactDetails) {
        try {
            studentRepo.save(student);
            contactDetailsRepo.save(contactDetails);
            return new ResponseEntity<>("Student Data has been stored successfully", HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Unsuccessful", HttpStatus.BAD_REQUEST);


    }


    public ResponseEntity<Student> getStudentByStId(String stId) {
        try {
            return new ResponseEntity<>(studentRepo.getStudentByStId(stId), HttpStatus.OK);

        }
        catch (Exception e){
            System.out.println("Data has not found");
        }
        return new ResponseEntity<>(studentRepo.getStudentByStId(stId), HttpStatus.BAD_REQUEST);
    }
}
