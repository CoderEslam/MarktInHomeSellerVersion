package com.doubleclick.ViewHolder;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.doubleclick.marktinhome.Model.Chat;
import com.doubleclick.marktinhome.R;


/**
 * Created By Eslam Ghazy on 2/5/2022
 */
public class MessageTextViewHolder extends BaseViewHolder {

    public TextView textMessage ,textTime;
//    public ImageView profile_image;
//    public TextView txt_seen;
//    public ImageView image_message;

    public MessageTextViewHolder(View itemView) {
        super(itemView);
        textMessage = itemView.findViewById(R.id.textMessage);
        textTime = itemView.findViewById(R.id.textTime);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) itemView.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                clipboardManager.setText(textMessage.getText());
                Toast.makeText(itemView.getContext(), itemView.getResources().getString(R.string.text_copied), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void SetTextMessage(Chat chat, int postion){
        textMessage.setText(chat.getMessage());
    }
}
