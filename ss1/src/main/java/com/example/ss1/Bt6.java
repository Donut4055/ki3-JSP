package com.example.ss1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Bt6", urlPatterns = {"/Bt6"})
public class Bt6 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"vi\"><head>");
        out.println("  <meta charset=\"UTF-8\"/>");
        out.println("  <title>Đăng ký vé xe</title>");
        out.println("</head><body>");
        out.println("  <h2>Đăng ký vé xe</h2>");
        out.println("  <form action=\"Bt6\" method=\"post\">");
        out.println("    <label>Họ và tên:<br><input type=\"text\" name=\"fullName\" required></label><br><br>");
        out.println("    <label>Lớp:<br><input type=\"text\" name=\"className\" required></label><br><br>");
        out.println("    <label>Loại xe:<br>");
        out.println("      <select name=\"vehicleType\" required>");
        out.println("        <option value=\"\">-- Chọn loại xe --</option>");
        out.println("        <option value=\"Xe máy\">Xe máy</option>");
        out.println("        <option value=\"Xe đạp\">Xe đạp</option>");
        out.println("        <option value=\"Xe ô tô\">Xe ô tô</option>");
        out.println("      </select>");
        out.println("    </label><br><br>");
        out.println("    <label>Biển số xe:<br><input type=\"text\" name=\"plateNumber\" required></label><br><br>");
        out.println("    <button type=\"submit\">Đăng ký</button>");
        out.println("  </form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        handleRegister(req, resp);
    }

    private void handleRegister(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fullName    = req.getParameter("fullName");
        String className   = req.getParameter("className");
        String vehicleType = req.getParameter("vehicleType");
        String plateNumber = req.getParameter("plateNumber");

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"vi\"><head>");
        out.println("  <meta charset=\"UTF-8\"/>");
        out.println("  <title>Kết quả đăng ký</title>");
        out.println("  <style>body{font-family:Arial;padding:20px;} .label{font-weight:bold;}</style>");
        out.println("</head><body>");
        out.println("  <h2>Đăng ký vé xe thành công!</h2>");
        out.printf("  <p><span class=\"label\">Họ và tên:</span> %s</p>%n", fullName);
        out.printf("  <p><span class=\"label\">Lớp:</span> %s</p>%n", className);
        out.printf("  <p><span class=\"label\">Loại xe:</span> %s</p>%n", vehicleType);
        out.printf("  <p><span class=\"label\">Biển số xe:</span> %s</p>%n", plateNumber);
        out.println("  <p><a href=\"Bt6\">Đăng ký tiếp</a></p>");
        out.println("</body></html>");
    }


}
