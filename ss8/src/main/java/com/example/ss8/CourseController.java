package com.example.ss8;


import com.example.ss8.Model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/bt10")
public class CourseController {

    private List<Course> courses = new ArrayList<>();
    private int courseIdCounter = 1;

    @RequestMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", courses);
        return "/listCourse";
    }

    @RequestMapping("/courses/add")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Course(0, "", ""));
        return "/addCourse";
    }

    @PostMapping("/courses/add")
    public String addCourse(@ModelAttribute Course course) {
        course.setId(courseIdCounter++);
        courses.add(course);
        return "redirect:/bt10";
    }

    @RequestMapping("/courses/delete/{id}")
    public String deleteCourse(@PathVariable int id) {
        courses.removeIf(course -> course.getId() == id);
        return "redirect:/bt10";
    }
}
