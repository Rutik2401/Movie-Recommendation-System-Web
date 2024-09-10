package org.movie.MovieRecommendationSystem.model;

public class MovieModel {
	private int movId;
	private String movName;
	private String about;
	private int movYear;
	private String movPath;
	
	

	public MovieModel() {
		
	}

	// getter and Setter
	public int getMovId() {
		return movId;
	}


	@Override
	public String toString() {
		return "MovieModel [movId=" + movId + ", movName=" + movName + ", about=" + about + ", movYear=" + movYear
				+ "]";
	}

	public MovieModel(int movId, String movName, String about, int movYear) {
		super();
		this.movId = movId;
		this.movName = movName;
		this.about = about;
		this.movYear = movYear;
	}

	public void setMovId(int movId) {
		this.movId = movId;
	}


	public String getMovName() {
		return movName;
	}


	public void setMovName(String movName) {
		this.movName = movName;
	}


	public String getAbout() {
		return about;
	}


	public void setAbout(String about) {
		this.about = about;
	}


	public int getMovYear() {
		return movYear;
	}


	public void setMovYear(int movYear) {
		this.movYear = movYear;
	}

	public String getMovPath() {
		return movPath;
	}

	public void setMovPath(String movPath) {
		this.movPath = movPath;
	}

	

	

	

	

	

}
