package com.example.ss11.controller;

import javax.validation.Valid;
import com.example.ss11.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/bt1")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/bt1")
    public String submitForm(@Valid @ModelAttribute("user") User user,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            return "userForm";
        }
        model.addAttribute("message", "Thông tin người dùng đã được gửi thành công!");
        return "userForm";
    }
}

