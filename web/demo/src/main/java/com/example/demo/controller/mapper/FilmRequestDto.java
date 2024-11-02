package com.example.demo.controller.mapper;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FilmRequestDto(

        @NotBlank
        @Schema(description = "Title of the film")
        String title,

        @NotBlank
        @Schema(description = "Genre of the film",
                allowableValues = {"ACTION", "ADVENTURE", "COMEDY", "CRIME", "DRAMA",
                        "FANTASY", "HORROR", "ROMANCE", "SCIENCE_FICTION", "THRILLER"})
        String genre,

        @NotNull(message = "student id must not be null")
        @Schema(description = "The id of the student")
        Long studentId) {
}
