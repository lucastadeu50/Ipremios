package com.example.ipremios.network;

import com.example.ipremios.model.ListItem.Item;
import com.example.ipremios.model.Response;
import com.example.ipremios.model.Token;
import com.example.ipremios.model.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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