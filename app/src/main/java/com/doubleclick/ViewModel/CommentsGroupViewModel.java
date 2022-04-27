package com.doubleclick.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.doubleclick.marktinhome.Model.CommentsGroupData;
import com.doubleclick.marktinhome.Repository.CommentsGroupRepositotry;

import java.util.ArrayList;

/**
 * Created By Eslam Ghazy on 4/27/2022
 */
public class CommentsGroupViewModel extends ViewModel implements CommentsGroupRepositotry.CommentData {

    MutableLiveData<ArrayList<CommentsGroupData>> mutableLiveData = new MutableLiveData<>();
    CommentsGroupRepositotry commentsGroupRepositotry = new CommentsGroupRepositotry(this);

    public CommentsGroupViewModel() {
    }

    public void GetComments(String id) {
        commentsGroupRepositotry.loadComments(id);
    }

    public LiveData<ArrayList<CommentsGroupData>> getCommentsLiveData() {
        return mutableLiveData;
    }


    @Override
    public void Comments(ArrayList<CommentsGroupData> commentsGroupData) {
        mutableLiveData.setValue(commentsGroupData);
    }
}
