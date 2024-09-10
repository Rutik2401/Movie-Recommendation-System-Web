package org.movie.MovieRecommendationSystem.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.movie.MovieRecommendationSystem.model.Genres;
import org.movie.MovieRecommendationSystem.model.Language;
import org.movie.MovieRecommendationSystem.model.MovieFullInfo;
import org.movie.MovieRecommendationSystem.model.MovieModel;
import org.movie.MovieRecommendationSystem.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "/addmovie", method = RequestMethod.POST)
	public String addMovie(@ModelAttribute MovieModel movie, @RequestParam("language") int language,
			@RequestParam("genres") int genres, @RequestParam("movImg") MultipartFile movImg,
			RedirectAttributes redirectAttributes, Map<String, String> modelMap) {

		if (movImg.isEmpty()) {
			System.out.println("Please upload a poster.");
			modelMap.put("msg", "Please upload a poster.");
			return "Admin";
		}

		try {
			String uploadDir = "C:\\Users\\rutik\\Documents\\workspace-spring-tool-suite-4-4.24.0.RELEASE\\MovieRecommendationSystem\\src\\main\\webapp\\resources\\Images\\";
			System.out.println("Upload Directory: " + uploadDir);

			// Ensure the directory exists
			File uploadDirFile = new File(uploadDir);
			if (!uploadDirFile.exists()) {
				uploadDirFile.mkdirs();
			}

			// Construct the file path and check if the file already exists
			String fileName = movImg.getOriginalFilename();
			String filePath = uploadDir + fileName;
			File file = new File(filePath);
			if (file.exists()) {
				System.out.println("A file wiAth the same name already exists.");
				modelMap.put("msgF", "A file wiAth the same name already exists.");
				return "Admin";
			}

			// Transfer the file to the specified directory
			movImg.transferTo(file);

			// Set the image path in the MovieModel
			movie.setMovPath(
					"C:\\Users\\rutik\\Documents\\workspace-spring-tool-suite-4-4.24.0.RELEASE\\MovieRecommendationSystem\\src\\main\\webapp\\resources\\Images\\"
							+ fileName);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to upload movie poster.");
			modelMap.put("uploadError", "Failed to upload movie poster.");
			return "Admin";
		}
		System.out.println(language + "\t" + genres + "\t" + movie.getMovId());
		// Add the movie to the database (assumes movieService.addMovie(movie) handles
		// this)
		int Mov_id = movieService.addMovie(movie);
		System.out.println(Mov_id > 0 ? "Movie Added Successfully" : "Failed to Add Movie");
		System.out.println(language + "\t" + genres + "\t" + movie.getMovId());
		boolean b = movieService.addGenresLanguage(language, genres, Mov_id);

		System.out.println("Language: " + language + "\tGenres: " + genres);

		return "Admin";
	}

//	@RequestMapping(value = "/getMovies", method = RequestMethod.GET, produces = "application/json")
//	@ResponseBody
//	public List<MovieModel> getMovies() {
//		try {
//			List<MovieModel> list = movieService.getRandomMovies(6); // Fetch 6 random movies
//			System.out.println("Random Movies: " + list);
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace(); // Log the exception for debugging
//			return new ArrayList<>(); // Return an empty list or handle the error as needed
//		}
//	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	@ResponseBody
	public List<MovieModel> getAllMovies() {
		List<MovieModel> movies = movieService.getAllMovies();
		return movies;
	}

	@RequestMapping(value = "/deleteMovie/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String deleteMovie(@PathVariable("id") Integer id) {
		System.out.println("Delete This Movie:" + id);
		boolean isRemoved = movieService.deleteMovie(id);
		if (!isRemoved) {
			return "Movie not found";
		}
		return "Movie deleted successfully";
	}

	@RequestMapping(value = "/updateMovie", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public String updateMovie(@RequestBody MovieModel updatedMovie) {
		System.out.println(updatedMovie);
		boolean isUpdated = movieService.updateMovie(updatedMovie);
		if (!isUpdated) {
			return "Movie update failed";
		}
		return "Movie updated successfully";
	}

	@RequestMapping("watch")
	public String getMovie(@RequestParam("movieId") int movieId, Map<String, Object> map, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		System.out.println("User id:" + userId);
		if(userId!=null) {
			
			MovieFullInfo fullInfo = movieService.getMovieFullInfo(movieId);
			session.setAttribute("currentMovie", fullInfo.getMovie().getMovId());
			System.out.println("currentMovie id :" + fullInfo.getMovie().getMovId());
			map.put("fullInfo", fullInfo);
			List<Language> LangList = movieService.getAllLanguages();
			List<Genres> GenresList = movieService.getAllGenres();
			map.put("LangList",LangList);
			map.put("GenresList",GenresList);
			return "movie";
		}else {
			return "login";
		}
		
		

	}

	
	@RequestMapping(value = "see")
	public ModelAndView seeMovie(HttpServletResponse response) throws IOException {
		

		ModelAndView mav = new ModelAndView("see");
		List<Language> LangList = movieService.getAllLanguages();
		List<Genres> GenresList = movieService.getAllGenres();
		mav.addObject("LangList",LangList);
		mav.addObject("GenresList",GenresList);

		return mav;
	}
	@RequestMapping("recommend")
	public String getReccommendation( Map<String, MovieFullInfo> map, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		
		if(userId!=null) {
			Integer movieId=movieService.getReccommendationByRating(userId);
			System.out.println("here use get recomendation"+movieId);
			MovieFullInfo fullInfo = movieService.getMovieFullInfo(movieId);
			session.setAttribute("currentMovie", fullInfo.getMovie().getMovId());
			System.out.println("currentMovie id :" + fullInfo.getMovie().getMovId());
			map.put("fullInfo", fullInfo);
			
			return "movie";
		}else {
			return "login";
		}

	}
	@RequestMapping(value = "Allmovies")
	public ModelAndView getAllMoviesByLanguage(@RequestParam("language") int langId) {
		System.out.println("LAng id is:"+langId);
		List<MovieFullInfo> fullInfoList=movieService.getAllMoviesByLanguage(langId);
		System.out.println(fullInfoList);
		ModelAndView model= new ModelAndView("Allmovies");
		model.addObject("AllMovies",fullInfoList);
		List<Language> LangList = movieService.getAllLanguages();
		List<Genres> GenresList = movieService.getAllGenres();
		model.addObject("LangList",LangList);
		model.addObject("GenresList",GenresList);
		
		if(fullInfoList.size() > 0) {
		    model.addObject("AllMovies", fullInfoList);
		} else {
		    model.addObject("Message", "No movies are currently available. Please check back later.");
		}
		for (MovieFullInfo movieFullInfo : fullInfoList) {
			if(movieFullInfo.getLanguage().getId()==langId) {
				model.addObject("type",movieFullInfo.getLanguage().getLanguage());
			}
		}
		return model;
		
	}
	@RequestMapping(value = "Allmoviess")
	public ModelAndView getAllMoviesByCategory(@RequestParam("category") int generesId) {
		System.out.println("Generes id is:"+generesId);
		List<MovieFullInfo> fullInfoList=movieService.getAllMoviesByCategory(generesId);
		System.out.println(fullInfoList);
		List<Language> LangList = movieService.getAllLanguages();
		List<Genres> GenresList = movieService.getAllGenres();
		ModelAndView model= new ModelAndView("Allmovies");
		model.addObject("LangList",LangList);
		model.addObject("GenresList",GenresList);
		if(fullInfoList.size() > 0) {
		    model.addObject("AllMovies", fullInfoList);
		} else {
		    model.addObject("Message", "No movies are currently available. Please check back later.");
		}
		for (MovieFullInfo movieFullInfo : fullInfoList) {
			if(movieFullInfo.getGenre().getId()==generesId) {
				model.addObject("type",movieFullInfo.getGenre().getGenre());
			}
		}
		
		return model;
			
	}


}
