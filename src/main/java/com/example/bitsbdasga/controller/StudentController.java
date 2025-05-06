package com.example.bitsbdasga.controller;

import com.example.bitsbdasga.entity.Course;
import com.example.bitsbdasga.service.CourseService;
import com.example.bitsbdasga.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    @Autowired private StudentService studentService;
    @Autowired private CourseService courseService;

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student_list";
    }

    @GetMapping("/students/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new com.example.bitsbdasga.entity.Student());
        model.addAttribute("courses", courseService.findAll());
        return "student_form";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") com.example.bitsbdasga.entity.Student student,
                              @RequestParam(value = "courseIds", required = false) List<Long> courseIds) {
        if (courseIds != null) {
            List<Course> selectedCourses = courseService.findCoursesByIds(courseIds);
            student.setCourses(selectedCourses);
        }
        studentService.save(student);
        return "redirect:/students";
    }


    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/students";
    }

}
