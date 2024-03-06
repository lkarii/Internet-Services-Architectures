package org.example.DTOs;

import java.time.LocalDate;
import java.util.UUID;

public class ReviewDto {
    private String reviewerName;
    private LocalDate reviewDate;
    private String reviewText;
    private int rating;
    private UUID filmId; // ID фильма, к которому относится рецензия

    // Геттеры
    public String getReviewerName() {
        return reviewerName;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public String getReviewText() {
        return reviewText;
    }

    public int getRating() {
        return rating;
    }

    public UUID getFilmId() {
        return filmId;
    }

    // Сеттеры
    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setFilmId(UUID filmId) {
        this.filmId = filmId;
    }
}
