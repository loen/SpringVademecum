package com.andrzejpe.spring.web;

import com.andrzejpe.spring.data.Spittle;
import com.andrzejpe.spring.data.SpittleRepository;
import com.andrzejpe.spring.data.User;
import com.andrzejpe.spring.data.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jedrek on 2015-10-17.
 */

@Controller
@RequestMapping("/spittles")
public class SpittlesController {

    private SpittleRepository spittleRepository;

    @Autowired
    SpittlesController(SpittleRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(@RequestParam(value = "max", defaultValue = "200")long max,
                           @RequestParam(value = "count", defaultValue = "20")int count,
                           Model model) {
        List<Spittle> spittles = spittleRepository.findSpittles(max, count);
        model.addAttribute("spittleList",spittles);
        return "spittles";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "registrationForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@Valid UserRegistration userRegistration, Errors errors) {
        spittleRepository.save(userRegistration);
        if(errors.hasErrors()) {
            return "redirect:/spittles/register";
        }
        return "redirect:/spittles/" + userRegistration.getUsername();
    }

    @RequestMapping(value ="/{userName}", method = RequestMethod.GET)
    public String showUser(@PathVariable("userName")String userName, Model model){
        User user = spittleRepository.findUserByName(userName);
        model.addAttribute("user", user);
        return "user";
    }
}
