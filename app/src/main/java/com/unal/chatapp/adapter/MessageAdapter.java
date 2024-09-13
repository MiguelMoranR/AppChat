package com.unal.chatapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.unal.chatapp.R;
import com.unal.chatapp.model.MessageModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.unal.chatapp.R;
import com.unal.chatapp.model.MessageModel;

public class MessageAdapter extends ArrayAdapter<MessageModel> {
    private Context mContext;
    private List<MessageModel> mMessages;

    public MessageAdapter(Context context,List<MessageModel> messages){
        super(context,0,messages);
        mContext = context;
        mMessages = messages;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View listItem = convertView;
        if(listItem == null){
            listItem = LayoutInflater.from(mContext).inflate(R.layout.item_message,parent,false);
        }
        MessageModel currentMessage = mMessages.get(position);

        TextView senderNameTextView = listItem.findViewById(R.id.senderNameTextView);
        TextView messageTextView = listItem.findViewById(R.id.messageTextView);
        TextView timestampTextView = listItem.findViewById(R.id.timestampTextView);

        senderNameTextView.setText(currentMessage.getSenderEmail());
        messageTextView.setText(currentMessage.getMessageText());

        String formattedTimestamp = formatTimestamp(currentMessage.getTimestamp());
        timestampTextView.setText(formattedTimestamp);

        return listItem;

    }

    private String formatTimestamp(Date timestamp){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault());
        return dateFormat.format(timestamp);
    }

}
