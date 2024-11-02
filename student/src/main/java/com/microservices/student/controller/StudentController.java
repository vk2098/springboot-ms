package com.microservices.student.controller;

import com.microservices.student.request.CreateStudentRequest;
import com.microservices.student.response.StudentResponse;
import com.microservices.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/student")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public StudentResponse createStudent (@RequestBody CreateStudentRequest createStudentRequest) {
        return studentService.createStudent(createStudentRequest);
    }

    @GetMapping("getById/{id}")
    public StudentResponse getById (@PathVariable long id) {
        return studentService.getById(id);
    }

}
