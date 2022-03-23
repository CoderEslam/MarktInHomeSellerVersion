package com.doubleclick.ViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.doubleclick.UserInter;
import com.doubleclick.marktinhome.Model.User;
import com.doubleclick.marktinhome.Repository.UserRepository;

import java.util.ArrayList;

/**
 * Created By Eslam Ghazy on 3/1/2022
 */
public class UserViewModel extends ViewModel implements UserInter {

    MutableLiveData<User> mutableLiveData = new MutableLiveData<>();
    MutableLiveData<ArrayList<User>> arrayListMutableLiveData = new MutableLiveData<>();
    UserRepository userRepository = new UserRepository(this);

    public UserViewModel() {
        userRepository.getUser();
    }

    public void getChatList() {
        userRepository.getAllUserChat();
    }

    public LiveData<User> getUser() {
        return mutableLiveData;
    }

    public LiveData<ArrayList<User>> getChatUser() {
        return arrayListMutableLiveData;
    }

    @Override
    public void ItemUser(User user) {
        mutableLiveData.setValue(user);
    }

    @Override
    public void AllUser(@Nullable ArrayList<User> users) {
        arrayListMutableLiveData.setValue(users);
    }

    @Override
    public void OnUserLisitner(@NonNull User user) {
        // nothing
    }
}