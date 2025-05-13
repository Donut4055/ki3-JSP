package com.example.ss6.Controller;

import com.example.ss6.Model.Product;
import com.example.ss6.Service.ProductCartService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "product", value = "/product")
public class ProductController extends HttpServlet {
    private final ProductCartService productCartService = new ProductCartService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = productCartService.getAllProducts();
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("view/bt3/productList.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        productCartService.addProductCart(productId,1);
        doGet(req, resp);
    }
}