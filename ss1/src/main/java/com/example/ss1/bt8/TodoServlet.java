package com.example.ss1;

import com.example.ss1.bt8.Todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Bt8")
public class TodoServlet extends HttpServlet {
    // Danh sách tĩnh lưu trong bộ nhớ JVM
    private static final List<Todo> todoList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Đưa danh sách công việc vào request
        req.setAttribute("todos", todoList);
        // Forward sang JSP
        req.getRequestDispatcher("/todo.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String action = req.getParameter("action");
        if ("add".equals(action)) {
            String desc = req.getParameter("description");
            if (desc != null && !desc.trim().isEmpty()) {
                todoList.add(new Todo(desc.trim()));
            }
        } else if ("toggle".equals(action)) {
            int idx = Integer.parseInt(req.getParameter("index"));
            if (idx >= 0 && idx < todoList.size()) {
                Todo t = todoList.get(idx);
                t.setCompleted(!t.isCompleted());
            }
        }

        // Trả về GET để hiện lại danh sách
        resp.sendRedirect(req.getContextPath() + "/Bt8");
    }
}
