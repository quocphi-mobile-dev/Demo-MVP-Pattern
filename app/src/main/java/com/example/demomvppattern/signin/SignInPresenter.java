package com.example.demomvppattern.signin;

public class SignInPresenter implements SignInContract.Presenter {

    private SignInContract.View mView;

    public void setView(SignInContract.View view) {
        mView = view;
    }

    @Override
    public void handleSignIn(String username, String password) {
        // giả sữ đây là quá trình làm việc với model
        // và chỉ có account với username là mvpexample vs password
        // là 1234 login được chẳng hạn.
        if (username.equals("mvpexample") && password.equals("1234")) {
            mView.signInSuccess();
            return;
        }

        mView.signInFailure("Username or Password not true!");
    }
}
