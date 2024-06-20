package com.example.ELibrary.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Data
@Entity
@Table(name = "issueout")
public class IssueOut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String issuedBy;
    String stId;
    String stCourse;
    String branch;
    String semester;

    String bookName;
    String email;
    String phone;

    Date receivedDate;

    Time takingTime;
    Date returnDate;
    Date toDate;
    Double delayCharge;
}

