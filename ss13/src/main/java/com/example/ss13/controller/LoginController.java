package com.example.ss13.controller;

import com.example.ss13.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(Model model, HttpServletRequest request) {
        User user = new User();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("username".equals(c.getName())) {
                    user.setUsername(c.getValue());
                }
                if ("password".equals(c.getName())) {
                    user.setPassword(c.getValue());
                }
            }
        }
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute("user") User user,
                          @RequestParam(value = "rememberMe", required = false) String rememberMe,
                          Model model,
                          HttpSession session,
                          HttpServletResponse response) {
        if ("admin".equals(user.getUsername()) && "123456".equals(user.getPassword())) {
            session.setAttribute("loggedInUser", user);

            if ("on".equals(rememberMe)) {
                Cookie userCookie = new Cookie("username", user.getUsername());
                Cookie passCookie = new Cookie("password", user.getPassword());
                userCookie.setMaxAge(7 * 24 * 60 * 60);
                passCookie.setMaxAge(7 * 24 * 60 * 60);
                userCookie.setPath("/");
                passCookie.setPath("/");
                response.addCookie(userCookie);
                response.addCookie(passCookie);
            } else {
                Cookie userCookie = new Cookie("username", null);
                Cookie passCookie = new Cookie("password", null);
                userCookie.setMaxAge(0);
                passCookie.setMaxAge(0);
                userCookie.setPath("/");
                passCookie.setPath("/");
                response.addCookie(userCookie);
                response.addCookie(passCookie);
            }
            return "redirect:/welcome";
        } else {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng!");
            return "login";
        }
    }

    @GetMapping("/welcome")
    public String welcome(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("username", user.getUsername());
        return "welcome";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
