package com.example.ss6.Controller;

import com.example.ss6.Model.Product;
import com.example.ss6.Model.ProductCart;
import com.example.ss6.Service.ProductCartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "cart", value = "/cart")
public class ProductCartController extends HttpServlet {
    private final ProductCartService productCartService = new ProductCartService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductCart> cartList = productCartService.getProductCart();
        double totalAmount = 0;

        // Kiểm tra cartList có null không
        if (cartList != null) {
            for (ProductCart item : cartList) {
                Product product = productCartService.getProductById(item.getProductId());
                if (product != null) {
                    totalAmount += product.getPrice() * item.getQuantity();
                }
            }
        }

        req.setAttribute("cartList", cartList);
        req.setAttribute("totalAmount", totalAmount);
        req.getRequestDispatcher("view/bt3/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        productCartService.removeProductCart(productId);
        resp.sendRedirect(req.getContextPath() + "/cart");
    }
}
