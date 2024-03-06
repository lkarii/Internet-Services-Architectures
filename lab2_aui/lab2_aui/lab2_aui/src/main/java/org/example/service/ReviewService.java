package org.example.service;

import org.example.model.Film;
import org.example.model.Review;
import org.example.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> findByFilm(Film film) {
        return reviewRepository.findByFilm(film);
    }

    public Review findById(UUID id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteById(UUID id) {
        reviewRepository.deleteById(id);
    }

    public List<Review> findAll() {return reviewRepository.findAll();}
}
