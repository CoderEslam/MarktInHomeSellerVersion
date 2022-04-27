package com.doubleclick.marktinhome.Repository;

import static com.doubleclick.marktinhome.BaseApplication.isNetworkConnected;
import static com.doubleclick.marktinhome.Model.Constantes.COMMENTS_GROUP;
import static com.doubleclick.marktinhome.Model.Constantes.USER;

import androidx.annotation.NonNull;

import com.doubleclick.marktinhome.Model.CommentsGroup;
import com.doubleclick.marktinhome.Model.CommentsGroupData;
import com.doubleclick.marktinhome.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

/**
 * Created By Eslam Ghazy on 4/27/2022
 */
public class CommentsGroupRepositotry extends BaseRepository {

    private ArrayList<CommentsGroupData> commentsGroupData = new ArrayList<>();
    private CommentsGroupData commentGroupData = new CommentsGroupData();
    private CommentData commentData;

    public CommentsGroupRepositotry(CommentData commentData) {
        this.commentData = commentData;
    }

    public void loadComments(String id) {
        reference.child(COMMENTS_GROUP).child(id).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                try {
                    if (isNetworkConnected()) {
                        if (task.getResult().exists()) {
                            for (DataSnapshot dataSnapshot : task.getResult().getChildren()) {
                                CommentsGroup commentsGroup = dataSnapshot.getValue(CommentsGroup.class);
                                commentGroupData.setCommentsGroup(commentsGroup);
                                reference.child(USER).child(commentsGroup.getUserId()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                                        User user = task.getResult().getValue(User.class);
                                        commentGroupData.setUser(user);
                                        commentsGroupData.add(commentGroupData);
                                        commentData.Comments(commentsGroupData);
                                    }
                                });
                            }
                        }
                    }
                } catch (Exception e) {

                }
            }
        });
    }

    public interface CommentData {
        void Comments(ArrayList<CommentsGroupData> commentsGroupData);
    }
}
