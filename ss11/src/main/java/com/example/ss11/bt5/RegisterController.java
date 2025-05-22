package com.example.ss11.bt5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Controller
public class RegisterController {

    @Autowired
    private javax.validation.Validator validator;

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @PostMapping("/register")
    public String submitForm(
            @ModelAttribute("registerForm") RegisterForm form,
            BindingResult result,
            Model model
    ) {
        Class<?> group = "admin".equals(form.getRole()) ? AdminGroup.class : UserGroup.class;

        Set<ConstraintViolation<RegisterForm>> violations = validator.validate(form, group);
        for (ConstraintViolation<RegisterForm> violation : violations) {
            String field = violation.getPropertyPath().toString();
            result.rejectValue(field, "", violation.getMessage());
        }

        if (result.hasErrors()) {
            return "register";
        }
        return "redirect:/success";
    }
}

