package com.example.ss8_2.Controller;

import com.example.ss8_2.Model.Product;
import com.example.ss8_2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();

        model.addAttribute("products", products);

        return "productList";
    }
    @GetMapping("/products/add")
    public String showAddProductForm() {
        return "addProduct";
    }

    @PostMapping("/products/add")
    public String addProduct(@RequestParam String name,
                             @RequestParam int quantity,
                             @RequestParam double price,
                             Model model) {
        Product newProduct = new Product(productService.getNextProductId(), name, price);
        productService.addProduct(newProduct);

        model.addAttribute("product", newProduct);
        return "view";
    }
}
