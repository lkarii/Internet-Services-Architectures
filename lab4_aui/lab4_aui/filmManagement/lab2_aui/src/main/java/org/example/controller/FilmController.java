package org.example.controller;

import org.example.DTOs.FilmDto;
import org.example.model.Film;
import org.example.service.FilmService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @Autowired
    private ModelMapper modelMapper; // Для преобразования между Film и FilmDto

    @PostMapping
    public ResponseEntity<FilmDto> createFilm(@RequestBody FilmDto filmDto) {
        Film film = modelMapper.map(filmDto, Film.class);
        film = filmService.save(film);
        FilmDto responseDto = modelMapper.map(film, FilmDto.class);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmDto> getFilm(@PathVariable UUID id) {
        Film film = filmService.findById(id);
        if (film == null) {
            return ResponseEntity.notFound().build();
        }
        FilmDto filmDto = modelMapper.map(film, FilmDto.class);
        return ResponseEntity.ok(filmDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmDto> updateFilm(@PathVariable UUID id, @RequestBody FilmDto filmDto) {

        Film existingFilm = filmService.findById(id);
        if (existingFilm == null) {
            return ResponseEntity.notFound().build();
        }

        modelMapper.map(filmDto, existingFilm);
        Film updatedFilm = filmService.save(existingFilm);
        FilmDto responseDto = modelMapper.map(updatedFilm, FilmDto.class);
        return ResponseEntity.ok(responseDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable UUID id) {
        filmService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<FilmDto>> getAllFilms() {
        List<Film> films = filmService.findAll();
        List<FilmDto> filmDtos = films.stream()
                .map(film -> modelMapper.map(film, FilmDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(filmDtos);
    }
}
