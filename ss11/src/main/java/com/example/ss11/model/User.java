package com.example.ss11.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotBlank(message = "Name không được để trống")
    @Size(min = 2, max = 30, message = "Name phải từ 2 đến 30 ký tự")
    private String name;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;

    @NotBlank(message = "Phone không được để trống")
    @Size(min = 2, max = 30, message = "Phone phải từ 2 đến 30 ký tự")
    private String phone;

    @NotBlank(message = "Password không được để trống")
    @Size(min = 2, max = 30, message = "Password phải từ 2 đến 30 ký tự")
    private String password;

    @NotNull(message = "Status không được để trống")
    private Boolean status;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
}
