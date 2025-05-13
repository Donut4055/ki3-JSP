package com.example.ss6.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


public class Employee {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String position;
    private LocalDate birthday ;
    private double salary;

    public Employee() {
    }
    public Employee(String name, String email, String phone, String position, LocalDate birthday, double salary) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.position = position;
        this.birthday = birthday;
        this.salary = salary;
    }
    public Employee(int id, String name, String email, String phone, String position, LocalDate birthday, double salary) {
        this(name, email, phone, position, birthday, salary);
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getPosition() {
        return position;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public double getSalary() {
        return salary;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

}
