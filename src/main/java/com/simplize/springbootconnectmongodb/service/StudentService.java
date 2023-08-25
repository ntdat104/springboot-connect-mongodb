package com.simplize.springbootconnectmongodb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.simplize.springbootconnectmongodb.model.Student;
import com.simplize.springbootconnectmongodb.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
