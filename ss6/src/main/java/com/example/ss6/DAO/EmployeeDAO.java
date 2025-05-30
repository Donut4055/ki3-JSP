package com.example.ss6.DAO;

import Util.ConnectionDB;
import com.example.ss6.Model.Employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement callSt = conn.prepareCall("{call findAllEmployee()}")) {
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setBirthday(rs.getDate("birthday").toLocalDate());
                employee.setPhone(rs.getString("phone"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setPosition(rs.getString("position"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all employees", e);
        }
        return employees;
    }

    public boolean save(Employee employee) {
        if (employee.getName() == null || employee.getName().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be empty");
        }
        if (employee.getPhone() == null || employee.getPhone().isEmpty()) {
            throw new IllegalArgumentException("Employee phone cannot be empty");
        }
        if (employee.getSalary() <= 0) {
            throw new IllegalArgumentException("Employee salary must be greater than zero");
        }
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement callSt = conn.prepareCall("{call add_employee(?,?,?,?,?)}")) {
            callSt.setString(1, employee.getName());
            callSt.setDate(2, java.sql.Date.valueOf(employee.getBirthday()));
            callSt.setString(3, employee.getPhone());
            callSt.setDouble(4, employee.getSalary());
            callSt.setString(5, employee.getPosition());
            int rowsAffected = callSt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error saving employee", e);
        }
    }

    public Employee findById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid employee ID");
        }
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement callSt = conn.prepareCall("{call findEmployeeById(?)}")) {
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setBirthday(rs.getDate("birthday").toLocalDate());
                employee.setPhone(rs.getString("phone"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setPosition(rs.getString("position"));
                return employee;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error finding employee by ID", e);
        }
    }

    public boolean update(Employee employee) {
        if (employee.getId() <= 0) {
            throw new IllegalArgumentException("Invalid employee ID");
        }
        if (employee.getName() == null || employee.getName().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be empty");
        }
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement callSt = conn.prepareCall("{call updateEmployeeById(?,?,?,?,?,?)}")) {
            callSt.setInt(1, employee.getId());
            callSt.setString(2, employee.getName());
            callSt.setDate(3, java.sql.Date.valueOf(employee.getBirthday()));
            callSt.setString(4, employee.getPhone());
            callSt.setDouble(5, employee.getSalary());
            callSt.setString(6, employee.getPosition());
            int rowsAffected = callSt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating employee", e);
        }
    }

    public boolean delete(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid employee ID");
        }
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement callSt = conn.prepareCall("{call deleteEmployeeById(?)}")) {
            callSt.setInt(1, id);
            int rowsAffected = callSt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting employee", e);
        }
    }

}
