package com.example.presentation;

import com.example.domain.model.Movie;
import com.example.domain.model.MovieFactory;
import com.example.infrastructure._configuration.CustomObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

public class MovieControllerTest {

    @Test
    public void mappingTest() throws Exception {
        Movie movie = MovieFactory.create();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
        ;

        MovieView movieView = modelMapper.map(movie, MovieView.class);
        System.out.println("movieView=" + movieView);

        ObjectMapper objectMapper = CustomObjectMapper.objectMapper();

        String json = objectMapper.writeValueAsString(movieView);
        System.out.println("json=" + json);
    }
}
