package com.plvtarch.cloudComputing.controller;

import com.plvtarch.cloudComputing.service.ComputingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComputingController
{
    @Autowired
    private ComputingService computingService;

    @RequestMapping(value = "/sum", method = RequestMethod.GET)
    public @ResponseBody Integer sum(@RequestParam("integerList") List<Integer> integerList)
    {
        return computingService.sum(integerList);
    }

    @RequestMapping(value = "/grouping", method = RequestMethod.GET)
    public @ResponseBody String grouping(@RequestParam("stringList") List<String> stringList)
    {
        return computingService.grouping(stringList);
    }
}

