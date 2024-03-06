package org.example.controller;

import org.example.DTOs.ReviewDto;
import org.example.model.Review;
import org.example.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Configuration
public class ModelMapperConfig {

    private final ReviewService reviewService;


    public ModelMapperConfig(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(Review.class, ReviewDto.class).addMappings(mapper -> {
            mapper.map(src -> src.getFilmId(), ReviewDto::setFilmId);
            mapper.map(Review::getId, ReviewDto::setId);
        });


        return modelMapper;
    }
}
