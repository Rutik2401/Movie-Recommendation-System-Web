package org.movie.MovieRecommendationSystem.model;

public class UserModel {
	private int userId;
	private String username;
	private String password;
	private String email;
	private String contact;
	
	public UserModel(int userId, String username, String password, String email, String contact) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.contact = contact;
	}
	// Getter and Setter
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", contact=" + contact + "]";
	}
	
	
}
	
	
	
	

