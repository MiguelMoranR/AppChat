package com.unal.chatapp.Presenter;

import com.google.firebase.auth.FirebaseUser;
import com.unal.chatapp.model.LoginModel;
import com.unal.chatapp.view.LoginContract;

public class LoginPresenter {
    private LoginContract.View view;
    private LoginModel model;
    public LoginPresenter(LoginContract.View view, LoginModel model){
        this.view = view;
        this.model= model;
    }
    public void loginUser(){
        String email = view.getEmail();
        String password = view.getPassword();
        if(email.isEmpty() || password.isEmpty()){
            view.showToast("Por favor, complete todos los campos");
            return;
        }
        model.loginUser(email, password, new LoginModel.LoginCallback(){

            @Override
            public void onSuccess(FirebaseUser user) {

                view.showToast("Inicio de sesión exitoso");
                view.navigateToHome();
            }

            @Override
            public void onFailure(Exception e) {
               view.showToast("Error de inicio de sesión: " + e.getMessage());
            }
        });
    }

}
