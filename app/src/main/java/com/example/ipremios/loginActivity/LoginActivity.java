package com.example.ipremios.loginActivity;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ipremios.mainActivity.MainActivity;
import com.example.ipremios.R;
import com.example.ipremios.model.userLogin.Session;
import com.example.ipremios.model.responsePost.Token;
import com.example.ipremios.model.userLogin.User;
import com.example.ipremios.network.NetworkClient;
import com.example.ipremios.network.NetworkInterface;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    MaterialButton materialButton;
    TextInputEditText textInputEmail;
    TextInputEditText textInputPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEmail = findViewById(R.id.editTextEmail);
        textInputPassword = findViewById(R.id.editTextPassword);
        materialButton = findViewById(R.id.buttonEnter);

        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick:" + textInputEmail.getText().toString() + textInputPassword.getText().toString());

                NetworkInterface networkInterface = NetworkClient.getRetrofit().create(NetworkInterface.class);

                Session session = new Session(textInputPassword.getText().toString(), textInputEmail.getText().toString());
                User user = new User(session);

                final Call<Token> call = networkInterface.userLogin(user);

                call.enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, retrofit2.Response<Token> response) {
                        if (response.isSuccessful()) {
                            Token response1 = response.body();
                            Log.d(TAG, "onResponse: " + response1.getResponse().getAccessToken());


                            SharedPreferences sharedPreferences = getSharedPreferences("mysettings",
                                    Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString(getString(R.string.accessToken), response1.getResponse().getAccessToken());
                            editor.apply();


                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                });

            }


        });



    }
}
