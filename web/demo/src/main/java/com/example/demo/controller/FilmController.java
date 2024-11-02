package com.example.demo.controller;

import com.example.demo.controller.mapper.FilmMapper;
import com.example.demo.controller.mapper.FilmRequestDto;
import com.example.demo.controller.mapper.FilmResponseDto;
import com.example.demo.model.Film;
import com.example.demo.model.Student;
import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/film")
@RequiredArgsConstructor
public class FilmController implements FilmApi {
    private final FilmRepository filmRepository;
    private final StudentRepository studentRepository;
    private final FilmMapper filmMapper;

    @Override
    public ResponseEntity<FilmResponseDto> saveFilm(FilmRequestDto dto) {
        Student studentReference = studentRepository.getReferenceById(dto.studentId());
        Film film = filmMapper.toFilm(dto);
        film.setStudent(studentReference);
        Film savedFilm = filmRepository.save(film);
        return new ResponseEntity<>(new FilmResponseDto(savedFilm.getTitle(), savedFilm.getGenre(), savedFilm.getStudent().getName()),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<FilmResponseDto>> getAllFilms() {
        return ResponseEntity.ok(filmRepository.findAllBy(FilmResponseDto.class));
    }
}
