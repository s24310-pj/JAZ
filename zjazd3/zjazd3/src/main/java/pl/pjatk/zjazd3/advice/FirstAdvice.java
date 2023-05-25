package pl.pjatk.zjazd3.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FirstAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> runtimeExceptionHandler(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                body("Exception occurred on request. Exception message: " + ex.getLocalizedMessage());
    }

}
