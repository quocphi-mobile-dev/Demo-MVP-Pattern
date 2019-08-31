package com.example.demomvppattern.signup;

public class SignUpPresenter implements  SignUpContract.presenter {

    private SignUpContract.view mView;

    public void setView(SignUpContract.view view){
        mView = view;
    }

    @Override
    public void handleSignUp(String username, String password) {
        // đúng thì làm gì đấy phải nói với view
        if (username.equals("quocphi") && password.equals("12345")){
            mView.signUpSuccess();
            return;
        }else {
            // sai thì làm gì đấy phải nói với view
            mView.signUpFailue(" Tk hoặc Mk k đúng ");
        }

    }
}
