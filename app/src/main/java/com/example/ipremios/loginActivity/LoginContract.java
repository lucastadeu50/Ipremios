package com.example.ipremios.loginActivity;

import com.example.ipremios.model.responsePost.Response;
import com.example.ipremios.model.responsePost.Token;
import com.example.ipremios.model.userLogin.User;

public interface LoginContract {

    /**
     * Call when user interact with the view and other when view OnDestroy()
     * */
    interface presenter{

        void onButtonClick(User user);

        void requestDataFromServer(User user);

    }

    /**
     * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
     * while the setDataToRecyclerView and onResponseFailure is fetched from the GetNoticeInteractorImpl class
     **/
    interface LoginView {
        void onResponseFailure(Throwable throwable);

        void showProgress();

        void hideProgress();

        void login(Boolean loginSucess, Token token);

    }

    /**
     * Intractors are classes built for fetching data from your database, web services, or any other data source.
     **/
    interface GetLoginIntractor {

        interface OnFinishedListener {
            void onFinished(Token token, boolean loginSuccess);//mudar
            void onFailure(Throwable t);
            void onLoginFailure(boolean loginSuccess);
        }

        void getLogin(OnFinishedListener onFinishedListener, User user);
    }
}
