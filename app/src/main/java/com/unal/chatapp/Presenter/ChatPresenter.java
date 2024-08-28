package com.unal.chatapp.Presenter;

import com.unal.chatapp.model.UserModel;

public interface ChatPresenter {
    void loadConversations(UserModel user1, UserModel user2);
    void sendMessage(String messageText, UserModel user1, UserModel user2);

}
