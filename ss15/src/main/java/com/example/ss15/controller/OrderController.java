package com.example.ss15.controller;


import com.example.ss15.model.Cart;
import com.example.ss15.model.Order;
import com.example.ss15.model.OrderDetail;
import com.example.ss15.service.CartService;
import com.example.ss15.service.OrderDetailService;
import com.example.ss15.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private CartService cartService;

    @GetMapping("/checkout")
    public String checkout(HttpSession session, Model model) {
        int idUser = 1;
        List<Cart> cartList = cartService.getCartByUser(idUser);
        model.addAttribute("cartList", cartList);
        return "checkout";
    }

    @PostMapping("/checkout")
    public String doCheckout(@RequestParam String recipientName,
                             @RequestParam String address,
                             @RequestParam String phonenumber,
                             HttpSession session) {
        int idUser = 1;
        List<Cart> cartList = cartService.getCartByUser(idUser);

        Order order = new Order();
        order.setIdUser(idUser);
        order.setRecipientName(recipientName);
        order.setAddress(address);
        order.setPhonenumber(phonenumber);
        int orderId = orderService.createOrder(order);

        for (Cart c : cartList) {
            OrderDetail detail = new OrderDetail();
            detail.setOrderId(orderId);
            detail.setProductId(c.getIdProduct());
            detail.setQuantity(c.getQuantity());
            detail.setCurrentPrice(c.getProductPrice());
            orderDetailService.addOrderDetail(detail);
        }

        return "redirect:/orders";
    }

    @GetMapping
    public String listOrders(HttpSession session, Model model) {
        int idUser = 1;
        List<Order> orders = orderService.getOrdersByUser(idUser);
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("/{orderId}")
    public String orderDetail(@PathVariable int orderId, Model model) {
        Order order = orderService.findById(orderId);
        List<OrderDetail> orderDetails = orderDetailService.getOrderDetailsByOrderId(orderId);
        if (order == null) {
            return "redirect:/orders";
        }
        double totalPrice = orderDetails.stream()
                .mapToDouble(d -> d.getQuantity() * d.getCurrentPrice())
                .sum();

        model.addAttribute("order", order);
        model.addAttribute("orderDetails", orderDetails);
        model.addAttribute("totalPrice", totalPrice);
        return "orderDetail";
    }

}

