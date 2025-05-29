package com.example.ss13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Bt3 {

    @GetMapping("/bt3")
    public String home() {
        return "bt3";
    }
}

