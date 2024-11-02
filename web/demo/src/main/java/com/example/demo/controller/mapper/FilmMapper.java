package com.example.demo.controller.mapper;

import com.example.demo.exception.GenreNotFoundException;
import com.example.demo.model.Film;
import org.springframework.stereotype.Component;

@Component
public class FilmMapper {

    public Film toFilm(FilmRequestDto dto) {
        Film film = new Film();
        try {
            Genre genre = Genre.valueOf(dto.genre());
            film.setGenre(genre);
        } catch (IllegalArgumentException e) {
            throw new GenreNotFoundException(("Could not find the genre with name: %s. "
                    + "Please refer to Open API documentation")
                    .formatted(dto.genre()));
        }
        film.setTitle(dto.title());
        return film;
    }
}
