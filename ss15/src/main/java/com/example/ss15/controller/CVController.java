package com.example.ss15.controller;

import com.example.ss15.model.CV;
import com.example.ss15.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/cvs")
public class CVController {
    @Autowired
    private CVService cvService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("cvs", cvService.findAll());
        return "cv-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("cv", new CV());
        return "cv-form";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("cv") @Valid CV cv, BindingResult result, Model model) {
        try {
            cvService.save(cv);
        } catch (RuntimeException ex) {
            result.rejectValue("email", "error.cv", ex.getMessage());
        }
        if (result.hasErrors()) {
            return "cv-form";
        }
        return "redirect:/cvs";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        CV cv = cvService.findById(id);
        if (cv == null) return "redirect:/cvs";
        model.addAttribute("cv", cv);
        return "cv-form";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute("cv") @Valid CV cv, BindingResult result) {
        if (result.hasErrors()) {
            return "cv-form";
        }
        cv.setId(id);
        cvService.save(cv);
        return "redirect:/cvs";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        cvService.deleteById(id);
        return "redirect:/cvs";
    }

    @GetMapping("/{id}")
    public String viewDetail(@PathVariable Long id, Model model) {
        CV cv = cvService.findById(id);
        if (cv == null) return "redirect:/cvs";
        model.addAttribute("cv", cv);
        return "cv-detail";
    }
}
