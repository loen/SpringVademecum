package com.andrzejpe.spring.web;

import com.andrzejpe.spring.data.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by jedrek on 2015-10-24.
 */
@Controller
@RequestMapping(value = {"/", "/hello"})
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return "home";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegister(Model model) {
        model.addAttribute(new User());
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String getRegister(@Valid User user, Errors errors) {
        if(errors.hasErrors()) {
            return "registration";
        }
        System.out.println("User: " + user);
        return "home";
    }
}
