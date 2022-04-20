package com.adafpc.letscode.harrypotter.service;

import com.adafpc.letscode.harrypotter.dto.StudentRequest;
import com.adafpc.letscode.harrypotter.dto.StudentResponse;
import com.adafpc.letscode.harrypotter.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class StudentService {

    private final List<Student>students = new ArrayList<>();
    private final AtomicInteger counter = new AtomicInteger(1);

    @Autowired
    SortingHatService sortingHatService;

    public Integer addStudent(StudentRequest studentRequest){
        Student student = Student.builder()
                .id(counter.getAndIncrement())
                .name(studentRequest.getName())
                .grade(studentRequest.getGrade())
                .house(sortingHatService.getHouseId())
                .build();

        students.add(student);
        log.info("recebido studentRequest {}", studentRequest);

        return student.getId();
    }

    public StudentResponse getStudent(Integer id){

       return students
                .stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
               .map(student -> StudentResponse.builder()
                       .id(student.getId())
                       .name(student.getName())
                       .grade(student.getGrade())
                       .house(sortingHatService.getHouseDetails(student.getHouse()))
                       .build()
               )
                .orElseThrow();


    }
}
