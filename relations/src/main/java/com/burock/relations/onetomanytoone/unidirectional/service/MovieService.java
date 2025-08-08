package com.burock.relations.onetomanytoone.unidirectional.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burock.relations.onetomanytoone.unidirectional.entity.Movie;
import com.burock.relations.onetomanytoone.unidirectional.entity.Review;
import com.burock.relations.onetomanytoone.unidirectional.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieFindById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            movie.setTitle(updatedMovie.getTitle());
            movie.setGenre(updatedMovie.getGenre());
            movie.setReleaseYear(updatedMovie.getReleaseYear());
            movie.setDirector(updatedMovie.getDirector());
            return movieRepository.save(movie);
        }
        return null;
    }   
    
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
    
    public Movie addReviewToMovie(Long movieId, Review review) {
        Optional<Movie> movieOpt = movieRepository.findById(movieId);
        if (movieOpt.isPresent()) {
            Movie movie = movieOpt.get();
            movie.addReview(review);
            return movieRepository.save(movie);
        }
        return null;
    }
}
