package com.example.demo.controller.mapper;

import io.swagger.v3.oas.annotations.media.Schema;

public record StudentResponseDto (

    @Schema(description = "The id of the student")
    Long id,

    @Schema(description = "The name of the student")
    String name
    ) {
}
