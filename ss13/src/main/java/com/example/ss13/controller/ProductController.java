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
@RequestMapping("/product")
public class ProductController {

    private static final String COOKIE_NAME = "productList";
    private static final int COOKIE_MAX_AGE = 7 * 24 * 60 * 60;

    @GetMapping
    public String showForm(Model model, HttpServletRequest request) {
        model.addAttribute("product", new Product());
        List<Product> products = getProductsFromCookie(request);
        model.addAttribute("products", products);
        return "product";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product,
                             HttpServletRequest request,
                             HttpServletResponse response) {
        List<Product> products = getProductsFromCookie(request);
        products.add(product);
        saveProductsToCookie(products, response);
        return "redirect:/product";
    }

    @GetMapping("/delete/{code}")
    public String deleteProduct(@PathVariable String code,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        List<Product> products = getProductsFromCookie(request);
        products.removeIf(p -> p.getCode().equals(code));
        saveProductsToCookie(products, response);
        return "redirect:/product";
    }

    private List<Product> getProductsFromCookie(HttpServletRequest request) {
        List<Product> products = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (COOKIE_NAME.equals(cookie.getName())) {
                    try {
                        String value = URLDecoder.decode(cookie.getValue(), "UTF-8");
                        String[] items = value.split(";");
                        for (String item : items) {
                            if (!item.trim().isEmpty()) {
                                String[] fields = item.split("\\|");
                                if (fields.length == 3) {
                                    Product p = new Product();
                                    p.setCode(fields[0]);
                                    p.setName(fields[1]);
                                    p.setPrice(Double.parseDouble(fields[2]));
                                    products.add(p);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        return products;
    }

    private void saveProductsToCookie(List<Product> products, HttpServletResponse response) {
        try {
            StringBuilder sb = new StringBuilder();
            for (Product p : products) {
                sb.append(p.getCode()).append("|")
                        .append(p.getName()).append("|")
                        .append(p.getPrice()).append(";");
            }
            String value = URLEncoder.encode(sb.toString(), "UTF-8");
            Cookie cookie = new Cookie(COOKIE_NAME, value);
            cookie.setMaxAge(COOKIE_MAX_AGE);
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
