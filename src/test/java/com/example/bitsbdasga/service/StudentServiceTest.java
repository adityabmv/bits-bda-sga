package com.example.bitsbdasga.service;

import com.example.bitsbdasga.entity.Student;
import com.example.bitsbdasga.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    private StudentService studentService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        studentService = new StudentService(studentRepository);
    }

    @Test
    void testFindAllReturnsList() {
        List<Student> mockList = List.of(
                new Student("Alice", "alice@example.com"),
                new Student("Bob", "bob@example.com")
        );
        when(studentRepository.findAll()).thenReturn(mockList);

        List<Student> result = studentService.findAll();
        assertEquals(2, result.size());
    }

    @Test
    void testFindByIdFound() {
        Student student = new Student("John", "john@example.com");
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Student result = studentService.findById(1L);
        assertNotNull(result);
        assertEquals("John", result.getName());
    }

    @Test
    void testFindByIdNotFound() {
        when(studentRepository.findById(999L)).thenReturn(Optional.empty());

        Student result = studentService.findById(999L);
        assertNull(result);
    }

    @Test
    void testSaveCallsRepository() {
        Student student = new Student("Charlie", "charlie@example.com");
        studentService.save(student);

        verify(studentRepository, times(1)).save(student);
    }
}
