package com.example.ss1.bt7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentTicketServlet", urlPatterns = {"/StudentTicketServlet"})
public class StudentTicketServlet extends HttpServlet {
    private static final List<Student> STUDENTS = new ArrayList<>();

    static {
        STUDENTS.add(new Student("Nguyễn Văn A", "K24", "Xe máy", "30A-12345"));
        STUDENTS.add(new Student("Trần Thị B",   "K23", "Xe đạp", "29B-54321"));
        STUDENTS.add(new Student("Lê Văn C",     "K24", "Xe ô tô", "51C-67890"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", STUDENTS);
        req.getRequestDispatcher("/listStudent.jsp")
                .forward(req, resp);
    }
}
