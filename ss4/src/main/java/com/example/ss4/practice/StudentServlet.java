package com.example.ss4.practice;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    List<Student> list = new ArrayList<>();
    @Override
    public void init() throws ServletException {
        list.add(new Student(1, "Nguyễn Văn A", 9.0, "Hà Nội"));
        list.add(new Student(2, "Trần Thị B", 7.5, "Hải Phòng"));
        list.add(new Student(3, "Lê Văn C", 6.2, "Đà Nẵng"));
        list.add(new Student(4, "Phạm Thị D", 5.5, "Huế"));
        list.add(new Student(5, "Võ Văn E", 4.8, "TP. HCM"));

        getServletContext().setAttribute("studentList", list);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", list);
        req.getRequestDispatcher("/studentList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("add".equals(action)) {
            String name    = req.getParameter("name");
            String scoreS  = req.getParameter("score");
            String address = req.getParameter("address");

            String error = null;
            if (name == null || name.trim().isEmpty()) {
                error = "Chưa nhập tên!";
            } else if (scoreS == null || scoreS.trim().isEmpty()) {
                error = "Chưa nhập điểm!";
            }

            if (error != null) {
                req.setAttribute("error", error);
                req.setAttribute("oldName", name);
                req.setAttribute("oldScore", scoreS);
                req.setAttribute("oldAddress", address);
                doGet(req, resp);
                return;
            }

            double score = Double.parseDouble(scoreS);
            int nextId = list.stream().mapToInt(Student::getId).max().orElse(0) + 1;
            list.add(new Student(nextId, name.trim(), score, address == null ? "" : address.trim()));
            resp.sendRedirect("students");
        }
        else if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            list.removeIf(s -> s.getId() == id);
            resp.sendRedirect("students");
        }
    }
}

