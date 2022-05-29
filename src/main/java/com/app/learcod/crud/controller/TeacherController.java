package com.app.learcod.crud.controller;

import com.app.learcod.crud.model.Teacher;
import com.app.learcod.crud.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class TeacherController {

    @RequestMapping("/teacher")
    @ResponseBody
    public List<Teacher> list(){
        User user = new User("Rayana Ribeiro","rayanaribeiro@ufsb.edu.br");
        Teacher teacher = new Teacher(2017125013L, user);
        return Arrays.asList(teacher,teacher,teacher);
    }
}
