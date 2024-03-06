package org.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "reviews")
public class Review implements Serializable {

    @Column(name = "film_id")
    private UUID filmId;

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "reviewer_name")
    private String reviewerName;

    @Column(name = "review_date")
    private LocalDate reviewDate;

    @Column(name = "review_text")
    private String reviewText;

    @Column(name = "rating")
    private int rating;

    protected Review() {
    }
    // Getters and setters

    public UUID getId() {
        return this.id;
    }
    public UUID getFilmId() {
        return filmId;
    }

    public void setFilmId(UUID filmId) {
        this.filmId = filmId;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public static class Builder {
        private String reviewerName;
        private LocalDate reviewDate;
        private String reviewText;
        private int rating;

        public Builder setReviewerName(String reviewerName) {
            this.reviewerName = reviewerName;
            return this;
        }

        public Builder setReviewDate(LocalDate reviewDate) {
            this.reviewDate = reviewDate;
            return this;
        }

        public Builder setReviewText(String reviewText) {
            this.reviewText = reviewText;
            return this;
        }

        public Builder setRating(int rating) {
            if (rating < 1 || rating > 5) {
                throw new IllegalArgumentException("Rating should be between 1 and 5.");
            }
            this.rating = rating;
            return this;
        }


        public Review build() {
            return new Review(this);
        }
    }

    private Review(Builder builder) {
        this.reviewerName = builder.reviewerName;
        this.reviewDate = builder.reviewDate;
        this.reviewText = builder.reviewText;
        this.rating = builder.rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewerName='" + reviewerName + '\'' +
                ", reviewDate=" + reviewDate +
                ", reviewText='" + reviewText + '\'' +
                ", rating=" + rating +
                '}';
    }

}
