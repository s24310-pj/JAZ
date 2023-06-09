package pl.pjatk.rentalService.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.rentalService.model.Movie;

import java.net.URI;

@Service
public class RentalService {

    private final RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id) {
        try {
            final String uri = "http://localhost:8080/movieService/movies/" + id;
            return restTemplate.getForObject(URI.create(uri), Movie.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        } catch (HttpClientErrorException.BadRequest e) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        } catch (HttpServerErrorException.BadGateway e) {
            throw new HttpServerErrorException(HttpStatus.BAD_GATEWAY);
        } catch (HttpServerErrorException.GatewayTimeout e) {
            throw new HttpServerErrorException(HttpStatus.GATEWAY_TIMEOUT);
        } catch (Exception e) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void returnMovie(Long id) {
        try {
            final String uri = "http://localhost:8080/movieService/movies/" + id + "/available";
            restTemplate.put(URI.create(uri), Movie.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        } catch (HttpClientErrorException.BadRequest e) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        } catch (HttpServerErrorException.BadGateway e) {
            throw new HttpServerErrorException(HttpStatus.BAD_GATEWAY);
        } catch (HttpServerErrorException.GatewayTimeout e) {
            throw new HttpServerErrorException(HttpStatus.GATEWAY_TIMEOUT);
        } catch (Exception e) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void rentMovie(Long id) {
        try {
            final String uri = "http://localhost:8080/movieService/movies/" + id + "/unavailable";
            restTemplate.put(URI.create(uri), Movie.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        } catch (HttpClientErrorException.BadRequest e) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        } catch (HttpServerErrorException.BadGateway e) {
            throw new HttpServerErrorException(HttpStatus.BAD_GATEWAY);
        } catch (HttpServerErrorException.GatewayTimeout e) {
            throw new HttpServerErrorException(HttpStatus.GATEWAY_TIMEOUT);
        } catch (Exception e) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
