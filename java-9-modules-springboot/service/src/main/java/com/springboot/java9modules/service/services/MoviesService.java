package com.springboot.java9modules.service.services;

import com.springboot.java9modules.service.domain.Movies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoviesService {

    public List<Movies> allMovies() {
        List<Movies> list = new ArrayList<>();
        Movies freeGuy = new Movies("1", "freeGuy", "comedy, action");
        Movies plubFiction = new Movies("2", "plubFiction", "action, thriller");
        list.add(freeGuy);
        list.add(plubFiction);
        return list;
    }
}
