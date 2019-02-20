package com.example.ipremios.model;

import com.google.gson.annotations.SerializedName;

public class Session{

	@SerializedName("password")
	private String password;

	@SerializedName("email")
	private String email;

	public Session(String password, String email) {
		this.password = password;
		this.email = email;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"Session{" + 
			"password = '" + password + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}
