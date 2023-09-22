package com.eduardo.CRUD.controllers;

import com.eduardo.CRUD.models.MovieModel;
import com.eduardo.CRUD.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ArrayList<MovieModel> getMovies(){
        return this.movieService.getMovies();
    }

    @PostMapping
    public MovieModel saveModel(@RequestBody MovieModel movie){
        return this.movieService.saveMovie(movie);
    }

    @GetMapping(path = "/{id}")
    public Optional<MovieModel> getMovieById(@PathVariable("id") Long id){
        return this.movieService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public MovieModel updateMovieById(@RequestBody MovieModel request, @PathVariable Long id){
        return this.movieService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id ){
        boolean ok = this.movieService.deleteMovie(id);

        if(ok){
            return "Movie with id: " + id + "deleted";
        } else {
            return "Error";
        }
    }
}