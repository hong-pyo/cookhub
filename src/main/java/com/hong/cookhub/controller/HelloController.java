package com.hong.cookhub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
public class HelloController {

    @RequestMapping("/")
    public String test(Model model) {
        model.addAttribute("test", String.valueOf(new Date()));
        return "index";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String git() {
        return "good";
    }
}
