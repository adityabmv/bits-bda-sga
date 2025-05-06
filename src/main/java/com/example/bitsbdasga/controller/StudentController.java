package com.example.bitsbdasga.controller;

import com.example.bitsbdasga.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @Autowired private StudentService studentService;

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student_list";
    }

    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/students";
    }
}
