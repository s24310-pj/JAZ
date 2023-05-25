package pl.pjatk.movieService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pjatk.movieService.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {


    @Query(nativeQuery = true, name = "Movie.findById")
    Optional<Movie> findById(Long aLong);

    @Query(value = "SELECT * FROM movies", nativeQuery = true)
    List<Movie> findAll();


}
