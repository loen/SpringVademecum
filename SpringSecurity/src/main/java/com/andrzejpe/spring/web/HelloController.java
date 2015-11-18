package com.andrzejpe.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = {"/", "/hello"})
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String helloPage() {

        return "hello";
    }
}
