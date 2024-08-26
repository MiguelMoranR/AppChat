package com.unal.chatapp.view;

public interface RegistroContract {
    public interface View{
            void showToast(String message);
            void clearInputFields();
            void navigateToLogin();
            String getName();
            String getEmail();
            String getPassword();
        }

    }


