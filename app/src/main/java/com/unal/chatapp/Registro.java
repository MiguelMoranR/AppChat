package com.unal.chatapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.unal.chatapp.view.RegistroContract;
import com.unal.chatapp.view.RegistroContract.View;

public class Registro extends AppCompatActivity implements RegistroContract.View{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


    }

    @Override
    public void showToast(String message) {

    }

    @Override
    public void clearInputFields() {

    }

    @Override
    public void navigateToLogin() {

    }

    @Override
    public String getName() {
        return "";
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