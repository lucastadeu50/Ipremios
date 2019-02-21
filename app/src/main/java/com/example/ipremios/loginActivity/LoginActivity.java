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

    String email = "";
    String password = "";


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
                email = textInputEmail.getText().toString();
                password = textInputPassword.getText().toString();
                presenter.onValidationSuccess(email, password);

                if(isEmailValid(email) && isPasswordValid(password)) {
                    Session session = new Session(password,email);
                    User user = new User(session);
                    initProgressBar();
                    presenter.requestDataFromServer(user);
                    presenter.onButtonClick(user);
                }

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


    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 5;
    }


    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(LoginActivity.this,
                "Something went wrong...Error message: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }
    @Override
    public  void onAuthFailure(){
        Toast.makeText(context, getString(R.string.error_incorrect_password_email), Toast.LENGTH_SHORT).show();
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
            startActivity(intent);
        }
    }

    @Override
    public void formValidation(String email, String password) {

        if (email.equals("")){
            textInputEmail.setError(getString(R.string.error_field_required));
            textInputEmail.requestFocus();
        }
        else if(!isEmailValid(email)){
            textInputEmail.setError(getString(R.string.error_invalid_email));
            textInputEmail.requestFocus();
        }
        else if (password.equals("")){
            textInputPassword.setError(getString(R.string.error_field_required));
            textInputPassword.requestFocus();
        }
        else if (!isPasswordValid(password)){
            textInputPassword.setError(getString(R.string.error_invalid_password));
            textInputPassword.requestFocus();
        }
    }
}
