package entities;

import entities.enums.FilmGenre;

import java.time.LocalDate;

public class Movie {
    private String title;
    private LocalDate yearRelease;
    private String director;
    private FilmGenre genre;
    private Double ProductionCost;

    public Movie(String title, LocalDate yearRelease, String director, FilmGenre genre, Double ProductionCost) {
        this.title = title;
        this.yearRelease = yearRelease;
        this.director = director;
        this.genre = genre;
        this.ProductionCost = ProductionCost;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getYearRelease() {
        return yearRelease;
    }

    public String getDirector() {
        return director;
    }

    public FilmGenre getGenre() {
        return genre;
    }

    public Double getProductionCost() {
        return ProductionCost;
    }
}
