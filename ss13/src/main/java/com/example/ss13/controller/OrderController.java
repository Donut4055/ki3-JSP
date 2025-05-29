package com.example.ss13.controller;

import com.example.ss13.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/form")
    public String showForm(Model model, HttpServletRequest request) {
        Order order = new Order();
        for (Cookie cookie : request.getCookies() == null ? new Cookie[0] : request.getCookies()) {
            if ("customerName".equals(cookie.getName())) {
                order.setCustomerName(cookie.getValue());
                break;
            }
        }
        model.addAttribute("order", order);
        return "order-form";
    }

    @PostMapping("/submit")
    public String submitOrder(@ModelAttribute Order order,
                              HttpSession session,
                              HttpServletResponse response,
                              Model model) {
        session.setAttribute("order", order);

        Cookie cookie = new Cookie("customerName", order.getCustomerName());
        cookie.setMaxAge(7 * 24 * 60 * 60); // 7 ngày
        response.addCookie(cookie);

        model.addAttribute("message", "Đặt hàng thành công!");
        return "order-success";
    }

    @GetMapping("/view")
    public String viewOrder(HttpSession session, Model model) {
        Order order = (Order) session.getAttribute("order");
        if (order == null) {
            model.addAttribute("message", "Bạn chưa đặt đơn hàng nào.");
            return "order-view";
        }
        model.addAttribute("order", order);
        return "order-view";
    }
}
