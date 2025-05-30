package com.example.ss15.controller;

import com.example.ss15.model.Product;
import com.example.ss15.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping
    public String listProducts(Model model) {
        List<Product> products = productDAO.findAll();
        model.addAttribute("products", products);
        return "listProduct";
    }

    @GetMapping("/{id}")
    public String productDetail(@PathVariable int id, Model model) {
        Product product = productDAO.findById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "productDetail";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "productForm";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product) {
        productDAO.insert(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Product product = productDAO.findById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "productForm";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable int id, @ModelAttribute("product") Product product) {
        product.setId(id);
        productDAO.update(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productDAO.delete(id);
        return "redirect:/products";
    }

    @GetMapping("/search")
    public String searchProduct(@RequestParam("keyword") String keyword, Model model) {
        List<Product> products = productDAO.searchByName(keyword);
        model.addAttribute("products", products);
        return "listProduct";
    }
}

