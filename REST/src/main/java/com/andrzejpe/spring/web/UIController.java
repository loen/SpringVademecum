package com.andrzejpe.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jedrek on 2016-03-14.
 */

@Controller
@RequestMapping("/")
public class UIController {

    @RequestMapping(method = RequestMethod.GET)
    public String getMainPage() {

        return "main";
    }

}
