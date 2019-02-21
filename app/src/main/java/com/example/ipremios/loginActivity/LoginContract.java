package com.example.ipremios.loginActivity;

import com.example.ipremios.model.responsePost.Response;
import com.example.ipremios.model.responsePost.Token;
import com.example.ipremios.model.userLogin.User;

public interface LoginContract {


    interface presenter {

        void onButtonClick(User user);

        void requestDataFromServer(User user);

        void onValidationSuccess(String email, String password);

    }

    interface LoginView {
        void onResponseFailure(Throwable throwable);

        void onAuthFailure();

        void showProgress();

        void hideProgress();

        void login(Boolean loginSucess, Token token);

        void formValidation(String email, String password);

    }

    interface GetLoginIntractor {

        interface OnFinishedListener {
            void onFinished(Token token, boolean loginSuccess);

            void onFailure(Throwable t);

            void onLoginFailure(boolean loginSuccess);
        }

        void getLogin(OnFinishedListener onFinishedListener, User user);
    }
}
