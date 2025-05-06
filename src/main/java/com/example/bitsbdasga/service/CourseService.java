package com.example.bitsbdasga.service;

import com.example.bitsbdasga.entity.Course;
import com.example.bitsbdasga.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    public List<Course> findAll() {
        return repo.findAll();
    }

    public List<Course> findCoursesByIds(List<Long> ids) {
        return repo.findAllById(ids);
    }

    public Course findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Course course) {
        repo.save(course);
    }

}
