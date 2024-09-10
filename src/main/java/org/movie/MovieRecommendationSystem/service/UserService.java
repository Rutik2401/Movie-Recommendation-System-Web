package org.movie.MovieRecommendationSystem.service;

import java.util.List;

import org.movie.MovieRecommendationSystem.model.UserModel;

public interface UserService {

	boolean createUser(UserModel user);
	public UserModel authenticateUser(String username, String password);
	public List<UserModel> getAllUsers();
	public boolean deleteUser(int userId) ;
    public boolean updateUser(UserModel user);
}
