package com.example.ss15.controller;


import com.example.ss15.model.ProductSearch;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductSearchController {

    private List<ProductSearch> productList = new ArrayList<>();

    public ProductSearchController() {
        productList.add(new ProductSearch("P001", "Sản phẩm A"));
        productList.add(new ProductSearch("P002", "Sản phẩm B"));
        productList.add(new ProductSearch("P003", "Sản phẩm C"));
    }

    @GetMapping("/search")
    public String showSearchForm() {
        return "search";
    }

    @PostMapping("/search")
    public String searchProducts(@RequestParam @NotBlank(message = "Trường tìm kiếm không được để trống") String keyword,
                                 Model model) {
        List<ProductSearch> results = productList.stream()
                .filter(p -> p.getCode().toLowerCase().contains(keyword.toLowerCase())
                        || p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        model.addAttribute("results", results);
        model.addAttribute("keyword", keyword);
        return "search";
    }
}

