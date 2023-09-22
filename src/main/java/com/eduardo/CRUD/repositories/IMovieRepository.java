package com.eduardo.CRUD.repositories;

import com.eduardo.CRUD.models.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends JpaRepository<MovieModel, Long> {

}
