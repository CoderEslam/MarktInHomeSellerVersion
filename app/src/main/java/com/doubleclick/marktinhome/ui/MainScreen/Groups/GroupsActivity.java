package com.doubleclick.marktinhome.ui.MainScreen.Groups;

import static com.doubleclick.marktinhome.Model.Constantes.GROUPS;
import static com.doubleclick.marktinhome.Model.Constantes.POSTS;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.doubleclick.ViewModel.GroupViewModel;
import com.doubleclick.ViewModel.PostsViewModel;
import com.doubleclick.marktinhome.Adapters.GroupsAdapter;
import com.doubleclick.marktinhome.Model.GroupData;
import com.doubleclick.marktinhome.Model.PostData;
import com.doubleclick.marktinhome.Model.PostsGroup;
import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.Views.socialtextview.SocialTextView;
import com.doubleclick.marktinhome.ui.MainScreen.MainScreenActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.todkars.shimmer.ShimmerRecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class GroupsActivity extends AppCompatActivity implements GroupsAdapter.Loadmore, GroupsAdapter.OptionPost {


    private static final int IMAGE_REQUEST = 100;
    private String id;
    private ImageView back, cover, editName;
    private CircleImageView imageGroup;
    private LinearProgressIndicator progressIndicator;
    private TextView name, postsNum, username, history, nothing;
    private FloatingActionButton editCover, editProfile;
    private SocialTextView bio, link;
    private LinearLayout create_post;
    private ShimmerRecyclerView post;
    private GroupViewModel groupViewModel;
    private PostsViewModel postsViewModel;
    private GroupsAdapter groupsAdapter;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        // id of Group
        id = getIntent().getStringExtra("id" /* id of group*/);
        back = findViewById(R.id.back);
        cover = findViewById(R.id.cover);
        editName = findViewById(R.id.editName);
        imageGroup = findViewById(R.id.imageGroup);
        progressIndicator = findViewById(R.id.progressBar);
        name = findViewById(R.id.name);
        postsNum = findViewById(R.id.postsNum);
        username = findViewById(R.id.username);
        history = findViewById(R.id.history);
        reference = FirebaseDatabase.getInstance().getReference();
        // todo show when there is nothing to show
        nothing = findViewById(R.id.nothing);
        bio = findViewById(R.id.bio);
        link = findViewById(R.id.link);
        post = findViewById(R.id.post);
        create_post = findViewById(R.id.create_post);
        editCover = findViewById(R.id.editCover);
        editProfile = findViewById(R.id.editProfile);
        groupViewModel = new ViewModelProvider(this).get(GroupViewModel.class);
        postsViewModel = new ViewModelProvider(this).get(PostsViewModel.class);
        postsViewModel.loadPosts(id /*  Group Id */, 1000);
        groupViewModel.getGroupDataById(id);
        groupViewModel.GroupData().observe(this, new Observer<GroupData>() {
            @Override
            public void onChanged(GroupData groupData) {
                Glide.with(GroupsActivity.this).load(groupData.getGroup().getImage()).into(imageGroup);
                Glide.with(GroupsActivity.this).load(groupData.getGroup().getCover()).into(cover);
                name.setText(groupData.getGroup().getName());
                username.setText(groupData.getUser().getName());
                @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd/MM/yyyy HH:mm aa");
                history.setText(String.format("Created By %s at %s ", groupData.getUser().getName(), simpleDateFormat.format(groupData.getGroup().getTime())));
                link.setText(groupData.getGroup().getLink());
            }
        });
        post.showShimmer();
        postsViewModel.getPosts().observe(this, new Observer<ArrayList<PostData>>() {
            @Override
            public void onChanged(ArrayList<PostData> postData) {
                if (postData.size() != 0) {
                    progressIndicator.setVisibility(View.GONE);
                    postsNum.setText(String.valueOf(postData.size()));
                    groupsAdapter = new GroupsAdapter(postData, GroupsActivity.this, GroupsActivity.this);
                    post.setAdapter(groupsAdapter);
                    post.hideShimmer();
                }


                for (int i = 0; i <= 1000; i++) {
                    Log.e("IIIIIIII", "" + i);
                }

            }
        });

        create_post.setOnClickListener(v -> {
            Intent intent = new Intent(GroupsActivity.this, CreatePostActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        });
        back.setOnClickListener(v -> {
            startActivity(new Intent(GroupsActivity.this, MainScreenActivity.class));
            finish();
        });
        editCover.setOnClickListener(v -> {
            openImage();
        });

        editProfile.setOnClickListener(v -> {
            openImage();
        });
        editName.setOnClickListener(v -> {
            openBottomSheet(id /*group id */);
        });

    }

    public void openImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE_REQUEST);
    }

    private void openBottomSheet(String id) {
        BottomSheetEditor bottomSheetFragmentUsernameAndBioUpdate = new BottomSheetEditor(id);
        assert getFragmentManager() != null;
        bottomSheetFragmentUsernameAndBioUpdate.show(getSupportFragmentManager(), "edit");
    }

    @Override
    public void loadmore(int num) {
        postsViewModel.loadPosts(id /*  Group Id */, num);
    }

    @Override
    public void delete(String id) {
        reference.child(GROUPS).child(id/* group id */).child(POSTS).child(id);
        Toast.makeText(GroupsActivity.this, "" + id, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void edit(String id) {
        Toast.makeText(GroupsActivity.this, "" + id, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void save(String id) {
        Toast.makeText(GroupsActivity.this, "" + id, Toast.LENGTH_SHORT).show();

    }
}