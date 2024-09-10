package org.movie.MovieRecommendationSystem.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.movie.MovieRecommendationSystem.model.UserModel;
import org.movie.MovieRecommendationSystem.service.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Repository;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	JdbcTemplate template;

	@Override
	public boolean createUser(final UserModel user) {
		int value = template.update("insert into userMaster values(?,?,?,?,?)", new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, 0);
				ps.setString(2, user.getUsername());
				ps.setString(3, user.getPassword());
				ps.setString(4, user.getEmail());
				ps.setString(5, user.getContact());

			}
		});
		return value > 0 ? true : false;

	}

	public UserModel authenticateUser(String username, final String password) {
		try {
		    String str = "select user_id, username, password, email, contact from usermaster WHERE username = ?";
		    List<UserModel> users = template.query(str, new Object[] { username }, new RowMapper<UserModel>() {

		                @Override
		                public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		                    String dbPass = rs.getString("password"); 
		                    System.out.println("DB pass: " + dbPass);
		                    if (BCrypt.checkpw(password, dbPass)) {//passwordEncoder.matches(password, dbPass)
		                    	
		                        System.out.println("True Person");
		                        return new UserModel(rs.getInt("user_id"),rs.getString("username"), rs.getString("password"),rs.getString("email"),rs.getString("contact"));
		                    }
		                    return null;
		                }
		            });

		    if (!users.isEmpty() && users.get(0) != null) {
		        return users.get(0); 
		    } else {
		        System.out.println("User login not successfulaa");
		        return null;
		    }

		} catch (Exception e) {
		    System.out.println("Error in authenticateUser: " + e);
		    
		}
		return null;
		

	}

	
	public List<UserModel> getAllUsers() {
        String sql = "select * FROM usermaster";
        return template.query(sql, new BeanPropertyRowMapper<>(UserModel.class));
    }
	public boolean deleteUser(int userId) {
        String sql = "DELETE FROM usermaster WHERE user_id = ?";
        return template.update(sql, userId) > 0;
    }

    public boolean updateUser(UserModel user) {
        String sql = "UPDATE usermaster SET username = ?, password = ?, email = ?, contact = ? WHERE user_id = ?";
        return template.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getContact(), user.getUserId()) > 0;
    }

}
