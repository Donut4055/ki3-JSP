package com.example.ss2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userInfo")
public class Bt2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='vi'><head>");
        out.println("  <meta charset='UTF-8'>");
        out.println("  <title>Nhập thông tin người dùng</title>");
        out.println("</head><body>");
        out.println("  <h1>Form Nhập Thông Tin</h1>");
        out.println("  <form action='userInfo' method='post'>");
        out.println("    <label for='name'>Tên:</label>");
        out.println("    <input type='text' id='name' name='name' required /><br/><br/>");
        out.println("    <label for='age'>Tuổi:</label>");
        out.println("    <input type='number' id='age' name='age' min='0' required /><br/><br/>");
        out.println("    <button type='submit'>Gửi</button>");
        out.println("  </form>");
        out.println("</body></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        int age = 0;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
        }

        request.setAttribute("userName", name);
        request.setAttribute("userAge", age);

        request.getRequestDispatcher("/userinfo.jsp")
                .forward(request, response);
    }
}
