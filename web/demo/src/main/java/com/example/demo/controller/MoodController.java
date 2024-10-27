package com.example.demo.controller;

import com.example.demo.controller.mapper.StudentMapper;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/mood")
@RequiredArgsConstructor
public class MoodController {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Operation(summary = "Save the mood of the student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Save the student mood",
                    content = {@Content(mediaType = "application/json")})})
    @PostMapping()
    public String saveMood(@Valid @RequestBody RequestDto request) {
        Student student = studentMapper.toStudent(request);
        studentRepository.save(student);
        return "Your request: %s has been saved".formatted(request);
    }

    @Operation(summary = "Get the mood of the all students")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The list of students with their mood",
                    content = { @Content(mediaType = "application/json")})})
    @GetMapping()
    public List<String> getAllMoods() {
        return studentRepository.findAll().stream()
                .map(student -> student.getName() + " has " + student.getMood() + " mood")
                .toList();
    }
}
