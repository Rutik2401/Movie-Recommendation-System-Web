package org.movie.MovieRecommendationSystem.model;

public class Genres {
	private int id;
	private String genre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Genres() {
		
	}
	public Genres(int id, String genre) {
		
		this.id = id;
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Genres [id=" + id + ", genre=" + genre + "]";
	}
	
	
}
