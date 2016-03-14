package com.andrzejpe.spring.web;

import com.andrzejpe.spring.dao.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class Users {

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<User> getAllUsers() {
        List l = new ArrayList<>();
        l.add(new User("Beatka", 32));
        l.add(new User("Jedrek", 33));
        l.add(new User("Mateusz", 1));
        return l;
    }
}
