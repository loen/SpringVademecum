package com.andrzejpe.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/secure")
public class SecureController {

    @RequestMapping(method = RequestMethod.GET)
    public String secure() {
        return "secureLayout";
    }
}
