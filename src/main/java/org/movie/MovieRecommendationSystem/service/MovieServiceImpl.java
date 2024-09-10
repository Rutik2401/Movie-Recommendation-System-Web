package org.movie.MovieRecommendationSystem.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.movie.MovieRecommendationSystem.model.Genres;
import org.movie.MovieRecommendationSystem.model.Language;
import org.movie.MovieRecommendationSystem.model.MovieFullInfo;
import org.movie.MovieRecommendationSystem.model.MovieModel;
import org.movie.MovieRecommendationSystem.repository.MovieRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("movieService")
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieRepositoryImpl movieRepository;

	@Override
	public List<MovieModel> getAllMovies() {
		System.out.println("In Service Method");
		return movieRepository.getAllMovies();
	}

	@Override
	public boolean updateMovie(MovieModel movie) {
		return movieRepository.updateMovie(movie);

	}

	@Override
	public boolean deleteMovie(int id) {
		return movieRepository.deleteMovie(id);
		// TODO Auto-generated method stub

	}

	@Override
	public int addMovie(MovieModel movie) {
		
		return movieRepository.addMovie(movie);
	}

	@Override
	public List<Language> getAllLanguages() {

		return movieRepository.getAllLanguages();
	}

	@Override
	public List<Genres> getAllGenres() {
		// TODO Auto-generated method stub
		return movieRepository.getAllGenres();
	}

	@Override
	public List<MovieModel> getRandomMovies(int i) {
		
		return movieRepository.getRandomMovies( i);
	}

	@Override
	public MovieFullInfo getMovieFullInfo(int movieId) {
		// TODO Auto-generated method stub
		return movieRepository.getMovieFullInfo(movieId);
	}

	
	@Override
	public Boolean addGenresLanguage(int language, int genres, int movId) {
		// TODO Auto-generated method stub
		return movieRepository.addGenresLanguage(language, genres,movId);
	}

	@Override
	public boolean saveRating(int userId, int movId, int rating) {
		
		return movieRepository.saveRating(userId, movId, rating);
	}


	@Override
	public Integer getReccommendationByRating(int userId) {
	    Map<Integer, Map<Integer, Double>> userRatings = movieRepository.getRecommendation();
	    System.out.println(userRatings);

	    Map<Integer, Double> priorProbabilities = calculatePriorProbabilities(userRatings);

	    Map<Integer, Double> likelihoods = calculateLikelihoods(userRatings, userId);
	    System.out.println("likelihoods" + likelihoods);

	    Map<Integer, Double> posteriorProbabilities;

	    if (likelihoods.isEmpty()) {
	        // If new user
	        posteriorProbabilities = priorProbabilities;
	    } else {
	        posteriorProbabilities = calculatePosteriorProbabilities(priorProbabilities, likelihoods);
	    }

	    Integer recommendedMovieId = recommendMovie(posteriorProbabilities);
	    System.out.println("Recommended Movie ID:" + recommendedMovieId);
	    return recommendedMovieId;
	}

	private static Map<Integer, Double> calculatePriorProbabilities(Map<Integer, Map<Integer, Double>> userRatings) {
	    Map<Integer, Double> priorProbabilities = new HashMap<>();
	    Map<Integer, Double> totalRatings = new HashMap<>();
	    int numRatings = 0;

	    // Calculate total ratings for each movie
	    for (Map<Integer, Double> ratings : userRatings.values()) {
	        for (Map.Entry<Integer, Double> entry : ratings.entrySet()) {
	            totalRatings.put(entry.getKey(), totalRatings.getOrDefault(entry.getKey(), 0.0) + entry.getValue());
	            numRatings++;
	        }
	    }
	    System.out.println("totalRatings" + totalRatings);

	    // Calculate prior probabilities
	    for (Map.Entry<Integer, Double> entry : totalRatings.entrySet()) {
	        priorProbabilities.put(entry.getKey(), entry.getValue() / (double) numRatings);
	    }
	    System.out.println("prior probabilities" + priorProbabilities);
	    return priorProbabilities;
	}
	private static Map<Integer, Double> calculateLikelihoods(Map<Integer, Map<Integer, Double>> userRatings, int userId) {
	    Map<Integer, Double> likelihoods = new HashMap<>();
	    Map<Integer, Double> userRatingsForUser = userRatings.get(userId);

	    if (userRatingsForUser == null) {
	        // Return empty likelihoods for new users
	        return likelihoods;
	    }

	    int totalRatings = userRatingsForUser.size();
	    int numMovies = userRatings.values().iterator().next().size();

	    for (Integer movieId : userRatingsForUser.keySet()) {
	        Double rating = userRatingsForUser.get(movieId);
	        likelihoods.put(movieId, (rating + 1) / (double) (totalRatings + numMovies));
	    }

	    return likelihoods;
	}


	private static Map<Integer, Double> calculatePosteriorProbabilities(Map<Integer, Double> priorProbabilities, Map<Integer, Double> likelihoods) {
	    Map<Integer, Double> posteriorProbabilities = new HashMap<>();

	    for (Integer movieId : priorProbabilities.keySet()) {
	        double prior = priorProbabilities.get(movieId);
	        double likelihood = likelihoods.getOrDefault(movieId, 0.0);
	        double posterior = prior * likelihood;
	        posteriorProbabilities.put(movieId, posterior);
	    }
	    System.out.println("posteriorProbabilities" + posteriorProbabilities);
	    return posteriorProbabilities;
	}


	private static Integer recommendMovie(Map<Integer, Double> posteriorProbabilities) {
	    Integer recommendedMovie = null;
	    double maxProbability = 0.0;

	    for (Map.Entry<Integer, Double> entry : posteriorProbabilities.entrySet()) {
	        if (entry.getValue() > maxProbability) {
	            maxProbability = entry.getValue();
	            recommendedMovie = entry.getKey();
	        }
	    }

	    if (recommendedMovie == null) {
	        return 1; // if not Found
	    }

	    return recommendedMovie;
	}

	@Override
	public List<MovieFullInfo> getAllMoviesByLanguage(int langId) {
		
		return movieRepository.getAllMoviesByLanguage( langId);
	}

	@Override
	public List<MovieFullInfo> getAllMoviesByCategory(int generesId) {
		
		return movieRepository.getAllMoviesByCategory(generesId);
	}



	

}
