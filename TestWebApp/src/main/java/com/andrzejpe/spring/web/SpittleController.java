package com.andrzejpe.spring.web;

import com.andrzejpe.spring.data.Spittle;
import com.andrzejpe.spring.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jedrek on 2015-10-21.
 */
@Controller
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(value = "/spittle", method = RequestMethod.GET)
    public String tes() {
        return "spittle";
    }

    @RequestMapping(value = "/spittle/{id}", method = RequestMethod.GET)
    public String getSingleSpittle(@PathVariable int id, Model model) {
        Spittle spittle = spittleRepository.getSpittle(id);
        model.addAttribute("spittle", spittle);
        return "spittle";
    }
}
