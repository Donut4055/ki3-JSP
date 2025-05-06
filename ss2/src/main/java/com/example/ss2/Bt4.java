package com.example.ss2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Bt4 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='vi'><head>");
        out.println("  <meta charset='UTF-8'>");
        out.println("  <title>Đăng ký tài khoản</title>");
        out.println("  <style>label{display:inline-block;width:100px;} .error{color:red;}</style>");
        out.println("</head><body>");
        out.println("  <h1>Form Đăng ký tài khoản</h1>");
        out.println("  <form action='register' method='post'>");
        out.println("    <div><label for='username'>Username*:</label>");
        out.println("        <input type='text' id='username' name='username' required /></div><br/>");
        out.println("    <div><label for='password'>Password*:</label>");
        out.println("        <input type='password' id='password' name='password' required /></div><br/>");
        out.println("    <div><label for='fullname'>Họ tên*:</label>");
        out.println("        <input type='text' id='fullname' name='fullname' required /></div><br/>");
        out.println("    <div><label for='age'>Tuổi:</label>");
        out.println("        <input type='number' id='age' name='age' min='0' /></div><br/>");
        out.println("    <div><label for='address'>Địa chỉ:</label>");
        out.println("        <textarea id='address' name='address' rows='3' cols='30'></textarea></div><br/>");
        out.println("    <button type='submit'>Đăng ký</button>");
        out.println("  </form>");
        out.println("  <p><small>* là trường bắt buộc</small></p>");
        out.println("</body></html>");

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String ageStr   = request.getParameter("age");
        String address  = request.getParameter("address");

        List<String> errors = new ArrayList<>();
        if (username == null || username.isBlank()) errors.add("Username");
        if (password == null || password.isBlank()) errors.add("Password");
        if (fullname == null || fullname.isBlank()) errors.add("Họ tên");

        response.sendRedirect(request.getContextPath() + "/thankyou.jsp");
        out.close();
    }
}
