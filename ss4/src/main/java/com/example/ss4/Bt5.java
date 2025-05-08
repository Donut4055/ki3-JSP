package com.example.ss4;

import com.example.ss4.bt1.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/Bt5")
public class Bt5 extends HttpServlet {
    private List<Product> products;

    @Override
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "Iphone15",           3000.0,  "sản phẩm mới về"));
        products.add(new Product(2, "SamSung Galaxy 21",  2900.0,  "thế hệ đột phá"));
        products.add(new Product(3, "Đồng hồ Thuỵ Sỹ",    15000.0, "đẹp khỏi chê"));
        products.add(new Product(4, "Tai nghe Airpods",   2000.0,  "càng nghe càng thích"));
        products.add(new Product(5, "Laptop Lenovo",      3000.0,  "đổi trả trong 30 ngày miễn phí"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", products);
        req.getRequestDispatcher("/bt5.jsp").forward(req, resp);
    }
}
