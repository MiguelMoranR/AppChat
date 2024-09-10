package com.unal.chatapp;

import static android.app.ProgressDialog.show;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.unal.chatapp.Presenter.ChatPresenter;
import com.unal.chatapp.Presenter.ChatPresenterImpl;
import com.unal.chatapp.Presenter.UserListPresenter;
import com.unal.chatapp.Presenter.UserListPresenterImpl;
import com.unal.chatapp.adapter.MessageAdapter;
import com.unal.chatapp.adapter.UserAdapter;
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

        presenter= new UserListPresenterImpl(this);
        chatPresenter = new ChatPresenterImpl(this);

        presenter.loadUsers();

        searchUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchUser();

            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String message = messageEditText.getText().toString().trim();
        if(message.isEmpty()){
            chatPresenter.sendMessage(message,user1,user2);
            messageEditText.setText("");
        }else {
           Toast.makeText(Chat.this,"Por favor ingresa un mensaje",Toast.LENGTH_SHORT).show();

        }
    }

    private void searchUser() {
        String emailToSearch = searchEmailEditText.getText().toString().trim();
        List<UserModel> foundUser = new ArrayList<>();

        for(UserModel user: usersList){
            if(user.getEmail().equalsIgnoreCase(emailToSearch)){
                foundUser.add(user);
            }
        }
        if(!foundUser.isEmpty()){
            UserAdapter.ChatButtonClickListener listener = new UserAdapter.ChatButtonClickListener() {
                @Override
                public void onChatButtonClick(UserModel user) {
                    handleChatButtonClick(user);
                    
                }
            };

            UserAdapter adapter = new UserAdapter(this,foundUser,listener);
            listView.setAdapter(adapter);
        }else {
            Toast.makeText(this,"No encontrado",Toast.LENGTH_SHORT).show();
        }

    }

    private void handleChatButtonClick(UserModel user) {
        if(currentUser !=null){
            user1.setUserId(currentUser.getUid());
            user1.setEmail(currentUser.getEmail());
            user1.setName(currentUser.getDisplayName());
            user2 = user;
            chatPresenter.loadConversations(user1,user2);
            Toast.makeText(Chat.this,  "Ok, alla vamos!",Toast.LENGTH_SHORT).show();
            showChatInterface();

        }else {
            Toast.makeText(this,"No encontrado",Toast.LENGTH_SHORT).show();
        }
    }

    private void showChatInterface() {
        textViewMiddleTitle.setVisibility(View.VISIBLE);
        listViewChatUsuarios.setVisibility(View.VISIBLE);
        messageInputLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void displayUser(List<UserModel> users) {
        usersList = users;
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showConversations(List<MessageModel> conversations) {
        MessageAdapter adapter = new MessageAdapter(this, conversations);
        conversationsListView.setAdapter(adapter);
    }

    @Override
    public void showMessageSentConfirmation() {
        Toast.makeText(this, "Mensaje enviado correctamente", Toast.LENGTH_SHORT).show();
    }
}