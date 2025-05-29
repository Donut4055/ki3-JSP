package com.example.ss13.controller;


import com.example.ss13.model.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.*;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping("/finance")
public class FinanceController {

    @GetMapping("/form")
    public String showForm(Model model, HttpServletRequest request) {
        Transaction transaction = new Transaction();

        for (Cookie cookie : request.getCookies() == null ? new Cookie[0] : request.getCookies()) {
            if ("username".equals(cookie.getName())) {
                model.addAttribute("username", cookie.getValue());
                break;
            }
        }
        model.addAttribute("transaction", transaction);
        return "finance-form";
    }

    @PostMapping("/add")
    public String addTransaction(@ModelAttribute("transaction") @Valid Transaction transaction,
                                 @RequestParam("username") String username,
                                 HttpSession session,
                                 HttpServletResponse response,
                                 Model model) {
        Cookie cookie = new Cookie("username", username);
        cookie.setMaxAge(7 * 24 * 60 * 60);
        response.addCookie(cookie);

        List<Transaction> transactions = (List<Transaction>) session.getAttribute("transactions");
        if (transactions == null) {
            transactions = new ArrayList<>();
        }
        transaction.setId(transactions.size() + 1);
        transactions.add(transaction);
        session.setAttribute("transactions", transactions);

        model.addAttribute("message", "finance.add.success");
        return "redirect:/finance/list";
    }

    @GetMapping("/list")
    public String listTransactions(HttpSession session, Model model, HttpServletRequest request) {
        List<Transaction> transactions = (List<Transaction>) session.getAttribute("transactions");
        if (transactions == null) transactions = new ArrayList<>();
        model.addAttribute("transactions", transactions);

        for (Cookie cookie : request.getCookies() == null ? new Cookie[0] : request.getCookies()) {
            if ("username".equals(cookie.getName())) {
                model.addAttribute("username", cookie.getValue());
                break;
            }
        }
        return "finance-list";
    }

    @GetMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable int id, HttpSession session) {
        List<Transaction> transactions = (List<Transaction>) session.getAttribute("transactions");
        if (transactions != null) {
            transactions.removeIf(t -> t.getId() == id);
            session.setAttribute("transactions", transactions);
        }
        return "redirect:/finance/list";
    }
}
