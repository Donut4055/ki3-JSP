package com.example.ss15.controller;


import com.example.ss15.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@ModelAttribute("user") @Valid User user,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        model.addAttribute("user", user);
        return "result";
    }
}

