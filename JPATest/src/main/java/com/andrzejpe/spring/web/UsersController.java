package com.andrzejpe.spring.web;


import com.andrzejpe.spring.dao.model.User;
import com.andrzejpe.spring.forms.UserForm;
import com.andrzejpe.spring.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * Created by jedrek on 2016-01-06.
 */
@Controller
@RequestMapping(value = {"/users", "/"})
public class UsersController {

    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        Collection<User> users = usersService.getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createUser(UserForm userForm, Model model) {
        usersService.saveUser(userForm.getFirstName(), userForm.getLastName());
        Collection<User> users = usersService.getUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
