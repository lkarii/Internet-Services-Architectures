package org.example.service;

import org.example.model.Film;
import org.example.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    public Film findById(UUID id) {
        return filmRepository.findById(id).orElse(null);
    }

    public Film save(Film film) {
        return filmRepository.save(film);
    }

    public void deleteById(UUID id) {
        restTemplate.delete("http://localhost:8082/reviews/film/{id}", id);
        filmRepository.deleteById(id);
    }

}
