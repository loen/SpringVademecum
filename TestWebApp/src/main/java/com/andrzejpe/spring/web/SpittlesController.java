package com.andrzejpe.spring.web;

import com.andrzejpe.spring.data.Spittle;
import com.andrzejpe.spring.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
}
