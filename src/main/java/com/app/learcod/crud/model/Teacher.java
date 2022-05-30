package com.app.learcod.crud.model;

import javax.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long siape;
    @ManyToOne
    private User user;

    public Teacher(Long siape, User user) {
        this.siape = siape;
        this.user = user;
    }

    public Teacher(Long siape) {
        this.siape = siape;
    }

    public Teacher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSiape() {
        return siape;
    }

    public void setSiape(Long siape) {
        this.siape = siape;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

}
