package com.andrzejpe.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jedrek on 2015-10-21.
 */
@Controller
public class SpittleController {

    @RequestMapping(value = "/spittle", method = RequestMethod.GET)
    public String tes() {
        return "spittle";
    }

    @RequestMapping(value = "/spittle/{id}", method = RequestMethod.GET)
    public String getSingleSpittle(@PathVariable int id) {
        System.out.println("!!!!!!!!!!!!!!!!! = " + id);
        return "spittle";
    }
}
