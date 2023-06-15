package pl.pjatk.movieService.service;

import org.springframework.stereotype.Service;
import pl.pjatk.movieService.model.Movie;
import pl.pjatk.movieService.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Optional<Movie> updateMovie(long id, Movie newMovie) {
        Optional<Movie> currentMovie = movieRepository.findById(id);
        if (currentMovie.isPresent()) {
            Movie movie = currentMovie.get();
            movie.setName(newMovie.getName());
            movie.setMovieCategory(newMovie.getMovieCategory());
            return Optional.of(movieRepository.save(movie));
        }
        return Optional.empty();
    }

    public Movie setMovieAvailable(long id) {
        Optional<Movie> currentMovie = movieRepository.findById(id);
        if (currentMovie.isPresent()) {
            Movie movie = currentMovie.get();
            movie.setAvailable(true);
            return movieRepository.save(movie);
        }
        return null;
    }

    public Movie setMovieUnavailable(long id) {
        Optional<Movie> currentMovie = movieRepository.findById(id);
        if (currentMovie.isPresent()) {
            Movie movie = currentMovie.get();
            movie.setAvailable(false);
            return movieRepository.save(movie);
        }
        return null;
    }

    public boolean deleteMovie(long id) {
        boolean exists = movieRepository.existsById(id);
        if (exists) {
            movieRepository.deleteById(id);
        }
        return exists;
    }

}
