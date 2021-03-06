package com.andrzejpe.spring.web;

import com.andrzejpe.spring.model.User;
import com.andrzejpe.spring.model.persistent.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path = {"/", "/users"})
public class Users {

    @Autowired
    UserRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public String users(Model model) {
        List<User> users = repository.findAll();
        model.addAttribute("users", users);
        return "users";
    }
}
