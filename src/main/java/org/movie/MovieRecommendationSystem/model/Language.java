package org.movie.MovieRecommendationSystem.model;

public class Language {
	private int id;
	private String Language;
	public Language() {
		
	}
	public Language(int id, String language) {
		super();
		this.id = id;
		Language = language;
	}
	@Override
	public String toString() {
		return "Language [id=" + id + ", Language=" + Language + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	
	
}
