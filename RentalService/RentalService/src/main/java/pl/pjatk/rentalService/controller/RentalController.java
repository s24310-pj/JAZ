package pl.pjatk.rentalService.controller;

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

    @RequestMapping("/getMovie/{id}")
    @GetMapping
    public ResponseEntity<Movie> getMovie(@PathVariable("id") Long id){
        Movie movie = rentalService.getMovie(id);
        return ResponseEntity.ok(movie);
    }

    @RequestMapping("/returnMovie/{id}")
    @GetMapping
    public ResponseEntity<Movie> returnMovie(@PathVariable("id") Long id){
        rentalService.returnMovie(id);
        return ResponseEntity.ok().build();
    }




}
