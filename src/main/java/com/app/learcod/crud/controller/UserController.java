package com.app.learcod.crud.controller;

import com.app.learcod.crud.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/user")
    @ResponseBody
    public List<User> list(){
        User user = new User("Billie Eilish","billieeilish@havard.edu");
        return Arrays.asList(user,user,user);
    }
}
