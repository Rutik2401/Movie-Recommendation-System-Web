package org.movie.MovieRecommendationSystem.service;

import java.util.List;

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
	public List<UserModel> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.getAllUsers();
	}
	@Override
	public boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		return userRepository.deleteUser(userId);
	}
	@Override
	public boolean updateUser(UserModel user) {
		// TODO Auto-generated method stub
		return userRepository.updateUser(user);
	}

}
