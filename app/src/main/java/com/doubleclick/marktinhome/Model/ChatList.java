package com.doubleclick.marktinhome.Model;

/**
 * Created By Eslam Ghazy on 3/18/2022
 */
public class ChatList {

    private String id;

    public ChatList() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ChatList{" +
                "id='" + id + '\'' +
                '}';
    }
}
