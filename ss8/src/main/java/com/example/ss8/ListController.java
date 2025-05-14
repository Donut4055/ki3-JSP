package com.example.ss8;

import javax.servlet.http.HttpSession;

import com.example.ss8.Model.CartItem;
import com.example.ss8.Model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@Controller
public class ListController {

    private List<Product> getProductList() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Laptop", 1500.0, 10, "Laptop hiệu suất cao", "https://via.placeholder.com/150"));
        products.add(new Product(2L, "Smartphone", 800.0, 25, "Điện thoại thông minh", "https://via.placeholder.com/150"));
        products.add(new Product(3L, "Tablet", 500.0, 15, "Máy tính bảng đa năng", "https://via.placeholder.com/150"));
        return products;
    }

    @GetMapping("/products")
    public String showProductList(Model model) {
        model.addAttribute("products", getProductList());
        return "product_list";
    }

    @GetMapping("/products/details")
    public String showProductDetails(@RequestParam("id") Long id, Model model) {
        Product selected = getProductList().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst().orElse(null);

        if (selected != null) {
            model.addAttribute("product", selected);
            return "product_details";
        } else {
            return "redirect:/products";
        }
    }

    // Thêm sản phẩm vào giỏ hàng
    @PostMapping("/cart/add")
    public String addToCart(@RequestParam("id") Long id,
                            @RequestParam("quantity") int quantity,
                            HttpSession session,
                            Model model) {
        if (quantity <= 0) {
            model.addAttribute("error", "Số lượng phải lớn hơn 0");
            model.addAttribute("products", getProductList());
            return "product_list";
        }

        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        Product product = getProductList().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst().orElse(null);

        if (product != null) {
            Optional<CartItem> existing = cart.stream()
                    .filter(item -> item.getProduct().getId().equals(id))
                    .findFirst();

            if (existing.isPresent()) {
                existing.get().setQuantity(existing.get().getQuantity() + quantity);
            } else {
                cart.add(new CartItem(product, quantity));
            }
        }

        session.setAttribute("cart", cart);
        return "redirect:/products";
    }

    @GetMapping("/cart")
    public String showCart(HttpSession session, Model model) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        double total = cart.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();

        model.addAttribute("cart", cart);
        model.addAttribute("total", total);
        return "cart";
    }

    @GetMapping("/cart/increase")
    public String increaseQuantity(@RequestParam("id") Long id, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            for (CartItem item : cart) {
                if (item.getProduct().getId().equals(id)) {
                    item.setQuantity(item.getQuantity() + 1);
                    break;
                }
            }
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/decrease")
    public String decreaseQuantity(@RequestParam("id") Long id, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            Iterator<CartItem> iterator = cart.iterator();
            while (iterator.hasNext()) {
                CartItem item = iterator.next();
                if (item.getProduct().getId().equals(id)) {
                    item.setQuantity(item.getQuantity() - 1);
                    if (item.getQuantity() <= 0) {
                        iterator.remove();
                    }
                    break;
                }
            }
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/remove")
    public String removeFromCart(@RequestParam("id") Long id, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            cart.removeIf(item -> item.getProduct().getId().equals(id));
        }
        return "redirect:/cart";
    }
}
