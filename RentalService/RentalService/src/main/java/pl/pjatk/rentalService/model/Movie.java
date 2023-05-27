package pl.pjatk.rentalService.model;


public class Movie {

    private Long id;
    private String name;
    private MovieCategory movieCategory;
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
