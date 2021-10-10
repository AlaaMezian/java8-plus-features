package com.springboot.java9modules.api.controller;

import com.springboot.java9modules.service.domain.Movies;
import com.springboot.java9modules.service.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping
    public List<Movies> all() {
        return moviesService.allMovies();
    }

}
