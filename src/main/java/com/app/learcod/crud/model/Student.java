package com.app.learcod.crud.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long registration;
    @ManyToOne
    private User user;

    public Student(Long registration, User user) {
        this.registration = registration;
        this.user = user;
    }

    public Student(Long registration) {
        this.registration = registration;
    }

    public Student() {
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

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}
