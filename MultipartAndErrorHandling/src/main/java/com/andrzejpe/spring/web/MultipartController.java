package com.andrzejpe.spring.web;

import com.andrzejpe.spring.dao.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by jedrek on 2015-10-31.
 */
@Controller
@RequestMapping(value = "/multipart")
public class MultipartController {

    @RequestMapping(method = RequestMethod.GET)
    public String getMultipartUser(Model model){
        model.addAttribute(new User());
        return "/multipart";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postMultipartUser(@Valid User user, Model model, Errors errors){
        if(errors.hasErrors()) {
            return "/multipart";
        }
        model.addAttribute(user);
        return "redirect:/multipart/user/" + user.getName();
    }

    @RequestMapping("/user/{name}")
    public String user(@PathVariable("name") String name, Model model) {
        model.addAttribute(name);
        return "user";
    }
}
