package org.movie.MovieRecommendationSystem.controller;

import java.util.List;

import org.movie.MovieRecommendationSystem.model.UserModel;
import org.movie.MovieRecommendationSystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class UserController {
	@Autowired
	UserServiceImpl userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public List<UserModel> getAllUser() {
		List<UserModel> userList = userService.getAllUsers();
		System.out.println("All User:" + userList);
		return userList;

	}

	@RequestMapping(value = "/deleteUser/{userId}",method = RequestMethod.POST)
	@ResponseBody
	public String deleteUser(@PathVariable int userId) {
		boolean success = userService.deleteUser(userId);
		return success ? "User deleted successfully" : "Error deleting user";
	}

	@RequestMapping(value = "/updateUser",method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public String updateUser(@RequestBody UserModel user) {
		boolean success = userService.updateUser(user);
		return success ? "User updated successfully" : "Error updating user";
	}
}
