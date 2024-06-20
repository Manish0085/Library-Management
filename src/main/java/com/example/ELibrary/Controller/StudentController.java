package com.example.ELibrary.Controller;

import com.example.ELibrary.Model.ContactDetails;
import com.example.ELibrary.Model.Student;
import com.example.ELibrary.Model.StudentRegistrationRequest;
import com.example.ELibrary.Service.ContactDetailService;
import com.example.ELibrary.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    ContactDetailService contactDetailService;



    @PostMapping("/registration")
    public ResponseEntity<String> saveStudentAndContactDetails(@RequestBody StudentRegistrationRequest request) {
        return studentService.saveStudentAndContactDetails(request.getStudent(), request.getContactDetails());
    }




//    @GetMapping("/get/{stId}")
//    public ResponseEntity<Student> getStudentByStId(@PathVariable String stId) {
//        return studentService.getStudentByStId(stId);
//    }
//
//    @GetMapping("/contact/{stId}")
//    public ResponseEntity<ContactDetails> getContactDetailsByStId(@PathVariable String stId){
//        return contactDetailService.getContactDetailsByStId(stId);
//    }
//
//    @GetMapping("/contacts")
//    public ResponseEntity<List<ContactDetails>> getAllStudentsContactDetails(){
//        return contactDetailService.getAllStudentsContactDetails();
//    }


}
