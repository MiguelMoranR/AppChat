package com.unal.chatapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.unal.chatapp.Presenter.RegistroPresenter;
import com.unal.chatapp.model.RegistroModel;
import com.unal.chatapp.view.RegistroContract;

public class Registro extends AppCompatActivity implements RegistroContract.View{
    private EditText editTextName,editTextEmail,editTextPassword;
    private Button btnRegister;
    private TextView textViewLogin;
    private RegistroPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        editTextName = findViewById(R.id.usernameEditText);
        editTextEmail = findViewById(R.id.emailEditText);
        editTextPassword = findViewById(R.id.passwordEditText);
        btnRegister = findViewById(R.id.registerButton);
        textViewLogin = findViewById(R.id.loginText);

        presenter = new RegistroPresenter(this,new RegistroModel());

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.registerUser();

            }
        });
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToLogin();
            }
        });
    }

    public void showToast(String messege) {
        Toast.makeText(this,messege, Toast.LENGTH_SHORT).show();

    }
    public void clearInputFields(){
        editTextName.setText("");
        editTextEmail.setText("");
        editTextPassword.setText("");
    }

    @Override
    public void navigateToLogin() {
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
        finish();
    }

    @Override
    public String getName() {
        return editTextName.getText().toString().trim();
    }

    @Override
    public String getEmail() {
        return editTextEmail.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return editTextPassword.getText().toString().trim();
    }
}