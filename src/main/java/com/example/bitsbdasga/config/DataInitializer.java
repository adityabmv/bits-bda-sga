package com.example.bitsbdasga.config;

import com.example.bitsbdasga.entity.Course;
import com.example.bitsbdasga.entity.Student;
import com.example.bitsbdasga.repository.CourseRepository;
import com.example.bitsbdasga.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataInitializer implements CommandLineRunner {

    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public DataInitializer(StudentRepository studentRepo, CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (studentRepo.count() == 0 && courseRepo.count() == 0) {
            List<Course> courses = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                Course course = new Course("Course " + i, "Description for course " + i);
                courses.add(courseRepo.save(course));
            }

            for (int i = 1; i <= 10; i++) {
                Student student = new Student("Student " + i, "student" + i + "@example.com");
                Collections.shuffle(courses);
                student.setCourses(courses.subList(0, new Random().nextInt(3) + 1)); // assign 1-3 courses
                studentRepo.save(student);
            }

            System.out.println("🌱 Sample data initialized!");
        } else {
            System.out.println("📦 Data already exists — skipping initialization.");
        }
    }
}
