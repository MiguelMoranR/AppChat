package com.unal.chatapp.Presenter;

import android.util.Log;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.unal.chatapp.model.MessageModel;
import com.unal.chatapp.model.UserModel;
import com.unal.chatapp.view.ChatContract;

import java.util.ArrayList;
import java.util.List;

public class ChatPresenterImpl implements ChatPresenter{
    private ChatContract view;
    private UserModel user1;
    private UserModel user2;
    private String conversationId;
    public ChatPresenterImpl(ChatContract view){
        this.view = view;
    }

    @Override
    public void loadConversations(UserModel user1, UserModel user2) {
        this.user1 = user1;
        this.user2 = user2;
        if(user1.getEmail().compareTo(user2.getEmail()) < 0){
           conversationId = user1.getEmail()+"_"+user2.getEmail();
        }else {
            conversationId = user2.getEmail()+"_"+user2.getEmail();
        }
        FirebaseFirestore.getInstance().collection("conversations")
                .document(conversationId)
                .collection("messages")
                .orderBy("timestamp", Query.Direction.DESCENDING)
                .addSnapshotListener((queryDocumentSnapshots,e)->{
                    if(e != null){
                        Log.e(TAG, "Error al cargar las conversaciones: ",e);
                        return;
                    }
                    List<MessageModel> conversationMessages = new ArrayList<>();
                    if(queryDocumentSnapshots != null){
                        for (QueryDocumentSnapshot document: queryDocumentSnapshots){
                            MessageModel message = document.toObject(MessageModel.class);
                            conversationMessages.add(message);
                        }
                    }
                    if (view != null){
                       view.showConversations(conversationMessages);
                    }
                });
    }

    @Override
    public void sendMessage(String messageText, UserModel user1, UserModel user2) {
        if(user1 != null && user2 != null){
            String conversationId = generateConversationId(user1.getEmail(),user2.getEmail());
            CollectionReference messageRef = FirebaseFirestore.getInstance()
                    .collection("conversations")
                    .document(conversationId)
                    .collection("messages");

            MessageModel message = createMessageModel(user1,messageText);

        }
    }

    private MessageModel createMessageModel(UserModel user1, String messageText) {


    }

    private String generateConversationId(String email1, String email2) {
        return email1.compareTo(email2) < 0 ? email1 + "_" + email2: email2 + "_" + email1;
    }
}
