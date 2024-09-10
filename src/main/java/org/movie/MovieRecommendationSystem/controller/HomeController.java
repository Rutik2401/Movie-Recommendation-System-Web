package org.movie.MovieRecommendationSystem.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.movie.MovieRecommendationSystem.model.Genres;
import org.movie.MovieRecommendationSystem.model.Language;
import org.movie.MovieRecommendationSystem.model.MovieModel;
import org.movie.MovieRecommendationSystem.model.UserModel;
import org.movie.MovieRecommendationSystem.service.MovieService;
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

	@Autowired
	MovieService movieService;

	@RequestMapping(value = "/")
	public ModelAndView test(HttpServletResponse response) throws IOException {
		List<MovieModel> movies = movieService.getAllMovies();

		System.out.println(movies);

		ModelAndView mav = new ModelAndView("index");
		mav.addObject("movies", movies);
		List<Language> LangList = movieService.getAllLanguages();
		List<Genres> GenresList = movieService.getAllGenres();
		mav.addObject("LangList",LangList);
		mav.addObject("GenresList",GenresList);

		return mav;
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

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ModelAndView authenticate(@RequestParam("username") String username,
			@RequestParam("password") String password, HttpServletRequest request, Map<String, String> map,
			Map<String, List<Language>> Lang, Map<String, List<Genres>> Category) throws IOException {
		System.out.println(username + "\t" + password);
		UserModel user = userService.authenticateUser(username, password);
		int id = user.getUserId();
		if (user != null && id != 18 && id != 14) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("userName", user.getUsername());
			System.out.println("User login Successfuly");
			List<MovieModel> movies = movieService.getAllMovies();

			System.out.println(movies);

			ModelAndView mav = new ModelAndView("index");
			List<Language> LangList = movieService.getAllLanguages();
			List<Genres> GenresList = movieService.getAllGenres();
			mav.addObject("LangList",LangList);
			mav.addObject("GenresList",GenresList);
			mav.addObject("movies", movies);
			return mav;
		} else if (user.getUsername().equalsIgnoreCase("abc")) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("username", user.getUsername());
			List<Language> LangList = movieService.getAllLanguages();
			List<Genres> GenresList = movieService.getAllGenres();
			System.out.println("Language:" + LangList);
			System.out.println("GenresList:" + GenresList);
			Lang.put("LangList", LangList);
			Category.put("GenresList", GenresList);
			ModelAndView mav = new ModelAndView("Admin");
			return mav;
		}

		else {

			map.put("m", "Invalid Password");

			System.out.println("User login Not Successfuly");
			ModelAndView mav = new ModelAndView("login");
			mav.setViewName("login");
			return mav;
		}

	}

}
