package com.example.ELibrary.Service;

import com.example.ELibrary.Model.ContactDetails;
import com.example.ELibrary.Model.Library1;
import com.example.ELibrary.Model.Library2;
import com.example.ELibrary.Model.Student;
import com.example.ELibrary.Repo.ContactDetailsRepo;
import com.example.ELibrary.Repo.LibraryRepo;
import com.example.ELibrary.Repo.LibraryRepo2;
import com.example.ELibrary.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class LibraryService {


    @Autowired
    LibraryRepo libraryRepo;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    LibraryRepo2 libraryRepo2;

    @Autowired
    ContactDetailsRepo contactDetailsRepo;

    public String InEntry(String stId) {
        List<Student> data = studentRepo.findStudentByStId(stId);
//        List<ContactDetails> phone = contactDetailsRepo.findStudentByStId(stId);
//        Library1 lib = new Library1();
        for (Student student : data) {
            Library1 lib = new Library1();
            lib.setStName(student.getStName());
            lib.setStId(student.getStId());
            lib.setCourseName(student.getCourseName());
            lib.setBranch(student.getBranch());
            lib.setPurpose("Study");
            lib.setDate(Date.valueOf(LocalDate.now()));
            lib.setInTime(Time.valueOf(LocalTime.now()));

            libraryRepo.save(lib);
        }

//        for (ContactDetails contact : phone) {
//            lib.setPhone(contact.getPhone());
//            lib.setEmail(contact.getEmail());
//
//        }
            return "You can study in library";
    }




    public String deleteLibrary1(String stId) {


        Library1 entity = (Library1) libraryRepo.findByStId(stId).orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        // Transfer the data to Library2
        Library2 lib = new Library2();
        lib.setStName(entity.getStName());
        lib.setStId(entity.getStId());
        lib.setCourseName(entity.getCourseName());
        lib.setBranch(entity.getBranch());
        lib.setPurpose("Study");
        lib.setDate(Date.valueOf(LocalDate.now()));
        lib.setInTime(entity.getInTime());
        lib.setOutTime(Time.valueOf(LocalTime.now()));

        libraryRepo2.save(lib);

        libraryRepo.delete(entity);

        return "Book has been returned successfully";

    }

    public List<Library1> getAllLibraries() {
        return libraryRepo.findAll();
    }

    public Library1 getStudentByStId(String stId) {
        return libraryRepo.getStudentByStId(stId);
    }


}
