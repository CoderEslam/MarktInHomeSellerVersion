package com.doubleclick.marktinhome.Repository;

import static com.doubleclick.marktinhome.BaseApplication.isNetworkConnected;
import static com.doubleclick.marktinhome.Model.Constantes.CHATS;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.doubleclick.marktinhome.Model.Chat;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
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
//        reference.child(CHATS).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                try {
//                    if (isNetworkConnected()) {
//                        DataSnapshot snapshot = task.getResult();
//                        if (snapshot.exists()) {
//                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                                Chat chat = dataSnapshot.getValue(Chat.class);
//                                assert chat != null;
//                                if ((chat.getReceiver().equals(myId) && chat.getSender().equals(userId)) || (chat.getSender().equals(myId) && chat.getReceiver().equals(userId))) {
//                                    myChats.add(chat);
//                                    Log.e("chat", chat.toString());
//                                }
//                            }
//                            chats.getChat(myChats);
//                        }
//                    }
//                } catch (Exception e) {
//                    Log.e("ExceptionChat", e.getMessage());
//                }
//            }
//        });

        reference.child(CHATS).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Chat chat = snapshot.getValue(Chat.class);
                Log.e("onChildAdded", snapshot.getValue(Chat.class).toString());
                assert chat != null;
                Log.e("newInsert", chat.toString());
                if ((chat.getReceiver().equals(myId) && chat.getSender().equals(userId)) || (chat.getSender().equals(myId) && chat.getReceiver().equals(userId))) {
                    chats.newInsertChat(chat);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.e("onChildChanged", snapshot.getValue(Chat.class).toString());
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public interface Chats {
        void getChat(ArrayList<Chat> chats);

        void newInsertChat(Chat chat);
    }


}
