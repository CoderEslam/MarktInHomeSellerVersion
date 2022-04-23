package com.doubleclick.marktinhome.Repository;

import static com.doubleclick.marktinhome.BaseApplication.isNetworkConnected;
import static com.doubleclick.marktinhome.Model.Constantes.GROUPS;

import android.util.Log;

import androidx.annotation.NonNull;

import com.doubleclick.GroupInterface;
import com.doubleclick.marktinhome.Model.Group;
import com.doubleclick.marktinhome.Model.GroupData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

/**
 * Created By Eslam Ghazy on 4/22/2022
 */
public class GroupRepository extends BaseRepository {

    private GroupInterface groupInterface;
    private ArrayList<Group> myGroups = new ArrayList<>();
    private ArrayList<Group> allGroups = new ArrayList<>();
    private GroupData groupData;

    public GroupRepository(GroupInterface groupInterface) {
        this.groupInterface = groupInterface;
    }

    public void MyGroup() {
        reference.child(GROUPS).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                try {
                    if (isNetworkConnected()) {
                        if (task.getResult().exists()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                Group group = snapshot.getValue(Group.class);
                                assert group != null;
                                if (group.getCreatedBy().equals(myId)) {
                                    myGroups.add(group);
                                }
                            }
                            groupInterface.myGroups(myGroups);
                        }
                    }
                } catch (Exception e) {
                    Log.e("Exception", e.getMessage());
                }
            }
        });

    }

    public void AllGroup() {
        reference.child(GROUPS).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                try {
                    if (isNetworkConnected()) {
                        if (task.getResult().exists()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                Group group = snapshot.getValue(Group.class);
                                if (!group.getCreatedBy().equals(myId)) {
                                    allGroups.add(group);
                                }
                            }
                            groupInterface.allGroups(allGroups);
                        }

                    }
                } catch (Exception e) {
                    Log.e("Exception", e.getMessage());
                }
            }
        });
    }

    public void getGroupDataById(String id) {
        Log.e("iddddddddddddddd",id);
        reference.child(GROUPS).child(id).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                try {
                    if (isNetworkConnected()) {
                        if (task.getResult().exists()) {
                                Group group = task.getResult().getValue(Group.class);
                                groupData = new GroupData(group);
                                Log.e("fffffffffffffff",groupData.toString());
                            groupInterface.groupData(groupData);
                        }
                    }
                } catch (Exception e) {
                    Log.e("Exception", e.getMessage());
                }
            }
        });
    }

}
