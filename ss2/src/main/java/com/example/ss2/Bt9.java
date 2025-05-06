package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/guess")
public class Bt9 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String[] WORDS = {
            "Hoa hồng", "Con chó", "Máy bay", "Xe đạp", "Việt Nam"
    };
    private static final int MAX_TRIES = 3;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();

        // --- 1) Khởi tạo / reset trò chơi ---
        if (session.getAttribute("secret") == null || req.getParameter("reset") != null) {
            String secret = WORDS[new Random().nextInt(WORDS.length)];
            session.setAttribute("secret", secret);
            session.setAttribute("tries", MAX_TRIES);
            session.removeAttribute("result");
            session.removeAttribute("message");
            session.removeAttribute("revealIndices");
        }

        String secret = (String) session.getAttribute("secret");
        Integer tries  = (Integer) session.getAttribute("tries");
        String result  = (String) session.getAttribute("result");
        String message = (String) session.getAttribute("message");

        // --- 2) Tính và lưu các vị trí sẽ reveal (chỉ lần đầu) ---
        @SuppressWarnings("unchecked")
        Set<Integer> reveal = (Set<Integer>) session.getAttribute("revealIndices");
        if (reveal == null) {
            // Tập các chỉ số ký tự không phải space
            List<Integer> positions = new ArrayList<>();
            for (int i = 0; i < secret.length(); i++) {
                if (!Character.isWhitespace(secret.charAt(i)))
                    positions.add(i);
            }
            // Chọn ngẫu nhiên nửa số
            Collections.shuffle(positions);
            int toReveal = positions.size() / 2;
            reveal = new HashSet<>(positions.subList(0, toReveal));
            session.setAttribute("revealIndices", reveal);
        }

        // --- 3) Tạo mask với các ký tự đã reveal ---
        StringBuilder mask = new StringBuilder();
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            if (Character.isWhitespace(c)) {
                mask.append("&nbsp;&nbsp;");
            } else if (reveal.contains(i)) {
                // hiển thị letter
                mask.append(c).append(' ');
            } else {
                mask.append("_ ");
            }
        }

        // --- 4) In HTML ---
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html><html lang='vi'><head><meta charset='UTF-8'>");
        out.println("<title>Game Đoán Chữ</title>");
        out.println("<style>body{font-family:Arial,sans-serif;margin:20px;}"+
                ".msg{margin-top:10px;font-weight:bold;}"+
                ".win{color:green;}.lose{color:red;}</style>");
        out.println("</head><body>");
        out.println("<h1>Game Đoán Chữ</h1>");

        if (result == null) {
            out.printf("<p><strong>Từ bạn đang phải đoán như sau:</strong> <span style='letter-spacing:4px;'>%s</span></p>%n", mask);
            out.printf("<p><strong>Bạn còn:</strong> %d lượt đoán</p>%n", tries);
            out.println("<form action='guess' method='post'>");
            out.println("  <input type='text' name='guess' placeholder='Nhập từ bạn đoán' required />");
            out.println("  <button type='submit'>Đoán</button>");
            out.println("</form>");
            if (message != null) {
                out.printf("<p class='msg'>%s</p>%n", message);
            }
        }
        else if ("win".equals(result)) {
            out.printf("<p class='msg win'>%s</p>%n", message);
            out.println("<p><a href='guess?reset=true'>Chơi lại</a></p>");
        }
        else {
            out.printf("<p class='msg lose'>%s</p>%n", message);
            out.println("<p><a href='guess?reset=true'>Chơi lại</a></p>");
        }

        out.println("</body></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String secret = (String) session.getAttribute("secret");
        Integer tries = (Integer) session.getAttribute("tries");
        String result = (String) session.getAttribute("result");

        if (result == null) {
            String guess = req.getParameter("guess");
            if (guess != null && guess.equalsIgnoreCase(secret)) {
                session.setAttribute("result", "win");
                session.setAttribute("message", "🎉 Chúc mừng! Bạn đoán đúng từ bí mật.");
            } else {
                tries--;
                session.setAttribute("tries", tries);
                if (tries <= 0) {
                    session.setAttribute("result", "lose");
                    session.setAttribute("message", "☹️ Bạn đã thua sau "
                            + MAX_TRIES + " lần đoán! Từ đúng là: " + secret);
                } else {
                    session.setAttribute("message", "Sai rồi! Vui lòng thử lại.");
                }
            }
        }

        // redirect để tránh resubmit và hiển thị lại giao diện
        resp.sendRedirect(req.getContextPath() + "/guess");
    }
}
