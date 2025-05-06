package com.example.bitsbdasga.repository;

import com.example.bitsbdasga.entity.Student;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
