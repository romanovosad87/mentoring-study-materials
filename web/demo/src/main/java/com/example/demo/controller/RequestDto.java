package com.example.demo.controller;

import jakarta.validation.constraints.NotBlank;

public record RequestDto(@NotBlank String name, @NotBlank String mood) {
    @Override
    public String toString() {
         return "name - '%s', mood - '%s'".formatted(name, mood) ;
    }
}
