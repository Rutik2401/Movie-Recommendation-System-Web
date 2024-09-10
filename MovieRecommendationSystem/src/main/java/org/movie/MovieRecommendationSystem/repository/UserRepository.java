package org.movie.MovieRecommendationSystem.repository;

import org.movie.MovieRecommendationSystem.model.UserModel;

public interface UserRepository {
	public boolean createUser(UserModel user);
	public UserModel authenticateUser(String username, String password);
}
