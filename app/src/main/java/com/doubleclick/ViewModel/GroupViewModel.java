package com.doubleclick.ViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.doubleclick.GroupInterface;
import com.doubleclick.marktinhome.Model.Group;
import com.doubleclick.marktinhome.Model.GroupData;
import com.doubleclick.marktinhome.Repository.GroupRepository;

import java.util.ArrayList;

/**
 * Created By Eslam Ghazy on 4/22/2022
 */
public class GroupViewModel extends ViewModel implements GroupInterface {


    GroupRepository repository = new GroupRepository(this);
    MutableLiveData<ArrayList<Group>> mutableLiveDataMyGrups = new MutableLiveData<>();

    MutableLiveData<ArrayList<Group>> mutableLiveDataAllGroups = new MutableLiveData<>();
    MutableLiveData<GroupData> mutableLiveGroupData = new MutableLiveData<>();

    public GroupViewModel() {
        repository.MyGroup();
        repository.AllGroup();
    }

    public void getGroupDataById(String id) {
        repository.getGroupDataById(id);
    }


    public LiveData<ArrayList<Group>> myGroups() {
        return mutableLiveDataMyGrups;
    }

    public LiveData<ArrayList<Group>> AllGroups() {
        return mutableLiveDataAllGroups;
    }

    public LiveData<GroupData> GroupData() {
        return mutableLiveGroupData;
    }

    @Override
    public void myGroups(@NonNull ArrayList<Group> groups) {
        mutableLiveDataMyGrups.setValue(groups);
    }

    @Override
    public void allGroups(@NonNull ArrayList<Group> groups) {
        mutableLiveDataAllGroups.setValue(groups);
    }

    @Override
    public void groupData(@NonNull GroupData group) {
        mutableLiveGroupData.setValue(group);
    }
}
