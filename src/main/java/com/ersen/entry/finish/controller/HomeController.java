package com.ersen.entry.finish.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/home")
public class HomeController {

    @GetMapping("/time")
    public String test() {
        return new Date().toString();
    }
}
