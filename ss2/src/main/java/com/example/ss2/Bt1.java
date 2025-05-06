package com.example.ss2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle")
public class Bt1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        super.init();
        log("LifecycleServlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html><head><meta charset='UTF-8'><title>Servlet Lifecycle</title></head><body>");
        out.println("<h1>Vòng đời của Servlet</h1>");
        out.println("<ul>");
        out.println("<li><strong>init()</strong>: Được gọi duy nhất 1 lần khi servlet được khởi tạo.</li>");
        out.println("<li><strong>service()</strong>: Được container gọi cho mỗi request; trong HttpServlet, service sẽ chuyển đến doGet/doPost…</li>");
        out.println("<li><strong>doGet()/doPost()</strong>: Xử lý request GET/POST tương ứng.</li>");
        out.println("<li><strong>destroy()</strong>: Được gọi 1 lần trước khi servlet bị hủy, dùng để giải phóng tài nguyên.</li>");
        out.println("</ul>");
        out.println("<p>Đã gọi doGet() để hiển thị trang này.</p>");
        out.println("</body></html>");
        out.close();
        log("LifecycleServlet serviced a GET request");
    }

    @Override
    public void destroy() {
        log("LifecycleServlet is about to be destroyed");
        super.destroy();
    }
}
