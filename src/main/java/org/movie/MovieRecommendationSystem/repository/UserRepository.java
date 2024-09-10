package org.movie.MovieRecommendationSystem.repository;

import java.util.List;

import org.movie.MovieRecommendationSystem.model.UserModel;

public interface UserRepository {
	public boolean createUser(UserModel user);
	public UserModel authenticateUser(String username, String password);
	public List<UserModel> getAllUsers();
	public boolean deleteUser(int userId) ;
    public boolean updateUser(UserModel user);
	
}
