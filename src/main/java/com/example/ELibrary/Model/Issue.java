package com.example.ELibrary.Model;


import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;


@Data
@Entity
@Table(name = "issuedata")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String issuedBy;
    String stId;
    String stCourse;
    String branch;
    String semester;
    String bookName;
    String isbn;
    String email;
    String phone;
    Date receivedDate;

    Time takingTime;
    Date returnDate;
    double perDayDelayCharge;
}
