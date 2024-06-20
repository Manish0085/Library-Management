package com.example.ELibrary.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "contactdetails")
public class ContactDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String stId;
    String email;
    String phone;
    String presentAdd;
    String presentCity;
    String presentPinCode;
    String presentDistrict;
    String presentCountry;
    String presentState;
}
