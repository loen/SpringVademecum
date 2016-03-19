package com.andrzejpe.spring.web;

import com.andrzejpe.spring.dao.ErrorMessage;
import com.andrzejpe.spring.dao.User;
import com.andrzejpe.spring.exception.UserNotAllowedException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST, produces = "application/json",consumes = "application/json")
    public @ResponseBody User createUser(@RequestBody User user){
        if(user.getName().equals("Jaroslaw")) {
            throw new UserNotAllowedException(user.getName());
        }
        return user;
    }

    @ExceptionHandler(UserNotAllowedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ErrorMessage userNotAllowed(UserNotAllowedException ex) {
        System.out.println("I'm in exception handler");
        return new ErrorMessage("Tego pana nie obslugujemy", ex.getName());
    }
}
