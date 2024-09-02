package com.unal.chatapp.model;

import java.util.List;

public class UserModel {
    private String userId;
    private String email;
    private String name;
    private List<String> messageIds;

    public UserModel() {
    }

    public UserModel(String userId, String email, String name) {
        this.userId = userId;
        this.email = email;
        this.name = name;
    }

    public List<String> getMessageIds() {
        return messageIds;
    }

    public void setMessageIds(List<String> messageIds) {
        this.messageIds = messageIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}