package com.example.ss4;

import com.example.ss4.bt1.Product;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/ProductServlet")
public class Bt7 extends HttpServlet {
    private List<Product> products;

    @Override
    public void init() throws ServletException {
        products = new ArrayList<>();
        products.add(new Product(1, "Iphone 15", 3000.0, "Sản phẩm mới nhất"));
        products.add(new Product(2, "SamSung Galaxy S21", 2500.0, "Màn hình đẹp"));
        products.add(new Product(3, "Laptop Dell XPS", 5000.0, "Hiệu suất cao"));
        products.add(new Product(4, "Tai Nghe AirPods", 200.0, "Chất lượng âm thanh tuyệt vời"));
        products.add(new Product(5, "Smart Watch", 150.0, "Theo dõi sức khoẻ"));

        getServletContext().setAttribute("products", products);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> filteredProducts = products;

        String minPriceParam = request.getParameter("minPrice");
        String maxPriceParam = request.getParameter("maxPrice");

        if (minPriceParam != null && maxPriceParam != null) {
            double minPrice = Double.parseDouble(minPriceParam);
            double maxPrice = Double.parseDouble(maxPriceParam);

            filteredProducts = new ArrayList<>();
            for (Product product : products) {
                if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                    filteredProducts.add(product);
                }
            }
        }

        request.setAttribute("products", filteredProducts);

        RequestDispatcher dispatcher = request.getRequestDispatcher("bt7.jsp");
        dispatcher.forward(request, response);
    }
}
