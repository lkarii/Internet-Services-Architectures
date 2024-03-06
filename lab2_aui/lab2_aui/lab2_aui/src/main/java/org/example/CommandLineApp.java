package org.example;

import org.example.model.Film;
import org.example.model.Review;
import org.example.service.FilmService;
import org.example.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Component
public class CommandLineApp implements CommandLineRunner {

    @Autowired
    private FilmService filmService;

    @Autowired
    private ReviewService reviewService;

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {
        boolean running = true;
        while (running) {
            System.out.println("Commands: list-films, add-film, delete-film, list-reviews, add-review, delete-review, exit");
            String command = scanner.nextLine();

            switch (command) {
                case "list-films":
                    listFilms();
                    break;
                case "add-film":
                    addFilm();
                    break;
                case "delete-film":
                    deleteFilm();
                case "list-reviews":
                    listReviews();
                    break;
                case "add-review":
                    addReview();
                    break;
                case "delete-review":
                    deleteReview();
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Unknown command.");
            }
        }
    }

    private void listFilms() {
        List<Film> films = filmService.findAll();
        if (films.isEmpty()) {
            System.out.println("No films available.");
        } else {
            films.forEach(film -> System.out.println(film.toString()));
        }
    }

    private void addFilm() {
        System.out.println("Enter film name:");
        String name = scanner.nextLine();

        System.out.println("Enter film year:");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter director name:");
        String director = scanner.nextLine();

        System.out.println("Enter description:");
        String description = scanner.nextLine();

        Film film = new Film.Builder()
                .setName(name)
                .setFilmYear(year)
                .setDirector(director)
                .setDescription(description)
                .build();

        filmService.save(film);
        System.out.println("Film added: " + film.toString());
    }

    private void deleteFilm() {
        System.out.println("Enter film ID to delete:");
        String idString = scanner.nextLine();
        UUID id;
        try {
            id = UUID.fromString(idString);
            filmService.deleteById(id);
            System.out.println("Film deleted.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid UUID format.");
        }
    }

    private void listReviews() {
        List<Review> reviews = reviewService.findAll(); // Implement findAll method in ReviewService
        if (reviews.isEmpty()) {
            System.out.println("No reviews available.");
        } else {
            reviews.forEach(review -> System.out.println(review.toString()));
        }
    }

    private void addReview() {
        System.out.println("Enter film ID for the review:");
        UUID filmId = UUID.fromString(scanner.nextLine());
        Film film = filmService.findById(filmId);

        if (film == null) {
            System.out.println("Film not found.");
            return;
        }

        System.out.println("Enter reviewer name:");
        String reviewerName = scanner.nextLine();

        System.out.println("Enter review date (YYYY-MM-DD):");
        LocalDate reviewDate = LocalDate.parse(scanner.nextLine());

        System.out.println("Enter review text:");
        String reviewText = scanner.nextLine();

        System.out.println("Enter rating (1-5):");
        int rating = Integer.parseInt(scanner.nextLine());

        Review review = new Review.Builder()
                .setReviewerName(reviewerName)
                .setReviewDate(reviewDate)
                .setReviewText(reviewText)
                .setRating(rating)
                .setFilm(film)
                .build();

        reviewService.save(review);
        System.out.println("Review added: " + review.toString());
    }

    private void deleteReview() {
        System.out.println("Enter review ID to delete:");
        UUID reviewId = UUID.fromString(scanner.nextLine());
        reviewService.deleteById(reviewId);
        System.out.println("Review deleted.");
    }
}
