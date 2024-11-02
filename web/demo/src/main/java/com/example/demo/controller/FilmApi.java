package com.example.demo.controller;

import com.example.demo.controller.mapper.FilmRequestDto;
import com.example.demo.controller.mapper.FilmResponseDto;
import com.example.demo.controller.mapper.StudentResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

public interface FilmApi {

    @Operation(summary = "Save the last seen film")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The film was saved",
                    content = {@Content(mediaType = "application/json")})})
    @PutMapping
    ResponseEntity<FilmResponseDto> saveFilm(@Valid @RequestBody FilmRequestDto dto);

    @Operation(summary = "Get the list of all films")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all films",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = FilmResponseDto.class))})})
    @GetMapping
    ResponseEntity<List<FilmResponseDto>> getAllFilms();
}
