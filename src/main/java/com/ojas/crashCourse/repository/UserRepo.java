package com.ojas.crashCourse.repository;

import com.ojas.crashCourse.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Student, Integer> {
}
