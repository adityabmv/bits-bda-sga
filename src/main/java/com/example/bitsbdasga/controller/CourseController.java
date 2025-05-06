package com.example.bitsbdasga.controller;

import com.example.bitsbdasga.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {

    @Autowired private CourseService courseService;

    @GetMapping("/courses")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "course_list";
    }

    @GetMapping("/courses/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        var course = courseService.findById(id);
        if (course == null) {
            return "redirect:/courses";
        }
        model.addAttribute("course", course);
        return "course_edit";
    }

    @PostMapping("/courses/update/{id}")
    public String updateCourse(@PathVariable Long id,
                               @RequestParam String title,
                               @RequestParam String description) {
        var course = courseService.findById(id);
        if (course != null) {
            course.setTitle(title);
            course.setDescription(description);
            courseService.save(course);
        }
        return "redirect:/courses";
    }

    @GetMapping("/courses/new")
    public String showCreateForm(Model model) {
        model.addAttribute("course", new com.example.bitsbdasga.entity.Course());
        return "course_form";
    }

    @PostMapping("/courses")
    public String saveCourse(@ModelAttribute("course") com.example.bitsbdasga.entity.Course course) {
        courseService.save(course);
        return "redirect:/courses";
    }


}
