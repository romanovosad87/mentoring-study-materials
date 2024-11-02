package com.example.demo.controller.mapper;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record StudentRequestDto(

        @Schema(description = "Name of the Student, must be unique")
        @NotBlank
        String name,

        @NotBlank
        String mood) {
    @Override
    public String toString() {
         return "name - '%s', mood - '%s'".formatted(name, mood) ;
    }
}
