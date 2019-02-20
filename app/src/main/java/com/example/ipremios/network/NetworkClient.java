package com.example.ipremios.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {
    private static String BASE_URL = "https://ipremios-app-test.herokuapp.com/";

    public static Retrofit retrofit;

    public void NetworkClient(){

    }

    public static Retrofit getRetrofit(){

        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
