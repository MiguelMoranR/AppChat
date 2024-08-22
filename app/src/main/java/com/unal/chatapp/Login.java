package com.unal.chatapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.unal.chatapp.view.LoginContract;

public class Login extends AppCompatActivity implements LoginContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    @Override
    public void showToast(String message) {
        
    }

    @Override
    public void navigateToHome() {

    }

    @Override
    public String getEmail() {
        return "";
    }

    @Override
    public String getPassword() {
        return "";
    }
}