package com.unal.chatapp.view;

import com.unal.chatapp.model.UserModel;

import java.util.List;

public interface UserListContract {
    void displayUsers(List<UserModel> users);

    void displayUser(List<UserModel> users);
    void showError(String message);
}
