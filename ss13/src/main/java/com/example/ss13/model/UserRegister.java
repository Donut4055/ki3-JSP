package com.example.ss13.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserRegister {
    @NotBlank(message = "{register.username.required}")
    private String username;

    @NotBlank(message = "{register.password.required}")
    private String password;

    @NotBlank(message = "{register.confirmPassword.required}")
    private String confirmPassword;

    @NotBlank(message = "{register.email.required}")
    @Email(message = "{register.email.invalid}")
    private String email;


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

