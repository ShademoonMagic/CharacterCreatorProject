package com.cassiafrench.charcreator.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UserLogin {
	@NotEmpty(message="Must input your email!")
	private String email;
	
	@NotEmpty(message="Must input your password!")
	private String password;
	
	public UserLogin() {
	}

	public UserLogin(@NotEmpty @Email String email, @NotEmpty String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
