package com.example.ss19.controller;

import com.example.ss19.entity.User;
import com.example.ss19.service.CloudinaryService;
import com.example.ss19.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService usersService;
    @Autowired
    private CloudinaryService cloudinaryService;
    @GetMapping
    public String listUsers(Model model) {
        List<User> users = usersService.findAll();

        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/add")
    public String addUser(@Valid User user,
                          BindingResult result,
                          @ModelAttribute("user") HttpSession session,
                          @RequestParam("imageFile") MultipartFile imageFile,
                          Model model) throws IOException {
        if (result.hasErrors()) {
            model.addAttribute("content", "user-form");
            return "user-form";
        }
        if (!imageFile.isEmpty()) {
            String imageUrl = cloudinaryService.upload(imageFile, "products");
            user.setImg(imageUrl);
        }

        usersService.save(user);
        session.setAttribute("message", "User added successfully");
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable("id") Integer id, Model model) {
        User user = usersService.findAll().stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (user == null) {
            return "redirect:/users";
        }
        model.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, @ModelAttribute("user") User user, HttpSession session) {
        user.setId(id);
        usersService.save(user);
        session.setAttribute("message", "User updated successfully");
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, HttpSession session) {
        usersService.delete(id);
        session.setAttribute("message", "User deleted successfully");
        return "redirect:/users";
    }

    @GetMapping("/search")
    public String searchUsers(@RequestParam("name") String name, Model model) {
        List<User> users = usersService.findByName(name);
        model.addAttribute("users", users);
        return "user-list";
    }
}