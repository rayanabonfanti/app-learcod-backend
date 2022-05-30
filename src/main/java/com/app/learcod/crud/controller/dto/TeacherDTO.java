package com.app.learcod.crud.controller.dto;

import com.app.learcod.crud.model.Student;
import com.app.learcod.crud.model.Teacher;
import com.app.learcod.crud.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TeacherDTO {
    @JsonProperty
    private Long id;
    @JsonProperty
    private Long siape;
    @JsonProperty
    private User user;

    public TeacherDTO(Long siape, User user) {
        this.siape = siape;
        this.user = user;
    }

    public TeacherDTO(Long siape) {
        this.siape = siape;
    }

    public TeacherDTO() {
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

    public Teacher toConverterTeacherDTO() {
        Teacher teacher = new Teacher();
        teacher.setSiape(this.siape);
        return teacher;
    }

}
