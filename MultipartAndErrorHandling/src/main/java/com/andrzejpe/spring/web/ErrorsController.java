package com.andrzejpe.spring.web;

import com.andrzejpe.spring.exceptions.NotKnownException;
import com.andrzejpe.spring.exceptions.SomeException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jedrek on 2015-10-31.
 */
@Controller
public class ErrorsController {

    @RequestMapping( value = "/errors",method = RequestMethod.GET)
    public String getResp(){
        throw new SomeException();
    }

    @RequestMapping(value = "/notknow", method = RequestMethod.GET)
    public String notKnownEx(){
        throw new NotKnownException("message");

    }


    @ExceptionHandler(NotKnownException.class)
    public String handleNotKnownException(HttpServletRequest req, Exception exception, Model model) {

        model.addAttribute("message", exception.getMessage());
        model.addAttribute("name", exception.getClass().getName());
        return "expage";
    }


}
