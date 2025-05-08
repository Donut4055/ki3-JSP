package com.example.ss3;

import Model.Book;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
@WebServlet(name = "bookServlet", value = "/BookServlet")
public class BookServlet extends HttpServlet {
    private List<Book> bookList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        bookList.add(new Book("Sách A", "Tác Giả A", 2021));
        bookList.add(new Book("Sách B", "Tác Giả B", 2020));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        int year = Integer.parseInt(request.getParameter("year"));

        Book newBook = new Book(name, author, year);
        bookList.add(newBook);

        getServletContext().setAttribute("bookList", bookList);

        response.sendRedirect("bt8.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = (List<Book>) getServletContext().getAttribute("bookList");

        String searchQuery = request.getParameter("search");
        if (searchQuery != null && !searchQuery.isEmpty()) {
            List<Book> searchResults = new ArrayList<>();
            for (Book book : bookList) {
                if (book.getName().toLowerCase().contains(searchQuery.toLowerCase())) {
                    searchResults.add(book);
                }
            }
            request.setAttribute("searchResults", searchResults);
        } else {
            request.setAttribute("searchResults", bookList);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("bt8.jsp");
        dispatcher.forward(request, response);
    }
}
