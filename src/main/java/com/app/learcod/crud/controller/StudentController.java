package com.app.learcod.crud.controller;

import com.app.learcod.crud.model.Student;
import com.app.learcod.crud.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {

    @RequestMapping("/student")
    @ResponseBody
    public List<Student> list(){
        User user = new User("Alice Almeida","rayanaribeiro@ifba.edu.br");
        Student student = new Student(2017125013L, user);
        return Arrays.asList(student,student,student);
    }
}
