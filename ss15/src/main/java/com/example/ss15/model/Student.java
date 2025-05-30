package com.example.ss15.model;

public class Student {
    private String studentId;
    private String name;
    private int age;
    private String studentClass;
    private String email;
    private String address;
    private String phone;

    public Student() {}

    public Student(String studentId, String name, int age, String studentClass, String email, String address, String phone) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.studentClass = studentClass;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getStudentClass() { return studentClass; }
    public void setStudentClass(String studentClass) { this.studentClass = studentClass; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}

