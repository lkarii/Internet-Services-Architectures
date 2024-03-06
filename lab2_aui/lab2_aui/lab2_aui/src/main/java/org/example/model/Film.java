package org.example.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    private int filmYear;  // Изменено здесь

    @Column(name = "director")
    private String director;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();

    protected Film() {
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFilmYear() {  // Изменено здесь
        return filmYear;
    }

    public void setFilmYear(int filmYear) {  // Изменено здесь
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

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
        review.setFilm(this); // establish the two-way relationship
    }

    public static class Builder {
        private String name;
        private int filmYear;  // Изменено здесь
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
                "name='" + name + '\'' +
                ", filmYear=" + filmYear +  // Изменено здесь
                ", director='" + director + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
