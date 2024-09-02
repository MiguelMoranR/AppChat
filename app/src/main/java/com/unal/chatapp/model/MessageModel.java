package com.unal.chatapp.model;

import java.util.Date;

public class MessageModel {
    public Object getMessageId;
    private String messageId;
    private String messageText;
    private String senderId;
    private String senderName;
    private Date timestamp;
    private String senderEmail;
    public MessageModel(){

    }

    public MessageModel(String messageId, String messageText, String senderId, String senderName, Date timestamp) {
        this.messageId = messageId;
        this.messageText = messageText;
        this.senderId = senderId;
        this.senderName = senderName;
        this.timestamp = timestamp;
    }

    public MessageModel(String messageId, String messageText, String senderId, String senderName, Date timestamp, String senderEmail) {
        this.messageId = messageId;
        this.messageText = messageText;
        this.senderId = senderId;
        this.senderName = senderName;
        this.timestamp = timestamp;
        this.senderEmail = senderEmail;
    }

    public String messageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String messageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String senderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String senderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Date timestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String senderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getMessageId() {return messageId;
    }
}
