package com.example.ELibrary.Model;


import javax.persistence.Entity;

public class StudentRegistrationRequest {

    private Student student;
    private ContactDetails contactDetails;

    // Getters and setters
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }
}
