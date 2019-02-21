package com.example.ipremios.model.userLogin;

import com.example.ipremios.model.userLogin.Session;
import com.google.gson.annotations.SerializedName;

public class User{
	@SerializedName("session")
	private Session session;

	public User(Session session) {
		this.session = session;
	}

	public void setSession(Session session){
		this.session = session;
	}

	public Session getSession(){
		return session;
	}

	@Override
 	public String toString(){
		return 
			"User{" + 
			"session = '" + session + '\'' + 
			"}";
		}
}
