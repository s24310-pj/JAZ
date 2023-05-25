package pl.pjatk.movieService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.movieService.model.Movie;
import pl.pjatk.movieService.service.MovieService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieService")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> movieList() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping(value = "/movies/{id}")
    public ResponseEntity<Optional<Movie>> movieById(@PathVariable("id") Long id) {
        Optional<Movie> exceptionText = movieService.findById(id);
        return ResponseEntity.ok(exceptionText);
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie addedMovie = movieService.addMovie(movie);
        if (addedMovie == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Optional<Movie>> updateMovie(@PathVariable("id") long id, @RequestBody Movie movie) {
        Optional<Movie> newMovie = movieService.updateMovie(id, movie);
        if (newMovie.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(newMovie);
    }

    @PutMapping("/movies/{id}/available")
    public ResponseEntity<Movie> setMovieAvailability(@PathVariable("id") long id) {
        Movie movie = movieService.setMovieAvailability(id);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable long id) {
        boolean isDeleted = movieService.deleteMovie(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
