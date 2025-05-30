package com.example.ss15.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Bt4Controller {
    @GetMapping("/bt4")
    public String home() {
        return "home";
    }
    @GetMapping("/bt4/about")
    public String about() {
        return "about";
    }
    @GetMapping("/bt4/contact")
    public String contact() {
        return "contact";
    }
}
