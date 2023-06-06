package pl.pjatk.rentalService.advice;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.net.ConnectException;

@RestControllerAdvice
public class RentalAdvice {

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<String> connectExceptionHandler(ConnectException ex) {
        return ResponseEntity.status(HttpStatusCode.valueOf(504)).build();
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<String> internalServerExceptionHandler(HttpServerErrorException.InternalServerError ex) {
        return ResponseEntity.status(HttpStatusCode.valueOf(502)).build();
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<String> badRequestExceptionHandler(HttpClientErrorException.BadRequest ex) {
        return ResponseEntity.status(HttpStatusCode.valueOf(400)).build();
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> notFoundExceptionHandler(HttpClientErrorException.NotFound ex) {
        return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
    }




}
