package pl.pjatk.movieService.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.movieService.model.Movie;
import pl.pjatk.movieService.service.MovieService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieService")
@Tag(name = "Kontroler", description = "kontroler mikroserwisu MovieService")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/movies")
    @Operation(summary = "wyświetlenie listy wszystkich filmów")
    public ResponseEntity<List<Movie>> movieList() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping(value = "/movies/{id}")
    @Operation(summary = "wyświetla film o podanym id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "znaleziono film",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Movie.class)) }),
            @ApiResponse(responseCode = "400", description = "niepoprawne id", content = @Content),
            @ApiResponse(responseCode = "404", description = "nie znaleziono fillmu", content = @Content) })
    public ResponseEntity<Optional<Movie>> movieById(@PathVariable("id") Long id) {
        Optional<Movie> movie = movieService.findById(id);
        if (movie.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(movie);
    }

    @PostMapping("/movies")
    @Operation(summary = "dodaje nowy film do bazy danych")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie addedMovie = movieService.addMovie(movie);
        if (addedMovie == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/movies/{id}")
    @Operation(summary = "wyświetla film o podanym id")
    public ResponseEntity<Optional<Movie>> updateMovie(@PathVariable("id") long id, @RequestBody Movie movie) {
        Optional<Movie> newMovie = movieService.updateMovie(id, movie);
        if (newMovie.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(newMovie);
    }

    @PutMapping("/movies/{id}/available")
    @Operation(summary = "zmienia status filmu na dostępny")
    public ResponseEntity<Movie> setMovieAvailable(@PathVariable("id") long id) {
        Movie movie = movieService.setMovieAvailable(id);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie);
    }

    @PutMapping("/movies/{id}/unavailable")
    @Operation(summary = "zmienia status filmu na zajęty")
    public ResponseEntity<Movie> setMovieUnavailable(@PathVariable("id") long id) {
        Movie movie = movieService.setMovieUnavailable(id);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping("/movies/{id}")
    @Operation(summary = "usuwa film o podanym id z bazy danych")
    public ResponseEntity<Void> deleteMovie(@PathVariable long id) {
        boolean isDeleted = movieService.deleteMovie(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
