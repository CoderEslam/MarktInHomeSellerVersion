package com.doubleclick.marktinhome.RealmDatabase;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created By Eslam Ghazy on 4/25/2022
 */
@RealmClass
public class ChatRealm extends RealmObject {

    @PrimaryKey
    private String id;
    private String message;
    private String type;
    private String sender;
    private String receiver;
    private long date;
    private String StatusMessage;

}
