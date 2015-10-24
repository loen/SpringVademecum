package com.andrzejpe.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jedrek on 2015-10-24.
 */
@Controller
@RequestMapping(value = "/")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return "home";
    }
}
