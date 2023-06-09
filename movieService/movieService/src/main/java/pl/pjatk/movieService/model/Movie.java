package pl.pjatk.movieService.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID filmu", required = true, nullable = false)
    private Long id;
    @Schema(description = "nazwa filmu", required = true, nullable = false)
    private String name;
    @Schema(description = "kategoria filmu", required = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private MovieCategory movieCategory;
    @Schema(required = true)
    @Column(nullable = false)
    private boolean isAvailable;


    public Movie(Long id, String name, MovieCategory movieCategory, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.movieCategory = movieCategory;
        this.isAvailable = isAvailable;
    }

    public Movie() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovieCategory getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(MovieCategory movieCategory) {
        this.movieCategory = movieCategory;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
