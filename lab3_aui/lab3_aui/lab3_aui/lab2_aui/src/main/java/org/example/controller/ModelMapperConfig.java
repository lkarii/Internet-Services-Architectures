package org.example.controller;

import org.example.DTOs.ReviewDto;
import org.example.model.Film;
import org.example.model.Review;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.example.service.FilmService;

import java.util.UUID;

@Configuration
public class ModelMapperConfig {

    private final FilmService filmService;

    public ModelMapperConfig(FilmService filmService) {
        this.filmService = filmService;
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Converter<UUID, Film> filmConverter = new Converter<UUID, Film>() {
            public Film convert(MappingContext<UUID, Film> context) {
                return filmService.findById(context.getSource());
            }
        };

        modelMapper.typeMap(ReviewDto.class, Review.class).addMappings(m -> {
            m.using(filmConverter).map(ReviewDto::getFilmId, Review::setFilm);
        });

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper;
    }
}
