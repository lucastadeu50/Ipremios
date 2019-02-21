package com.example.ipremios.network;

import com.example.ipremios.model.listItem.Item;
import com.example.ipremios.model.responsePost.Token;
import com.example.ipremios.model.userLogin.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NetworkInterface {
    @Headers({"Content-Type: application/json"})

    //@FormUrlEncoded
    @POST("/api/v1/sessions")
    Call<Token> userLogin(@Body User user);


    @GET("/api/v1/lists")
    Call<Item> getData(@Header("Authorization") String token);

}