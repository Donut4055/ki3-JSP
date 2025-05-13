package com.example.ss6.Controller;


import com.example.ss6.Model.Employee;
import com.example.ss6.Service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/employee")
public class EmployeeController extends HttpServlet {
    private final EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null || action.equals("list")) {
            List<Employee> employees = employeeService.findAll();
            req.setAttribute("employees", employees);
            req.getRequestDispatcher("views/bt4/employeeList.jsp").forward(req, resp);
        } else if (action.equals("search")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Employee employee = employeeService.findById(id);
            req.setAttribute("employees", employee != null ? List.of(employee) : List.of());
            req.getRequestDispatcher("views/bt4/employeeList.jsp").forward(req, resp);
        } else if (action.equals("edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Employee employee = employeeService.findById(id);
            if (employee != null) {
                req.setAttribute("employee", employee);
                req.getRequestDispatcher("views/bt4/updateEmployee.jsp").forward(req, resp);
            } else {
                req.setAttribute("error", "Không tìm thấy nhân viên với ID: " + id);
                req.getRequestDispatcher("views/bt4/employeeList.jsp").forward(req, resp);
            }
        } else if (action.equals("add")) {
            req.getRequestDispatcher("views/bt4/addEmployee.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            if (action.equals("add")) {
                Employee employee = new Employee();
                employee.setName(req.getParameter("name"));
                employee.setBirthday(LocalDate.parse(req.getParameter("birthday")));
                employee.setPhone(req.getParameter("phone"));
                employee.setSalary(Double.parseDouble(req.getParameter("salary")));
                employee.setPosition(req.getParameter("position"));
                employeeService.save(employee);
                req.setAttribute("message", "Thêm nhân viên thành công!");
                req.getRequestDispatcher("views/bt4/employeeList.jsp").forward(req, resp);
            } else if (action.equals("update")) {
                Employee employee = new Employee();
                employee.setId(Integer.parseInt(req.getParameter("id")));
                employee.setName(req.getParameter("name"));
                employee.setBirthday(LocalDate.parse(req.getParameter("birthday")));
                employee.setPhone(req.getParameter("phone"));
                employee.setSalary(Double.parseDouble(req.getParameter("salary")));
                employee.setPosition(req.getParameter("position"));
                employeeService.update(employee);
                req.setAttribute("message", "Cập nhật thông tin nhân viên thành công!");
                req.getRequestDispatcher("views/bt4/employeeList.jsp").forward(req, resp);
            } else if (action.equals("delete")) {
                int id = Integer.parseInt(req.getParameter("id"));
                employeeService.delete(id);
                req.setAttribute("message", "Xóa nhân viên thành công!");
                req.getRequestDispatcher("views/bt4/employeeList.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("error", "Đã xảy ra lỗi: " + e.getMessage());
            req.getRequestDispatcher("views/bt4/employeeList.jsp").forward(req, resp);
        }
    }
}
