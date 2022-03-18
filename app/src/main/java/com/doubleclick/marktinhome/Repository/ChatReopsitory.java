package com.doubleclick.marktinhome.Repository;

import static com.doubleclick.marktinhome.BaseApplication.isNetworkConnected;
import static com.doubleclick.marktinhome.Model.Constantes.CHATS;

import android.util.Log;

import androidx.annotation.NonNull;

import com.doubleclick.marktinhome.Model.Chat;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created By Eslam Ghazy on 3/17/2022
 */
public class ChatReopsitory extends BaseRepository {

    private ArrayList<Chat> myChats = new ArrayList<>();
    private Chats chats;

    public ChatReopsitory(Chats chats) {
        this.chats = chats;
    }

    public void getChats(String userId) {
        reference.child(CHATS).orderByChild("date").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try {
                    if (isNetworkConnected()) {
                        if (snapshot.exists()) {
                            myChats.clear();
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                Chat chat = dataSnapshot.getValue(Chat.class);
                                if ((chat.getReceiver().equals(myId) && chat.getSender().equals(userId)) || (chat.getSender().equals(myId) && chat.getReceiver().equals(userId))) {
                                    myChats.add(chat);
                                    Log.e("chat", chat.toString());
                                }
                            }
                            chats.getChat(myChats);
                        }
                    }

                } catch (Exception e) {
                    Log.e("ExceptionChat", e.getMessage());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public interface Chats {
        void getChat(ArrayList<Chat> chats);
    }


}
