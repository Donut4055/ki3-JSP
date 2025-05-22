package com.example.ss11.bt5;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.transform.Source;

public class RegisterForm implements Source {

    @NotBlank(message = "Tên bắt buộc", groups = {AdminGroup.class, UserGroup.class})
    private String name;

    @NotBlank(message = "Email bắt buộc", groups = {AdminGroup.class, UserGroup.class})
    @Email(message = "Email không hợp lệ", groups = {AdminGroup.class, UserGroup.class})
    private String email;

    @NotNull(message = "Vai trò bắt buộc", groups = {AdminGroup.class, UserGroup.class})
    private String role;

    @Min(value = 18, message = "Tuổi phải >= 18", groups = UserGroup.class)
    @NotNull(message = "Tuổi bắt buộc", groups = UserGroup.class)
    private Integer age;

    @NotBlank(message = "Mã admin bắt buộc", groups = AdminGroup.class)
    private String adminCode;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public Integer getAge() {
        return age;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    @Override
    public void setSystemId(String systemId) {

    }

    @Override
    public String getSystemId() {
        return "";
    }
}
