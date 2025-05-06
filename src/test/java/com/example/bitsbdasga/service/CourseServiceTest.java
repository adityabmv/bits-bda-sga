package com.example.bitsbdasga.service;

import com.example.bitsbdasga.entity.Course;
import com.example.bitsbdasga.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    private CourseService courseService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        courseService = new CourseService(courseRepository);
    }

    @Test
    void testFindAllReturnsCourses() {
        List<Course> courses = List.of(
                new Course("Java", "Java Basics"),
                new Course("Spring", "Spring Boot Intro")
        );
        when(courseRepository.findAll()).thenReturn(courses);

        List<Course> result = courseService.findAll();
        assertEquals(2, result.size());
    }

    @Test
    void testFindByIdReturnsCourse() {
        Course course = new Course("AI", "Artificial Intelligence");
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        Course result = courseService.findById(1L);
        assertNotNull(result);
        assertEquals("AI", result.getTitle());
    }

    @Test
    void testFindByIdReturnsNull() {
        when(courseRepository.findById(5L)).thenReturn(Optional.empty());
        assertNull(courseService.findById(5L));
    }

    @Test
    void testSaveDelegatesToRepo() {
        Course course = new Course("Math", "Algebra");
        courseService.save(course);

        verify(courseRepository, times(1)).save(course);
    }
}
