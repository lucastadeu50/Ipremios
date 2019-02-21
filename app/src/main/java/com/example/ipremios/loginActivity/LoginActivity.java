package com.example.ipremios.loginActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.ipremios.R;
import com.example.ipremios.mainActivity.MainActivity;
import com.example.ipremios.model.responsePost.Token;
import com.example.ipremios.model.userLogin.Session;
import com.example.ipremios.model.userLogin.User;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView{

    private static final String TAG = "LoginActivity";
    private LoginContract.presenter presenter;

    ProgressBar progressBar;
    MaterialButton materialButton;
    TextInputEditText textInputEmail;
    TextInputEditText textInputPassword;

    Context context = LoginActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenterImpl(this, new LoginIntractor() );

        textInputEmail = findViewById(R.id.editTextEmail);
        textInputPassword = findViewById(R.id.editTextPassword);
        materialButton = findViewById(R.id.buttonEnter);

        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Session session = new Session(textInputPassword.getText().toString(), textInputEmail.getText().toString());
                User user = new User(session);
                initProgressBar();
                presenter.requestDataFromServer(user);
                presenter.onButtonClick(user);
            }
        });
    }
    private void initProgressBar() {
        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setGravity(Gravity.CENTER);
        relativeLayout.addView(progressBar);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        progressBar.setVisibility(View.INVISIBLE);

        this.addContentView(relativeLayout, params);
    }


    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(LoginActivity.this,
                "Something went wrong...Error message: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }
    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }


    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void login(Boolean success, Token token) {
        if (success) {
            Intent intent = new Intent(context, MainActivity.class);
            SharedPreferences sharedPreferences = getSharedPreferences("mysettings",
                    Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(getString(R.string.accessToken), token.getResponse().getAccessToken());
            editor.apply();
            Log.d(TAG, "login: token" + token.getResponse().getAccessToken());
            startActivity(intent);
        }
    }
}
