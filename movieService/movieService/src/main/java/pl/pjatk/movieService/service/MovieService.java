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

//    public Movie updateMovie(int id, Movie newMovie){
//        Movie currentMovie = findById(id);
//        if (currentMovie == null){
//            return null;
//        }
//        currentMovie.setName(newMovie.getName());
//        currentMovie.setMovieCategory(newMovie.getMovieCategory());
//        return currentMovie;
//    }
//
//    public boolean deleteMovie(int id){
//        return movieList.removeIf(movie -> movie.getId() == id);
//    }

}
