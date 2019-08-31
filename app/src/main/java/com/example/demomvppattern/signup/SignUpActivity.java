package com.example.demomvppattern.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demomvppattern.MainActivity;
import com.example.demomvppattern.R;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener, SignUpContract.view {
    private EditText mTextUserName, mTextPassWord;
    private Button mButtonSigUp;
    private  SignUpPresenter mSignUpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initView();
        initPresenter();
        registerListener();
    }


    private void initView() {
        mTextUserName = findViewById(R.id.edit_text_username);
        mTextPassWord = findViewById(R.id.edt_password);
        mButtonSigUp = findViewById(R.id.button_sign_up);
    }

    private void registerListener() {
        mButtonSigUp.setOnClickListener(this);
    }
    private void initPresenter() {
        mSignUpPresenter = new SignUpPresenter();
        mSignUpPresenter.setView(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_sign_up:
                signUp();
            default:
                break;
        }
    }

    private void signUp() {
       String username = mTextUserName.getText().toString();
       String password = mTextPassWord.getText().toString();
       if (username.isEmpty() || password.isEmpty() ){
           Toast.makeText(this, "TK & MK không được để rỗng", Toast.LENGTH_SHORT).show();
           return;
       }else {
           mSignUpPresenter.handleSignUp(username,password);
           // gọi thằng presenter để xử lý
       }

    }
    @Override
    public void signUpSuccess() {
        Toast.makeText(this, "Tạo tk thành công", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));

    }

    @Override
    public void signUpFailue(String error) {
        Toast.makeText(this, "Tạo tài khoản thất bại ", Toast.LENGTH_SHORT).show();

    }
}
