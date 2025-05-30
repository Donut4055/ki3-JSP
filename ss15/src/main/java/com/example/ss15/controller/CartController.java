package com.example.ss15.controller;


import com.example.ss15.model.Cart;
import com.example.ss15.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public String viewCart(HttpSession session, Model model) {
        int idUser = 1;
        List<Cart> cartList = cartService.getCartByUser(idUser);

        double totalPrice = cartList.stream()
                .mapToDouble(c -> c.getQuantity() * c.getProductPrice())
                .sum();

        model.addAttribute("cartList", cartList);
        model.addAttribute("totalPrice", totalPrice);
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam int productId,
                            @RequestParam int quantity,
                            HttpSession session) {
        int idUser = 1 ;
        cartService.addToCart(idUser, productId, quantity);
        return "redirect:/cart";
    }

    @GetMapping("/delete/{idCart}")
    public String deleteCartItem(@PathVariable int idCart) {
        cartService.removeCartItem(idCart);
        return "redirect:/cart";
    }
}

