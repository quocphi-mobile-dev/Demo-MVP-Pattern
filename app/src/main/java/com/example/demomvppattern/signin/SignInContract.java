package com.example.demomvppattern.signin;

public interface SignInContract {
    interface View {
        void signInSuccess();

        void signInFailure(String error);
    }

    interface Presenter {
        void handleSignIn(String username, String password);
    }
}