package com.andrzejpe.spring.web;

import com.andrzejpe.spring.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = {"/", "/users"})
public class Users {

    @RequestMapping(method = RequestMethod.GET)
    public String users(Model model) {

        User a = new User();
        a.setName("Andrzej");
        a.setAge("33");
        User b = new User();
        b.setName("Beatka");
        b.setAge("32");
        List<User> users = new ArrayList<>();
        users.add(a);
        users.add(b);
        model.addAttribute("users", users);
        return "users";
    }
}
