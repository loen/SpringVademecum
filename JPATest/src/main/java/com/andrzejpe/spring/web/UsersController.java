package com.andrzejpe.spring.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jedrek on 2016-01-06.
 */
@Controller
@RequestMapping(value = {"/users", "/"})
public class UsersController {

    @RequestMapping(method = RequestMethod.GET)
    public String getAllUsers() {
        return "users";
    }
}
