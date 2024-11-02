package com.example.demo.controller.mapper;

import com.example.demo.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toStudent(StudentRequestDto dto) {
        Student student = new Student();
        student.setName(dto.name());
        student.setMood(dto.mood());
        return student;
    }
}
