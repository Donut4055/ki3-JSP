package com.example.ss6.Service;

import com.example.ss6.DAO.EmployeeDAO;
import com.example.ss6.Model.Employee;

import java.util.List;

public class EmployeeService {
    private final EmployeeDAO employeeDao = new EmployeeDAO();


    public List<Employee> findAll() {
        return employeeDao.findAll();
    }


    public boolean save(Employee employee) {
        return employeeDao.save(employee);
    }


    public Employee findById(int id) {
        return employeeDao.findById(id);
    }


    public boolean update(Employee employee) {
        return employeeDao.update(employee);
    }


    public boolean delete(int id) {
        return employeeDao.delete(id);
    }
}
