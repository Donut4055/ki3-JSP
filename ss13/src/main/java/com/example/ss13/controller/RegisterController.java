package com.example.ss13.controller;


import com.example.ss13.model.UserRegister;
import com.example.ss13.repository.UserDAO;
import com.example.ss13.validator.PasswordMatchValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.Locale;

@Controller
public class RegisterController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordMatchValidator passwordMatchValidator;

    @Autowired
    private MessageSource messageSource;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(passwordMatchValidator);
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("userRegisterDto", new UserRegister());
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@ModelAttribute("userRegisterDto") @Valid UserRegister dto,
                             BindingResult result,
                             Model model,
                             Locale locale) {
        try {
            if (userDAO.existsByUsername(dto.getUsername())) {
                result.rejectValue("username", "register.username.exists");
            }
            if (userDAO.existsByEmail(dto.getEmail())) {
                result.rejectValue("email", "register.email.exists");
            }
        } catch (SQLException e) {
            result.reject("register.error", e.getMessage());
        }

        if (result.hasErrors()) {
            return "register";
        }

        try {
            userDAO.insert(dto);
        } catch (SQLException e) {
            result.reject("register.error", e.getMessage());
            return "register";
        }

        model.addAttribute("success", messageSource.getMessage("register.success", null, locale));
        return "register";
    }
}

