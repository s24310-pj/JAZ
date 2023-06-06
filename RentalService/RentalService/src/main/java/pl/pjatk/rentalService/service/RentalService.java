package pl.pjatk.rentalService.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.rentalService.model.Movie;

import java.net.URI;

@Service
public class RentalService {

    private final RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id){
        final String uri = "http://localhost:8080/movieService/movies/" + id;

        return restTemplate.getForObject(URI.create(uri), Movie.class);
    }

    public void returnMovie(Long id){
        final String uri = "http://localhost:8080/movieService/movies/" + id + "/available";

        restTemplate.put(URI.create(uri), Movie.class);
    }

    public void rentMovie(Long id){
        final String uri = "http://localhost:8080/movieService/movies/" + id + "/unavailable";

        restTemplate.put(URI.create(uri), Movie.class);
    }

}
