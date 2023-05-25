package pl.pjatk.zjazd3.service;

import org.springframework.stereotype.Service;

@Service
public class FirstService {

    public String throwException(boolean shouldThrowException){
        if(shouldThrowException){
            throw new RuntimeException("grillek w majoweczke");
        }
        return "Exception is no more";
    }

}
