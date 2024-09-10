// New class to combine data
package org.movie.MovieRecommendationSystem.model;


public class MovieFullInfo {
    private MovieModel movie;
    private Language language;
    private Genres genre;

    // Getters and Setters
    public MovieModel getMovie() {
        return movie;
    }

    public void setMovie(MovieModel movie) {
        this.movie = movie;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

	@Override
	public String toString() {
		return "MovieFullInfo [movie=" + movie + ", language=" + language + ", genre=" + genre + "]";
	}
    
}