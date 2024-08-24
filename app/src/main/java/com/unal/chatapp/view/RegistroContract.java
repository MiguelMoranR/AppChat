package com.unal.chatapp.view;

public class RegistroContract {
    interface view{
        void showToast(String message);
        void clearInputFields();
        void navigateToLogin();
        String getName();
        String getEmail();
        String getPassword();
    }

    public interface View {
    }
}
