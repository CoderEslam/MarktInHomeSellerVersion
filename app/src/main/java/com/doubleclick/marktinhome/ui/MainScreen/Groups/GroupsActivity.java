package com.doubleclick.marktinhome.ui.MainScreen.Groups;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.doubleclick.ViewModel.GroupViewModel;
import com.doubleclick.marktinhome.Model.GroupData;
import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.Views.socialtextview.SocialTextView;
import com.doubleclick.marktinhome.ui.MainScreen.MainScreenActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.todkars.shimmer.ShimmerRecyclerView;

import java.text.SimpleDateFormat;

import de.hdodenhof.circleimageview.CircleImageView;

public class GroupsActivity extends AppCompatActivity {


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        // id of Group
        id = getIntent().getStringExtra("id");
        back = findViewById(R.id.back);
        cover = findViewById(R.id.cover);
        editName = findViewById(R.id.editName);
        imageGroup = findViewById(R.id.imageGroup);
        progressIndicator = findViewById(R.id.progressBar);
        name = findViewById(R.id.name);
        postsNum = findViewById(R.id.postsNum);
        username = findViewById(R.id.username);
        history = findViewById(R.id.history);
        // todo show when there is nothing to show
        nothing = findViewById(R.id.nothing);
        bio = findViewById(R.id.bio);
        link = findViewById(R.id.link);
        post = findViewById(R.id.post);
        editCover = findViewById(R.id.editCover);
        editProfile = findViewById(R.id.editProfile);
        groupViewModel = new ViewModelProvider(this).get(GroupViewModel.class);
        groupViewModel.getGroupDataById(id);
        groupViewModel.GroupData().observe(this, new Observer<GroupData>() {
            @Override
            public void onChanged(GroupData groupData) {
                Glide.with(GroupsActivity.this).load(groupData.getGroup().getImage()).into(imageGroup);
                Glide.with(GroupsActivity.this).load(groupData.getGroup().getCover()).into(cover);
                name.setText(groupData.getGroup().getName());
                username.setText(groupData.getGroup().getCreatedBy());
                @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MM yyyy HH:mm:ss aaa");
                history.setText(String.format("Created By %s at %s ", groupData.getGroup().getCreatedBy(), simpleDateFormat.format(groupData.getGroup().getTime())));
                link.setText(groupData.getGroup().getLink());
            }
        });
        post.showShimmer();
        create_post = findViewById(R.id.create_post);
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
            openBottomSheet();
        });

    }

    public void openImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE_REQUEST);
    }

    private void openBottomSheet() {
        BottomSheetEditor bottomSheetFragmentUsernameAndBioUpdate = new BottomSheetEditor();
        assert getFragmentManager() != null;
        bottomSheetFragmentUsernameAndBioUpdate.show(getSupportFragmentManager(), "edit");
    }


}