package com.andrzejpe.spring.web;

import com.andrzejpe.spring.service.EntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
@RequestMapping({"/","cacheTest"})
public class CacheController {

    private EntriesService entriesService;

    @Autowired
    public CacheController(EntriesService entriesService) {
        this.entriesService = entriesService;
    }

    @RequestMapping(value = "/{entriesCount}",method = RequestMethod.GET)
    public String getCachedEntries(@PathVariable("entriesCount") Integer count, Model model) {
        LocalTime before = LocalTime.now();
        List<String> entries = entriesService.getEntries(count);
        LocalTime after = LocalTime.now();
        long between = ChronoUnit.MILLIS.between(before, after);
        model.addAttribute("entries", entries);
        model.addAttribute("duration", between);
        return "entries";
    }

    @RequestMapping(value = "/reset/{entriesCount}", method = RequestMethod.GET)
    public String resetEntries(@PathVariable("entriesCount") Integer count) {
        entriesService.removeEntries(count);
        return "reset";
    }


}
