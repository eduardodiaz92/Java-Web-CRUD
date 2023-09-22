package com.eduardo.CRUD.services;

import com.eduardo.CRUD.models.MovieModel;
import com.eduardo.CRUD.repositories.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    IMovieRepository movieRepository;

    public ArrayList<MovieModel> getMovies(){
        return (ArrayList<MovieModel>) movieRepository.findAll();
    }

    public MovieModel saveMovie(MovieModel movie) {
        return movieRepository.save(movie);
    }

    public Optional<MovieModel> getById(Long id){
        return movieRepository.findById(id);
    }

    public MovieModel updateById(MovieModel request, Long id){
        MovieModel userModel = movieRepository.findById(id).get();
        userModel.setName(request.getName());
        userModel.setSchedule(request.getSchedule());
        userModel.setCategory(request.getCategory());
        userModel.setSeats(request.getSeats());
        return userModel;
    }

    public Boolean deleteMovie (Long id){
        try{
            movieRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
