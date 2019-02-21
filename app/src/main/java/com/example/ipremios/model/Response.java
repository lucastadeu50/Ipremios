package com.example.ipremios.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("access_token")
	@Expose
	private String access_token;

	public void setAccessToken(String access_token){
		this.access_token = access_token;
	}

	public String getAccessToken(){
		return access_token;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"access_token = '" + access_token + '\'' +
			"}";
		}
}
