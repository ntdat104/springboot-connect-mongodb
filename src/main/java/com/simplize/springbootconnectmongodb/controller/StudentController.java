package com.simplize.springbootconnectmongodb.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplize.springbootconnectmongodb.model.Student;
import com.simplize.springbootconnectmongodb.service.StudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

}
