package com.example.ss17.controller;


import com.example.ss17.entity.Customer;
import com.example.ss17.service.CustomerService;
import com.example.ss17.service.OrderService;
import com.example.ss17.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;

    public boolean checkAdminAccess(HttpSession session) {
        Customer user = (Customer) session.getAttribute("currentUser");
        return user != null && "ADMIN".equals(user.getRole());
    }

    @GetMapping
    public String dashboard(HttpSession session, Model model) {
        if (!checkAdminAccess(session)) {
            return "redirect:/login";
        }
        long totalProducts = productService.countAll();
        long totalUsers = customerService.countAll();
        long totalOrders = orderService.countAll();
        double totalRevenue = orderService.getTotalRevenue();

        model.addAttribute("totalProducts", totalProducts);
        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("totalOrders", totalOrders);
        model.addAttribute("totalRevenue", totalRevenue);
        model.addAttribute("content", "admin/dashboard");
        return "admin/admin-layout";
    }
}
