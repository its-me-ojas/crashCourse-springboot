package com.ojas.crashCourse.controller;

import com.ojas.crashCourse.model.Student;
import com.ojas.crashCourse.repository.UserRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final UserRepo userRepo;

    public StudentController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/create-student")
    public Student addUser(
            @RequestBody Student student
    ) {
        return userRepo.save(student);
    }
}
