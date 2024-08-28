package com.unal.chatapp.view;

import com.unal.chatapp.model.MessageModel;

import java.util.List;

public interface ChatContract {
    void showConversations(List<MessageModel> conversations);
    void showMessageSentConfirmation();
}
