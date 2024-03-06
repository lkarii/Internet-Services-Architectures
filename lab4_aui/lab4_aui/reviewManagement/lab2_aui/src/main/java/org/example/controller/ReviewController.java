package org.example.controller;

import org.example.DTOs.ReviewDto;
import org.example.model.Review;
import org.example.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ModelMapper modelMapper;

    // Создание новой рецензии
    @PostMapping
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto reviewDto) {
        Review review = modelMapper.map(reviewDto, Review.class);
        review = reviewService.save(review);
        ReviewDto responseDto = modelMapper.map(review, ReviewDto.class);
        return ResponseEntity.ok(responseDto);
    }

    // Получение рецензии по ID
    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> getReview(@PathVariable UUID id) {
        Review review = reviewService.findById(id);
        if (review == null) {
            return ResponseEntity.notFound().build();
        }
        ReviewDto reviewDto = modelMapper.map(review, ReviewDto.class);
        return ResponseEntity.ok(reviewDto);
    }

    // Обновление рецензии
    @PutMapping("/{id}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable UUID id, @RequestBody ReviewDto reviewDto) {
        Review existingReview = reviewService.findById(id);
        if (existingReview == null) {
            return ResponseEntity.notFound().build();
        }

        modelMapper.map(reviewDto, existingReview);
        existingReview = reviewService.save(existingReview);
        ReviewDto responseDto = modelMapper.map(existingReview, ReviewDto.class);

        return ResponseEntity.ok(responseDto);
    }


    // Удаление рецензии
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable UUID id) {
        Review review = reviewService.findById(id);
        if (review == null) {
            return ResponseEntity.notFound().build();
        }
        reviewService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // Получение всех рецензий
    @GetMapping
    public ResponseEntity<List<ReviewDto>> getAllReviews() {
        List<Review> reviews = reviewService.findAll();
        List<ReviewDto> reviewDtos = reviews.stream()
                .map(review -> modelMapper.map(review, ReviewDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(reviewDtos);
    }

    @DeleteMapping("/film/{filmId}")
    public ResponseEntity<Void> deleteReviewsByFilmId(@PathVariable UUID filmId) {
        reviewService.deleteByFilmId(filmId);
        return ResponseEntity.ok().build();
    }
}
