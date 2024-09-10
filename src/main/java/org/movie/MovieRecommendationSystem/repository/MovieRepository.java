package org.movie.MovieRecommendationSystem.repository;

import java.util.ArrayList;
import java.util.List;

import org.movie.MovieRecommendationSystem.model.Genres;
import org.movie.MovieRecommendationSystem.model.Language;
import org.movie.MovieRecommendationSystem.model.MovieFullInfo;
import org.movie.MovieRecommendationSystem.model.MovieModel;

public interface MovieRepository {
	List<MovieModel> getAllMovies();
	boolean updateMovie(MovieModel movie);

	boolean deleteMovie(int id);
	public int  addMovie(MovieModel movie);
	public List<Language> getAllLanguages() ;
	List<Genres> getAllGenres();
//	List<MovieModel> getRandomMovies(int i);
	MovieFullInfo getMovieFullInfo(int movieId);
	Boolean addGenresLanguage(int language, int genres, int movId);
	boolean saveRating(int userId, int movId, int rating);
	List<MovieFullInfo> getAllMoviesByLanguage(int langId);
	List<MovieFullInfo> getAllMoviesByCategory(int generesId);
}
