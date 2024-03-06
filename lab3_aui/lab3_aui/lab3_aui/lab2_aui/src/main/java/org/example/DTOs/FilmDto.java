package org.example.DTOs;

import java.util.UUID;

public class FilmDto {
    private UUID id;
    private String name;
    private int filmYear;
    private String director;
    private String description;

    // Getters
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFilmYear() {
        return filmYear;
    }

    public String getDirector() {
        return director;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setId(UUID id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setFilmYear(int filmYear) {
        this.filmYear = filmYear;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
