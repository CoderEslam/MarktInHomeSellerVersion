package com.doubleclick.marktinhome.Notifications;

import androidx.annotation.NonNull;

import com.doubleclick.marktinhome.Model.Token;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//    implementation 'com.google.firebase:firebase-messaging:20.2.4' // implimt this

//import com.google.firebase.iid.FirebaseInstanceId;
//import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessagingService;


public class MyFirebaseIdService extends FirebaseMessagingService {

//    @Override
//    public void onTokenRefresh() {
//        super.onTokenRefresh();
//        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
//
//        String refreshToken = FirebaseInstanceId.getInstance().getToken();
//        if (firebaseUser != null){
//            updateToken(refreshToken);
//        }
//    }


    private void updateToken(String refreshToken) {
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Tokens");
        Token token = new Token(refreshToken);
        reference.child(firebaseUser.getUid()).setValue(token);
    }

    //https://stackoverflow.com/questions/51123197/firebaseinstanceidservice-is-deprecated
    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
//        String refreshToken = FirebaseInstanceId.getInstance().getToken();
        if (firebaseUser != null) {
            updateToken(s);
        }
    }
}