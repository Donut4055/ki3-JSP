package com.example.ss1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Bt5")
public class Bt5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Ví dụ: chia cho 0 sẽ ném ArithmeticException
            int a = Integer.parseInt(req.getParameter("a"));
            int b = Integer.parseInt(req.getParameter("b"));
            int result = a / b;

            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().println("<h1>Kết quả: " + result + "</h1>");
        } catch (ArithmeticException | NumberFormatException ex) {
            req.setAttribute("errorMessage", "Có lỗi trong quá trình tính toán: không thể chia cho 0 hoặc dữ liệu đầu vào không hợp lệ.");
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }
}
