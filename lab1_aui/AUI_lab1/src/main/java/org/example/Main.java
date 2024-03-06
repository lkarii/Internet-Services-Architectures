package org.example;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Task 2: Create movies and reviews
        printSeparator("Task 2: Films and Reviews");
        List<Movie> movies = new ArrayList<>();

        Review review1 = Review.builder()
                .reviewerName("John")
                .reviewDate(LocalDate.now())
                .reviewContent("Great movie!")
                .rating(5)
                .build();

        Review review2 = Review.builder()
                .reviewerName("Jane")
                .reviewDate(LocalDate.now())
                .reviewContent("Not bad.")
                .rating(3)
                .build();

        Review review3 = Review.builder()
                .reviewerName("Marta")
                .reviewDate(LocalDate.now())
                .reviewContent("A really good movie!")
                .rating(3)
                .build();

        Review review4 = Review.builder()
                .reviewerName("Julia")
                .reviewDate(LocalDate.now())
                .reviewContent("The best for all the times!")
                .rating(5)
                .build();

        Movie movie = Movie.builder()
                .name("Inception")
                .year(2010)
                .director("Christopher Nolan")
                .description("A thief enters dreams.")
                .reviews(new ArrayList<>(Arrays.asList(review1, review2, review3, review4)))
                .build();

        movies.add(movie);

        movie.getReviews().forEach(review -> review.setMovie(movie));

        System.out.println(movie);
        movie.getReviews().forEach(System.out::println);

        // Task 3: Create a Set collection of all reviews
        printSeparator("Task 3: All Reviews Set");
        Set<Review> reviewSet = movies.stream()
                .flatMap(m -> m.getReviews().stream())
                .collect(Collectors.toSet());
        reviewSet.forEach(System.out::println);

        // Task 4: Filter and sort the reviews
        printSeparator("Task 4: Filtered and Sorted Reviews");
        List<Review> filteredAndSortedReviews = reviewSet.stream()
                .filter(r -> r.getRating() == 5)
                .sorted(Comparator.comparing(Review::getReviewDate))
                .collect(Collectors.toList());
        filteredAndSortedReviews.forEach(System.out::println);

        // Task 5: Transform reviews to DTOs and sort them
        printSeparator("Task 5: Transformed and Sorted DTOs");
        List<ReviewDto> reviewDtos = reviewSet.stream()
                .map(review -> ReviewDto.builder()
                        .reviewerName(review.getReviewerName())
                        .reviewDate(review.getReviewDate())
                        .reviewContent(review.getReviewContent())
                        .rating(review.getRating())
                        .movieName(review.getMovie().getName())
                        .build())
                .sorted(Comparator.comparing(ReviewDto::getReviewerName))
                .collect(Collectors.toList());
        reviewDtos.forEach(System.out::println);

        // Task 6: Serialize and Deserialize
        printSeparator("Task 6: Serialized and Deserialized Films");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("movies.dat"))) {
            oos.writeObject(movies);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Movie> deserializedMovies;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("movies.dat"))) {
            deserializedMovies = (List<Movie>) ois.readObject();
            deserializedMovies.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Task 7: Parallel processing using custom thread pool
        printSeparator("Task 7: Parallel Processing with Custom ThreadPool");
        ForkJoinPool customThreadPool = new ForkJoinPool(4);
        try {
            customThreadPool.submit(() ->
                    movies.parallelStream().forEach(m -> {
                        m.getReviews().forEach(review -> {
                            System.out.println("Processing review by: " + review.getReviewerName());
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
                    })
            ).get();
        } finally {
            customThreadPool.shutdown();
        }
    }
    private static void printSeparator(String taskName) {
        System.out.println("\n-----------------------------");
        System.out.println(taskName);
        System.out.println("-----------------------------\n");
    }
}
