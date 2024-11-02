package com.example.demo.repository;

import com.example.demo.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
    <T> List<T> findAllBy(Class<T> type);
}
