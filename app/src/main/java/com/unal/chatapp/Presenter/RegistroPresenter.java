package com.unal.chatapp.Presenter;

import com.google.firebase.auth.FirebaseUser;
import com.unal.chatapp.model.RegistroModel;
import com.unal.chatapp.view.LoginContract;
import com.unal.chatapp.view.RegistroContract;

import java.util.HashMap;
import java.util.Map;

public class RegistroPresenter {
    private RegistroContract.View view;
    private RegistroModel model;
    public RegistroPresenter(RegistroContract.View view, RegistroModel model){
        this.view = view;
        this.model = model;
     }
     public void registerUser(){
        String name = view.getName();
        String email = view.getEmail();
        String password = view.getPassword();

        if(name.isEmpty() || email.isEmpty() || password.isEmpty()){
            view.showToast("Por favor, completa todos los campos");
            return;
        }
        if(password.length() < 6){
            view.showToast("La contraseña debe tener al menos 6 caracteres");
            return;
        }
        model.registerUser(email, password, new RegistroModel.RegistroCallback() {
            @Override
            public void onSuccess(Object result) {
                FirebaseUser user = (FirebaseUser) result;
                Map<String,Object> userData = new HashMap<>();
                userData.put("name",name);
                userData.put("email",email);

                model.storeUserData(user, userData, new RegistroModel.RegistroCallback() {
                    @Override
                    public void onSuccess(Object result) {
                        view.showToast("Registro exitoso");
                        view.clearInputFields();
                        view.navigateToLogin();
                    }

                    @Override
                    public void onFailure(Exception e) {
                        view.showToast("Error al registrar en Firestore");
                    }
                });
            }

            @Override
            public void onFailure(Exception e) {
                view.showToast("Error al registrar usuario");
            }
        });
     }

}
