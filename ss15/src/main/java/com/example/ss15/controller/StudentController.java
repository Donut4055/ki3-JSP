package com.example.ss15.controller;


import com.example.ss15.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {

    @GetMapping("/students")
    public String listStudents(Model model) {
        List<Student> students = Arrays.asList(
                new Student("SV001", "Nguyễn Văn A", 20, "CTK42", "a@example.com", "Hà Nội", "0901234567"),
                new Student("SV002", "Trần Thị B", 21, "CTK42", "b@example.com", "Hải Phòng", "0912345678"),
                new Student("SV003", "Lê Văn C", 22, "CTK41", "c@example.com", "Đà Nẵng", "0923456789")
        );
        model.addAttribute("students", students);
        return "student-list";
    }
}

