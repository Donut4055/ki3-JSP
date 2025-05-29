package com.example.ss13.controller;

import com.example.ss13.model.CategoryForm;
import com.example.ss13.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.Locale;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showForm(Model model, Locale locale) throws SQLException {
        model.addAttribute("categoryForm", new CategoryForm());
        model.addAttribute("categories", categoryService.getCategoriesByLocale(locale));
        return "category";
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute CategoryForm form, Model model, Locale locale) throws SQLException {
        categoryService.addCategory(form);
        return "redirect:/category?lang=" + locale.getLanguage();
    }
}

