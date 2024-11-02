package com.example.demo.controller.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record FilmResponseDto (

        @Schema(description = "The title of the film")
        String title,

        @Schema(description = "The genre of the film")
        Genre genre,

        @JsonProperty(value = "student")
        String studentName
) { }
