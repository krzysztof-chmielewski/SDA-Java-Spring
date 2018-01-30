package com.kchmielewski.sda.java.spring01xml.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    @RequestMapping
    public String hello(@RequestParam(defaultValue = "World") String who, Model model) {
        model.addAttribute("message", who);

        return "hello";
    }
}
