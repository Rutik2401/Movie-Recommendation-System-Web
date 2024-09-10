package org.movie.MovieRecommendationSystem.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.movie.MovieRecommendationSystem.model.MovieFullInfo;
import org.movie.MovieRecommendationSystem.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RatingController {
	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "/submitRating", method = RequestMethod.POST)
	public String submitRating(@RequestParam("ratingValue") int rating, HttpSession session,
			Map<String, MovieFullInfo> map) {
		Integer userId = (Integer) session.getAttribute("userId");
		System.out.println("User id:" + userId);
		System.out.println("rating is:" + rating);
		Integer movId = (Integer) session.getAttribute("currentMovie");
		System.out.println("Mov id:" + movId);

		if (userId != null && movId != null) {
			boolean b = movieService.saveRating(userId, movId, rating);
			System.out.println(b?"Rating save ":"Rating Not Save");
		}
		MovieFullInfo fullInfo = movieService.getMovieFullInfo(movId);
		session.setAttribute("currentMovie", fullInfo.getMovie().getMovId());
		map.put("fullInfo", fullInfo);
		return "movie";

	}
}
