package com.example.ss2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

@WebServlet("/registerBt5")
public class Bt5 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='vi'><head>");
        out.println("  <meta charset='UTF-8'>");
        out.println("  <title>Đăng ký người dùng</title>");
        out.println("  <style>");
        out.println("    label{display:inline-block;width:100px;}");
        out.println("    input{margin-bottom:8px;}");
        out.println("  </style>");
        out.println("</head><body>");
        out.println("  <h1>Form Đăng ký</h1>");
        out.println("  <form action='register' method='post'>");
        out.println("    <div><label for='name'>Tên:</label>");
        out.println("        <input type='text' id='name' name='name' required /></div>");
        out.println("    <div><label for='email'>Email:</label>");
        out.println("        <input type='email' id='email' name='email' required /></div>");
        out.println("    <div><label for='password'>Mật khẩu:</label>");
        out.println("        <input type='password' id='password' name='password' required /></div>");
        out.println("    <button type='submit'>Đăng ký</button>");
        out.println("  </form>");
        out.println("</body></html>");

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name     = request.getParameter("name");
        String email    = request.getParameter("email");
        String password = request.getParameter("password");

        request.setAttribute("userName", name);
        request.setAttribute("userEmail", email);
        request.setAttribute("userPass", password);

        RequestDispatcher rd = request.getRequestDispatcher("/userInfoBt5.jsp");
        rd.forward(request, response);
    }
}
