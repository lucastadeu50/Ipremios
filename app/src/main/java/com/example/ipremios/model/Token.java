package com.example.ipremios.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token{


	@SerializedName("response")
	@Expose
	private Response response;

	public void setResponse(Response response){
		this.response = response;
	}

	public Response getResponse(){
		return response;
	}

	@Override
 	public String toString(){
		return 
			"Token{" + 
			"response = '" + response + '\'' + 
			"}";
		}
}
