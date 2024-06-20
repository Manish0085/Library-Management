package com.example.ELibrary.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "entrydata")
public class Library1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String stName;
    String stId;
    String courseName;
    String branch;
    String purpose;
    String phone;
    Date date;
    Time inTime;
    String email;

    @OneToMany
    private List<Student> registeredStudents;
}

