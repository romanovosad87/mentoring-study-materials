package com.example.demo.controller;

import com.example.demo.controller.mapper.StudentRequestDto;
import com.example.demo.controller.mapper.StudentMapper;
import com.example.demo.controller.mapper.StudentResponseDto;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController implements StudentApi {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public ResponseEntity<StudentResponseDto> saveStudent(@Valid @RequestBody StudentRequestDto request) {
        Student student = studentMapper.toStudent(request);
        Student savedStudent = studentRepository.save(student);
        return new ResponseEntity<>(new StudentResponseDto(savedStudent.getId(), savedStudent.getName()),
                HttpStatus.CREATED);
    }

    @Override
    public List<String> getAllMoods() {
        return studentRepository.findAll().stream()
                .map(student -> student.getName() + " has " + student.getMood() + " mood")
                .toList();
    }

    @Override
    public ResponseEntity<List<StudentResponseDto>> getAllStudents() {
        return ResponseEntity.ok(studentRepository.findAllBy(StudentResponseDto.class));
    }
}
