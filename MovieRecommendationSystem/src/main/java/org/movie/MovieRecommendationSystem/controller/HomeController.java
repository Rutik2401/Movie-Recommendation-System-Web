package org.movie.MovieRecommendationSystem.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.movie.MovieRecommendationSystem.model.UserModel;
import org.movie.MovieRecommendationSystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@Autowired
	UserServiceImpl userService;

	@RequestMapping(value = "/")
	public ModelAndView test(HttpServletResponse response) throws IOException {

		return new ModelAndView("index");
	}

	// user validate user it self..>>> index if not then -->back to Login
	@RequestMapping(value = "/login") // go to the login Page
	public String getSignIn() throws IOException {
		return ("login");
	}

	@RequestMapping(value = "/reg") // go to the Register Page
	public String getRegister() throws IOException {

		return ("register");
	}

	@RequestMapping(value = "register") // User Register it self...>>>> Login
	public String isRegister(@ModelAttribute("user") UserModel user) throws IOException {
		System.out.println(user);

		// Write Here only Logic
		boolean b = userService.createUser(user);
		System.out.println(b ? "User register Successfuly" : "User register Not Successfuly");
		return "login";

	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String authenticate(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request) throws IOException {
		System.out.println(username + "\t" + password);
		UserModel user = userService.authenticateUser(username, password);

		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("username", user.getUsername());
			System.out.println("User login Successfuly");

			return "index";
		} else {
			System.out.println("User login Not Successfuly");
			return "login";
		}

	}

	@RequestMapping(value = "home")
	public String getHome() {
		return "index";
	}

}
