package com.doubleclick.marktinhome.Repository;

import static com.doubleclick.marktinhome.Model.Constantes.GROUPS;
import static com.doubleclick.marktinhome.Model.Constantes.POSTS;
import static com.doubleclick.marktinhome.Model.Constantes.USER;

import android.util.Log;

import androidx.annotation.NonNull;

import com.doubleclick.marktinhome.Model.PostData;
import com.doubleclick.marktinhome.Model.PostsGroup;
import com.doubleclick.marktinhome.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

/**
 * Created By Eslam Ghazy on 4/26/2022
 */
public class PostsRepository extends BaseRepository {

    private ArrayList<PostData> postData = new ArrayList<>();
    private PostInterface postInterface;


    public PostsRepository(PostInterface postInterface) {
        this.postInterface = postInterface;
    }

    public void AllPosts(String groupId) {
        reference.child(GROUPS).child(groupId).child(POSTS).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                DataSnapshot dataSnapshot = task.getResult();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    PostsGroup postsGroup = snapshot.getValue(PostsGroup.class);
                    reference.child(USER).child(postsGroup.getAdminId()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            User user = task.getResult().getValue(User.class);
                            postData.add(new PostData(postsGroup, user));
                            Log.e("postData", postData.toString());
                            postInterface.allPosts(postData);
                        }
                    });
                }

            }
        });
    }

    public interface PostInterface {
        void allPosts(ArrayList<PostData> postsGroups);
    }

}
