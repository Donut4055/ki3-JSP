package com.example.ss3;

import Model.User;
import Model.UserManager;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
@WebServlet (name = "userServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private UserManager userManager = new UserManager();

    @Override
    public void init() throws ServletException {
        userManager.addUser(new User(1, "Nguyen A", "nguyena@example.com"));
        userManager.addUser(new User(2, "Le B", "le@example.com"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userManager.getUsers();
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listUser.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        int id = userManager.getUsers().size() + 1;
        User newUser = new User(id, name, email);

        userManager.addUser(newUser);

        getServletContext().setAttribute("users", userManager.getUsers());

        response.sendRedirect("UserServlet");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userManager.removeUser(id);

        response.sendRedirect("UserServlet");
    }
}
