package com.example.ipremios.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("accessToken")
	@Expose
	private String accessToken;

	public void setAccessToken(String accessToken){
		this.accessToken = accessToken;
	}

	public String getAccessToken(){
		return accessToken;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"access_token = '" + accessToken + '\'' + 
			"}";
		}
}
