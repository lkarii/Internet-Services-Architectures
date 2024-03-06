package org.example;

import org.example.model.Film;
import org.example.model.Review;
import org.example.service.FilmService;
import org.example.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private FilmService filmService;

    @Autowired
    private ReviewService reviewService;

    @Override
    public void run(String... args) throws Exception {
        Film film1 = new Film.Builder()
                .setName("Inception")
                .setFilmYear(2010)
                .setDirector("Christopher Nolan")
                .setDescription("A thief enters the dreams of others to steal their secrets.")
                .build();

        Review review1 = new Review.Builder()
                .setReviewerName("John Doe")
                .setReviewDate(LocalDate.of(2010, 7, 20))
                .setReviewText("Amazing movie with stunning visuals!")
                .setRating(5)
                .setFilm(film1)
                .build();

        Review review2 = new Review.Builder()
                .setReviewerName("Alice Smith")
                .setReviewDate(LocalDate.of(2010, 8, 15))
                .setReviewText("A thought-provoking film with an intricate plot.")
                .setRating(4)
                .setFilm(film1)
                .build();


        Review review3 = new Review.Builder()
                .setReviewerName("Bob Johnson")
                .setReviewDate(LocalDate.of(2010, 9, 10))
                .setReviewText("Excellent performance by the lead actors and a gripping storyline.")
                .setRating(5)
                .setFilm(film1)
                .build();


        Review review4 = new Review.Builder()
                .setReviewerName("Chris Green")
                .setReviewDate(LocalDate.of(2010, 7, 25))
                .setReviewText("The visual effects were groundbreaking, but the plot was a bit confusing.")
                .setRating(3)
                .setFilm(film1)
                .build();

        filmService.save(film1);
        reviewService.save(review1);
        reviewService.save(review2);
        reviewService.save(review3);
        reviewService.save(review4);
    }
}
