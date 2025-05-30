package com.example.ss15.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Bt1Controller {
    @GetMapping("/bt1")
    public String hello(Model model) {
        model.addAttribute("message", "Hello, Thymeleaf!");
        return "bt1";
    }
}
