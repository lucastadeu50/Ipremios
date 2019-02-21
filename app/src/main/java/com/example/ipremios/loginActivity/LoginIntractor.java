package com.example.ipremios.loginActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.ipremios.R;
import com.example.ipremios.model.responsePost.Token;
import com.example.ipremios.model.userLogin.Session;
import com.example.ipremios.model.userLogin.User;
import com.example.ipremios.network.NetworkClient;
import com.example.ipremios.network.NetworkInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class LoginIntractor implements LoginContract.GetLoginIntractor {


    @Override
    public void getLogin(final OnFinishedListener onFinishedListener, User user) {
        /** Create handle for the NetworkInterface interface*/
        NetworkInterface networkInterface = NetworkClient.getRetrofit().create(NetworkInterface.class);

        /** Call the method with parameter in the interface to get the login data*/
        Log.d(TAG, "getLogin: username" + user.getSession().getEmail());

        final Call<Token> call = networkInterface.userLogin(user);

        /**Log the URL called*/

        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, retrofit2.Response<Token> response) {
                onFinishedListener.onFinished(response.body(), true);
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }


        });
    }
}

