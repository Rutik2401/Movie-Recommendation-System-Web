package org.movie.MovieRecommendationSystem.service;

import org.movie.MovieRecommendationSystem.model.UserModel;
import org.movie.MovieRecommendationSystem.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepositoryImpl userRepository;
	@Override
	public boolean createUser(UserModel user) {
//		String hashPassword = passwordEncoder.encode(user.getPassword());
		String hashPassword=BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashPassword);	
		return userRepository.createUser(user);
	}
	public UserModel authenticateUser(String username, String password) {
		
		return userRepository.authenticateUser(username, password);
	}

}
