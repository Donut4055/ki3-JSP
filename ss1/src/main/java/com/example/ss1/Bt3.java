package com.example.ss1;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Bt3", value = "/Bt3")
public class Bt3 extends HttpServlet {
    private String message;
    private String name = "Hà Nội";
    private String age = "20";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" +name+ "</h1>");
        out.println("<h1>" +age+ "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}