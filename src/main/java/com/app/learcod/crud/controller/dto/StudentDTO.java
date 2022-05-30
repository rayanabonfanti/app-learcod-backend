package com.app.learcod.crud.controller.dto;

import com.app.learcod.crud.model.Student;
import com.app.learcod.crud.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentDTO {

    @JsonProperty
    private Long id;
    @JsonProperty
    private Long registration;
    @JsonProperty
    private User user;

    public StudentDTO(Long registration, User user) {
        this.registration = registration;
        this.user = user;
    }

    public StudentDTO(Long registration) {
        this.registration = registration;
    }

    public StudentDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegistration() {
        return registration;
    }

    public void setRegistration(Long registration) {
        this.registration = registration;
    }

    //public User getUser() { return user; }

    //public void setUser(User user) { this.user = user; }

    public Student toConverterStudentDTO() {
        Student student = new Student();
        student.setRegistration(this.registration);
        return student;
    }

}
