package org.movie.MovieRecommendationSystem.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.movie.MovieRecommendationSystem.model.Genres;
import org.movie.MovieRecommendationSystem.model.Language;
import org.movie.MovieRecommendationSystem.model.MovieFullInfo;
import org.movie.MovieRecommendationSystem.model.MovieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository("movieRepository")
public class MovieRepositoryImpl implements MovieRepository {
	@Autowired
	JdbcTemplate template;

	@Override
	public List<MovieModel> getAllMovies() {
		String query = "SELECT * FROM MovieMaster";
		System.out.println("In Repo Method");

		return template.query(query, new RowMapper<MovieModel>() {
			@Override
			public MovieModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new MovieModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)

				);
			}
		});
	}

	@Override
	public boolean updateMovie(MovieModel movie) {
		String query = "UPDATE MovieMaster SET mov_name = ?, About = ?, mov_year = ? WHERE mov_id = ?";
		int value = template.update(query, movie.getMovName(), movie.getAbout(), movie.getMovYear(), movie.getMovId());
		return value > 0;
	}

	@Override
	public boolean deleteMovie(int id) {
		String query = "DELETE FROM MovieMaster WHERE mov_id = ?";
		int value = template.update(query, id);
		return value > 0; //
	}

	@Override
	public int addMovie(MovieModel movie) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		int added = template.update(connection -> {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Moviemaster (mov_name, About, mov_year) VALUES (?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, movie.getMovName());
			ps.setString(2, movie.getAbout());
			ps.setInt(3, movie.getMovYear());
			return ps;
		}, keyHolder);

		// Return the generated primary key
		return keyHolder.getKey().intValue();
	}

	public List<Language> getAllLanguages() {
		String sql = "SELECT Lang_id, Language FROM language";

		List<Language> list = template.query(sql, new RowMapper<Language>() {
			@Override
			public Language mapRow(ResultSet rs, int rowNum) throws SQLException {
				int langId = rs.getInt("Lang_id");
				String language = rs.getString("Language");
				return new Language(langId, language);
			}
		});

		return list;

	}

	@Override
	public List<Genres> getAllGenres() {
		String query = "select gen_id,gen_title from genres";
		List<Genres> list = template.query(query, new RowMapper<Genres>() {

			@Override
			public Genres mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id = rs.getInt(1);
				String genres = rs.getString(2);
				return new Genres(id, genres);
			}
		});
		return list;
	}
//
	public List<MovieModel> getRandomMovies(int limit) {
		String sql = "SELECT * FROM moviemaster ORDER BY RAND() LIMIT ?";

		return template.query(sql, new Object[] { limit }, new RowMapper<MovieModel>() {
			@Override
			public MovieModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new MovieModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
		});
	}

	@Override
	public MovieFullInfo getMovieFullInfo(int movieId) {

		String sql = "SELECT mm.mov_id, mm.mov_name, mm.about, mm.mov_year, l.Language, l.Lang_id, g.gen_title, g.gen_id FROM moviemaster mm JOIN moviegenrelanguage mgl ON mm.mov_id = mgl.mov_id JOIN language l ON mgl.Lang_id = l.Lang_id JOIN genres g ON mgl.gen_id = g.gen_id WHERE mm.mov_id = ?";

		MovieFullInfo movieFullInfo = template.queryForObject(sql, new Object[] { movieId },
				new RowMapper<MovieFullInfo>() {
					@Override
					public MovieFullInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
						// Mapping movie data
						MovieModel movie = new MovieModel();
						movie.setMovId(rs.getInt("mov_id"));
						movie.setMovName(rs.getString("mov_name"));
						movie.setAbout(rs.getString("about"));
						movie.setMovYear(rs.getInt("mov_year"));

						// Mapping language data
						Language language = new Language();
						language.setId(rs.getInt("Lang_id"));
						language.setLanguage(rs.getString("Language"));

						// Mapping genre data
						Genres genre = new Genres();
						genre.setId(rs.getInt("gen_id"));
						genre.setGenre(rs.getString("gen_title"));

						// Combining all into MovieFullInfo
						MovieFullInfo movieFullInfo = new MovieFullInfo();
						movieFullInfo.setMovie(movie);
						movieFullInfo.setLanguage(language);
						movieFullInfo.setGenre(genre);

						System.out.println("aaaaxdddddaaaaaa" + movieFullInfo);
						
						return movieFullInfo;
					}
				});
		return movieFullInfo;
	}

	@Override
	public Boolean addGenresLanguage(int langId, int genreId, int movId) {
		int isAdded = template.update("insert into moviegenrelanguage (mov_id, gen_id, Lang_id) values (?, ?, ?)",
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setInt(1, movId);
						ps.setInt(2, genreId);
						ps.setInt(3, langId);
					}
				});
		return isAdded > 0;
	}

	@Override
	public boolean saveRating(int userId, int movId, int rating) {
		int issave = template.update("insert into rating values(?,?,?,?)", new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, 0);
				ps.setInt(2, rating);
				ps.setInt(3, userId);
				ps.setInt(4, movId);

			}
		});
		return issave > 0 ? true : false;
	}

	public Map<Integer, Map<Integer, Double>> getRecommendation() {
	    String query = "SELECT r.user_id, m.mov_id, r.rating FROM rating r JOIN moviemaster m ON r.mov_id = m.mov_id";
	    
	    // Query the database and process the results
	    return template.query(query, rs -> {
	        Map<Integer, Map<Integer, Double>> userRatings = new HashMap<>();

	        while (rs.next()) {
	            int userId = rs.getInt("user_id");
	            int movieId = rs.getInt("mov_id");
	            double rating = rs.getDouble("rating");

	            userRatings.putIfAbsent(userId, new HashMap<>());
	            userRatings.get(userId).put(movieId, rating);
	        }

	        return userRatings;
	    });
	}

	@Override
	public List<MovieFullInfo> getAllMoviesByLanguage(int langId){

		String sql = "SELECT mm.mov_id, mm.mov_name, mm.about, mm.mov_year, l.Language, l.Lang_id, g.gen_title, g.gen_id FROM moviemaster mm JOIN moviegenrelanguage mgl ON mm.mov_id = mgl.mov_id JOIN language l ON mgl.Lang_id = l.Lang_id JOIN genres g ON mgl.gen_id = g.gen_id WHERE l.Lang_id = ? ";

		 List<MovieFullInfo> movieFullInfoList = template.query(sql, new Object[] { langId}, new RowMapper<MovieFullInfo>() {
		                @Override
		                public MovieFullInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		                    // Mapping movie data
		                    MovieModel movie = new MovieModel();
		                    movie.setMovId(rs.getInt("mov_id"));
		                    movie.setMovName(rs.getString("mov_name"));
		                    movie.setAbout(rs.getString("about"));
		                    movie.setMovYear(rs.getInt("mov_year"));

		                    // Mapping language data
		                    Language language = new Language();
		                    language.setId(rs.getInt("Lang_id"));
		                    language.setLanguage(rs.getString("Language"));

		                    // Mapping genre data
		                    Genres genre = new Genres();
		                    genre.setId(rs.getInt("gen_id"));
		                    genre.setGenre(rs.getString("gen_title"));

		                    // Combining all into MovieFullInfo
		                    MovieFullInfo movieFullInfo = new MovieFullInfo();
		                    movieFullInfo.setMovie(movie);
		                    movieFullInfo.setLanguage(language);
		                    movieFullInfo.setGenre(genre);

		                    return movieFullInfo;
		                }
		            });

		    return movieFullInfoList;
	}

	public List<MovieFullInfo> getAllMoviesByCategory(int generesId) {
		String sql = "SELECT mm.mov_id, mm.mov_name, mm.about, mm.mov_year, l.Language, l.Lang_id, g.gen_title, g.gen_id FROM moviemaster mm JOIN moviegenrelanguage mgl ON mm.mov_id = mgl.mov_id JOIN language l ON mgl.Lang_id = l.Lang_id JOIN genres g ON mgl.gen_id = g.gen_id WHERE g.gen_id =?";

		 List<MovieFullInfo> movieFullInfoList = template.query(sql, new Object[] {generesId}, new RowMapper<MovieFullInfo>() {
		                @Override
		                public MovieFullInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		                    // Mapping movie data
		                    MovieModel movie = new MovieModel();
		                    movie.setMovId(rs.getInt("mov_id"));
		                    movie.setMovName(rs.getString("mov_name"));
		                    movie.setAbout(rs.getString("about"));
		                    movie.setMovYear(rs.getInt("mov_year"));

		                    // Mapping language data
		                    Language language = new Language();
		                    language.setId(rs.getInt("Lang_id"));
		                    language.setLanguage(rs.getString("Language"));

		                    // Mapping genre data
		                    Genres genre = new Genres();
		                    genre.setId(rs.getInt("gen_id"));
		                    genre.setGenre(rs.getString("gen_title"));

		                    // Combining all into MovieFullInfo
		                    MovieFullInfo movieFullInfo = new MovieFullInfo();
		                    movieFullInfo.setMovie(movie);
		                    movieFullInfo.setLanguage(language);
		                    movieFullInfo.setGenre(genre);

		                    return movieFullInfo;
		                }
		            });

		    return movieFullInfoList;
	}


}
