package org.example.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "films")
public class Film implements Serializable {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "film_year")
    private int filmYear;

    @Column(name = "director")
    private String director;

    @Column(name = "description")
    private String description;

    // Конструкторы, геттеры и сеттеры
    public Film() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFilmYear() {
        return filmYear;
    }

    public void setFilmYear(int filmYear) {
        this.filmYear = filmYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Builder {
        private String name;
        private int filmYear;
        private String director;
        private String description;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setFilmYear(int filmYear) {
            this.filmYear = filmYear;
            return this;
        }

        public Builder setDirector(String director) {
            this.director = director;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Film build() {
            return new Film(this);
        }
    }

    private Film(Builder builder) {
        this.name = builder.name;
        this.filmYear = builder.filmYear;
        this.director = builder.director;
        this.description = builder.description;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", filmYear=" + filmYear +  // Изменено здесь
                ", director='" + director + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
