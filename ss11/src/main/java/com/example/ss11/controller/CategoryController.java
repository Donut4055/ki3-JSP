package com.example.ss11.controller;

import com.example.ss11.model.Category;
import com.example.ss11.repository.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryDAO categoryDAO;

    @GetMapping
    public String list(Model model) {
        List<Category> categories = categoryDAO.findAll();
        model.addAttribute("categories", categories);
        return "category-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "category-form";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("category") @Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category-form";
        }
        categoryDAO.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Category category = categoryDAO.findById(id);
        model.addAttribute("category", category);
        return "category-form";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, @ModelAttribute("category") @Valid Category category, BindingResult result) {
        category.setId(id);
        if (result.hasErrors()) {
            return "category-form";
        }
        categoryDAO.update(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        categoryDAO.delete(id);
        return "redirect:/categories";
    }
}

