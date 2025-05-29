package com.example.ss13.controller;


import com.example.ss13.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    private static final String PRODUCT_COOKIE = "productNames";
    private static final int COOKIE_MAX_AGE = 7 * 24 * 60 * 60;

    @GetMapping
    public String showCart(Model model, HttpSession session, HttpServletRequest request) {
        model.addAttribute("product", new Product());
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();
        model.addAttribute("cart", cart);

        List<String> productNames = getProductNamesFromCookie(request);
        model.addAttribute("productNames", productNames);

        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@ModelAttribute Product product,
                            HttpSession session,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        // Lưu vào session
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();
        cart.add(product);
        session.setAttribute("cart", cart);

        List<String> productNames = getProductNamesFromCookie(request);
        if (!productNames.contains(product.getName())) {
            productNames.add(product.getName());
            saveProductNamesToCookie(productNames, response);
        }

        return "redirect:/cart";
    }

    @GetMapping("/delete/{index}")
    public String deleteFromCart(@PathVariable int index, HttpSession session) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart != null && index >= 0 && index < cart.size()) {
            cart.remove(index);
            session.setAttribute("cart", cart);
        }
        return "redirect:/cart";
    }

    private List<String> getProductNamesFromCookie(HttpServletRequest request) {
        List<String> names = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (PRODUCT_COOKIE.equals(cookie.getName())) {
                    try {
                        String value = URLDecoder.decode(cookie.getValue(), "UTF-8");
                        if (!value.isEmpty()) {
                            names = new ArrayList<>(Arrays.asList(value.split(";")));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        return names;
    }

    private void saveProductNamesToCookie(List<String> names, HttpServletResponse response) {
        try {
            String value = String.join(";", names);
            value = URLEncoder.encode(value, "UTF-8");
            Cookie cookie = new Cookie(PRODUCT_COOKIE, value);
            cookie.setMaxAge(COOKIE_MAX_AGE);
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
