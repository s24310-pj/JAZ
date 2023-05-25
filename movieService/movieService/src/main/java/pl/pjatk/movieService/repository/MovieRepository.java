package pl.pjatk.movieService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.movieService.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

        Optional<Movie> findById(Long aLong);

        List<Movie> findAll();


}
