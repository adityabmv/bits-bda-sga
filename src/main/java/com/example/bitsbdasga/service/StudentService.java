package com.example.bitsbdasga.service;

import com.example.bitsbdasga.entity.Student;
import com.example.bitsbdasga.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> findAll() {
        return repo.findAll();
    }

    public Student findById(Long id) {
        return repo.findById(id).orElse(null);
    }


    public void save(Student student) {
        repo.save(student);
    }

}
