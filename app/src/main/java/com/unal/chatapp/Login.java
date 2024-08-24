package com.unal.chatapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.unal.chatapp.Presenter.LoginPresenter;
import com.unal.chatapp.model.LoginModel;
import com.unal.chatapp.view.LoginContract;

public class Login extends AppCompatActivity implements LoginContract.View {

    private EditText editTextEmail, editTextPassword;
    private Button btnLogin;
    private TextView registerText;
    private LoginPresenter presenter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.emailEditText);
        editTextPassword = findViewById(R.id.passwordEditText);
        btnLogin = findViewById(R.id.loginButton);
        registerText = findViewById(R.id.registerText);

        presenter = new LoginPresenter(this, new LoginModel());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loginUser();
            }
        });

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              navigateToRegistration();
            }
        });
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent( this,Chat.class);
        startActivity(intent);
        finish();
    }

    @Override
    public String getEmail() {
        return editTextEmail.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return editTextPassword.getText().toString().trim();
    }

    private void navigateToRegistration() {
        Intent intent = new Intent(Login.this, Registro.class);
        startActivity(intent);
        finish();
    }
}