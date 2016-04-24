package com.andrzejpe.spring.model;


import com.andrzejpe.spring.model.persistent.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/user")
public class UserRest {

    @Autowired
    UserRepository userRepository;
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody User getUser() {
        User u = userRepository.findByName("Andrzej");
        return u;
    }
}
