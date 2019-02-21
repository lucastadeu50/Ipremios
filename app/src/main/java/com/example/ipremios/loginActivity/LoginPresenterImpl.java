package com.example.ipremios.loginActivity;

import com.example.ipremios.R;
import com.example.ipremios.model.responsePost.Token;
import com.example.ipremios.model.userLogin.User;

public class LoginPresenterImpl implements LoginContract.presenter, LoginContract.GetLoginIntractor.OnFinishedListener {

    private LoginContract.LoginView loginView;
    private LoginContract.GetLoginIntractor getLoginIntractor;

    public LoginPresenterImpl(LoginContract.LoginView loginViewView, LoginContract.GetLoginIntractor getLoginIntractor) {
        this.loginView = loginViewView;
        this.getLoginIntractor = getLoginIntractor;
    }


    @Override
    public void onButtonClick(User user) {

        if (loginView != null) {
            loginView.showProgress();
        }
        getLoginIntractor.getLogin(this, user);

    }


    @Override
    public void requestDataFromServer(User user) {
        getLoginIntractor.getLogin(this, user);
    }

    @Override
    public void onValidationSuccess(String email, String password) {
        if (loginView != null) {
            loginView.formValidation(email, password);
        }

    }


    @Override
    public void onFinished(Token token, boolean loginSuccess) {
        if (loginView != null) {
            loginView.login(loginSuccess, token);
            loginView.hideProgress();
        }
    }


    @Override
    public void onFailure(Throwable t) {
        if (loginView != null) {
            loginView.onResponseFailure(t);
            loginView.hideProgress();
        }
    }

    @Override
    public void onLoginFailure(boolean loginSuccess) {
        if (!loginSuccess) {
            loginView.hideProgress();
            loginView.onAuthFailure();

        }


    }

}
