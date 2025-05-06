package com.example.ss2.Bt678;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<Product> productList = new ArrayList<>();
    private int nextId = 1;

    @Override
    public void init() {
        productList.add(new Product(nextId++, "iphone 10", 5000.0));
        productList.add(new Product(nextId++, "Laptop dell", 15000.0));
        productList.add(new Product(nextId++, "Apple watch 5", 3000.0));
        getServletContext().setAttribute("productList", productList);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("edit".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            Product p = findById(id);
            req.setAttribute("product", p);
            req.getRequestDispatcher("/updateProduct.jsp")
                    .forward(req, resp);
        } else {
            getServletContext().setAttribute("productList", productList);
            req.getRequestDispatcher("/productList.jsp")
                    .forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action   = req.getParameter("action");
        String name     = req.getParameter("name");
        String priceStr = req.getParameter("price");
        String idStr    = req.getParameter("id");

        if ("add".equals(action)) {
            if (!name.isBlank() && priceStr != null) {
                double price = Double.parseDouble(priceStr);
                productList.add(new Product(nextId++, name, price));
            }
        }
        else if ("update".equals(action)) {
            int id = Integer.parseInt(idStr);
            Product p = findById(id);
            if (p != null && !name.isBlank()) {
                p.setName(name);
                p.setPrice(Double.parseDouble(priceStr));
            }
        }
        else if ("delete".equals(action)) {
            int id = Integer.parseInt(idStr);
            productList.removeIf(x -> x.getId() == id);
        }

        resp.sendRedirect(req.getContextPath() + "/product");
    }

    private Product findById(int id) {
        return productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst().orElse(null);
    }
}
