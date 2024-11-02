package com.example.demo.controller;

import com.example.demo.controller.mapper.StudentRequestDto;
import com.example.demo.controller.mapper.StudentResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RequestMapping("/student")
public interface StudentApi {

    @Operation(summary = "Save the student with its mood")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The student with its mood was saved",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudentResponseDto.class))})})
    @PostMapping()
    ResponseEntity<StudentResponseDto> saveStudent(@Valid @RequestBody StudentRequestDto request);

    @Operation(summary = "Get the mood of the all students")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The list of students with their mood",
                    content = { @Content(mediaType = "application/json")})})
    @GetMapping("/moods")
    List<String> getAllMoods();

    @Operation(summary = "Get the list of all students")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The list of students with their id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudentResponseDto.class))})})
    @GetMapping()
    ResponseEntity<List<StudentResponseDto>> getAllStudents();
}
