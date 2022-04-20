package com.adafpc.letscode.harrypotter.controller;

import com.adafpc.letscode.harrypotter.dto.StudentRequest;
import com.adafpc.letscode.harrypotter.dto.StudentResponse;
import com.adafpc.letscode.harrypotter.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody @Valid StudentRequest studentRequest, HttpServletResponse response){
        response.addHeader("Location", String.format("/api/students/%d", service.addStudent(studentRequest)) );

    }

    @GetMapping("/{id}")
    public StudentResponse getStudent(@PathVariable Integer id){
        return service.getStudent(id);
    }
}
