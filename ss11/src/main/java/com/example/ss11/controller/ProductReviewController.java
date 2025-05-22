package com.example.ss11.controller;


import com.example.ss11.model.ProductReview;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
public class ProductReviewController {

    @GetMapping("/review")
    public String showForm(Model model) {
        model.addAttribute("productReview", new ProductReview());
        return "review";
    }

    @PostMapping("/review")
    public String submitForm(
            @ModelAttribute("productReview") @Valid ProductReview productReview,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "review";
        }
        return "review-success";
    }
}

