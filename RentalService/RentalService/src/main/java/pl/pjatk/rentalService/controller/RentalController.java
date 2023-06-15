package pl.pjatk.rentalService.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.rentalService.model.Movie;
import pl.pjatk.rentalService.service.RentalService;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/rentalService")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/getMovie/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "poprawne wyświetlenie", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))}),
            @ApiResponse(responseCode = "404", description = "lista jest pusta", content = @Content),
            @ApiResponse(responseCode = "504", description = "MovieService nie działa", content = @Content)})
    public ResponseEntity<Movie> getMovie(@PathVariable("id") Long id) {
        Movie movie = rentalService.getMovie(id);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/returnMovie/{id}")
    public ResponseEntity<Movie> returnMovie(@PathVariable("id") Long id) {
        rentalService.returnMovie(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/rentMovie/{id}")
    public ResponseEntity<Movie> rentMovie(@PathVariable("id") Long id) {
        rentalService.rentMovie(id);
        return ResponseEntity.ok().build();
    }


}
