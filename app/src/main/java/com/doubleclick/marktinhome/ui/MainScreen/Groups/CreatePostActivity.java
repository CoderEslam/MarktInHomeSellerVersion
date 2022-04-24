package com.doubleclick.marktinhome.ui.MainScreen.Groups;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.doubleclick.marktinhome.Adapters.ImagesGroupAdapter;
import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.Views.carousellayoutmanager.CarouselLayoutManager;
import com.doubleclick.marktinhome.Views.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.doubleclick.marktinhome.Views.carousellayoutmanager.CenterScrollListener;
import com.doubleclick.marktinhome.Views.socialtextview.SocialTextView;
import com.doubleclick.marktinhome.Views.socialtextview.widget.SocialEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CreatePostActivity extends AppCompatActivity {

    private static final int IMAGE_REQUEST = 100;
    // TODo id of Group
    private String id;
    private CircleImageView myImage;
    private TextView myName;
    private SocialEditText postText;
    private RecyclerView imageRecycler;
    private VideoView video;
    private ImageView addImages, addVideo;
    private Button postbtn;
    private ArrayList<Uri> uris = new ArrayList<>();
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);
        id = getIntent().getStringExtra("id");
        myImage = findViewById(R.id.myImage);
        myName = findViewById(R.id.myName);
        postText = findViewById(R.id.postText);
        imageRecycler = findViewById(R.id.imageRecycler);
        video = findViewById(R.id.video);
        addImages = findViewById(R.id.addImages);
        addVideo = findViewById(R.id.addVideo);
        postbtn = findViewById(R.id.postbtn);
        reference = FirebaseDatabase.getInstance().getReference();
        CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL);
        imageRecycler.setLayoutManager(layoutManager);
        imageRecycler.setHasFixedSize(true);
        imageRecycler.addOnScrollListener(new CenterScrollListener());
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        addImages.setOnClickListener(v -> {
            openImage("image/*");
        });
        addVideo.setOnClickListener(v -> {
            openImage("video/*");
        });
    }

    public void openImage(String mime) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType(mime);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        startActivityForResult(intent, IMAGE_REQUEST);
    }

    public String getFileExtension(Uri uri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            ClipData clipData = data.getClipData();
            if (clipData != null) {
                for (int i = 0; i < clipData.getItemCount(); i++) {
                    ClipData.Item item = clipData.getItemAt(i);
                    uris.add(item.getUri());
                }
                imageRecycler.setAdapter(new ImagesGroupAdapter(uris, "uri"));
            }
        }
    }

    private void UploadPost(){




    }
}