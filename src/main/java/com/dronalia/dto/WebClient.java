package com.dronalia.dto;

import com.dronalia.enumClass.PersonGenreEnum;

public class WebClient extends Person {

	private String user;
	private String password;
	
	public WebClient(int dni, String name, String surnames, String email, String tlf, PersonGenreEnum genre, String user, String password) {
		super(dni, name, surnames, email, tlf, genre);
		this.user = user;
		this.password = password;
	}
	
	public WebClient(int dni) {
		super(dni);
		// TODO Auto-generated constructor stub
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
}
