package com.example.demomvppattern.signup;

public interface SignUpContract  {
    interface view{
        void signUpSuccess ();
        void signUpFailue(String error);
    }
    interface  presenter {
        void handleSignUp(String username, String password);
    }
}
