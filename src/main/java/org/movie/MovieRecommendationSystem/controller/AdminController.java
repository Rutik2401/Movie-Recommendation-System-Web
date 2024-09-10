package org.movie.MovieRecommendationSystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.movie.MovieRecommendationSystem.model.Genres;
import org.movie.MovieRecommendationSystem.model.Language;
import org.movie.MovieRecommendationSystem.model.MovieModel;
import org.movie.MovieRecommendationSystem.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AdminController {
	@Autowired
	MovieService movieService;
	
		
	@RequestMapping(value = "signout")
	public ModelAndView test(HttpServletRequest request) throws IOException {
		 HttpSession session = request.getSession(false);
		    if (session != null) {
		        session.invalidate(); // Invalidate session
		    }
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
}
