package com.unal.chatapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.unal.chatapp.Presenter.ChatPresenter;
import com.unal.chatapp.Presenter.UserListPresenter;
import com.unal.chatapp.Presenter.UserListPresenterImpl;
import com.unal.chatapp.model.MessageModel;
import com.unal.chatapp.model.UserModel;
import com.unal.chatapp.view.ChatContract;
import com.unal.chatapp.view.UserListContract;

import java.util.ArrayList;
import java.util.List;

public class Chat extends AppCompatActivity implements UserListContract, ChatContract {
    private ListView conversationsListView;
    private EditText messageEditText;
    private Button sendButton;
    private ListView listView;
    private EditText searchEmailEditText;
    private Button searchUserButton;
    private TextView textViewMiddleTitle;
    private CardView listViewChatUsuarios;
    private LinearLayout messageInputLayout;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private ChatPresenter chatPresenter;
    private UserListPresenter presenter;
    private List<UserModel> usersList = new ArrayList<>();
    private UserModel user1;
    private UserModel user2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        user1 = new UserModel();
        user2 = new UserModel();

        listView = findViewById(R.id.usersListView);
        searchEmailEditText = findViewById(R.id.searchEmailEditText);
        searchUserButton = findViewById(R.id.searchUserButton);

        textViewMiddleTitle = findViewById(R.id.textViewMiddleTitle);
        listViewChatUsuarios = findViewById(R.id.listViewChatUsuarios);
        messageInputLayout = findViewById(R.id.messageInputLayout);
        conversationsListView = findViewById(R.id.conversationsListView);
        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);

        presenter= new UserListPresenterImpl(this) {
        chatPresenter = new ChatPresenterImpl(this);
        };


    }

    @Override
    public void displayUser(List<UserModel> users) {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showConversations(List<MessageModel> conversations) {

    }

    @Override
    public void showMessageSentConfirmation() {

    }
}