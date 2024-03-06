package org.example;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode

public class Movie implements Serializable{
    private String name;
    private int year;
    private String director;
    private String description;
    private List<Review> reviews;

    public void addReview(Review review) {
        this.reviews.add(review);
        review.setMovie(this);
    }
}
