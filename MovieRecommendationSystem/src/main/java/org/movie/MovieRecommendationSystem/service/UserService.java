package org.movie.MovieRecommendationSystem.service;

import org.movie.MovieRecommendationSystem.model.UserModel;

public interface UserService {

	boolean createUser(UserModel user);
	public UserModel authenticateUser(String username, String password);

}
