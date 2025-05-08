package com.example.ss4.bt8;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/RevenueServlet")
public class RevenueServlet extends HttpServlet {
    private List<Revenue> revenues;
    @Override
    public void init() throws ServletException {
        revenues = new ArrayList<>();
        revenues.add(new Revenue("Tháng 1", 12000.0));
        revenues.add(new Revenue("Tháng 2", 9500.0));
        revenues.add(new Revenue("Tháng 3", 13000.0));
        revenues.add(new Revenue("Tháng 4", 8000.0));
        revenues.add(new Revenue("Tháng 5", 15000.0));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("revenues", revenues);
        RequestDispatcher dispatcher = request.getRequestDispatcher("revenue.jsp");
        dispatcher.forward(request, response);
    }
}
