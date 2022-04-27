package com.doubleclick.marktinhome.ui.MainScreen.Groups;

import static com.doubleclick.marktinhome.Model.Constantes.CHILDREN;
import static com.doubleclick.marktinhome.Model.Constantes.GROUPS;
import static com.doubleclick.marktinhome.Model.Constantes.PARENTS;
import static com.doubleclick.marktinhome.Model.Constantes.POSTS;
import static com.doubleclick.marktinhome.Model.Constantes.USER;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.doubleclick.ViewModel.PostsViewModel;
import com.doubleclick.ViewModel.UserViewModel;
import com.doubleclick.marktinhome.Adapters.ImagesGroupAdapter;
import com.doubleclick.marktinhome.Model.PostsGroup;
import com.doubleclick.marktinhome.Model.Product;
import com.doubleclick.marktinhome.Model.User;
import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.Views.carousellayoutmanager.CarouselLayoutManager;
import com.doubleclick.marktinhome.Views.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.doubleclick.marktinhome.Views.carousellayoutmanager.CenterScrollListener;
import com.doubleclick.marktinhome.Views.socialtextview.SocialTextView;
import com.doubleclick.marktinhome.Views.socialtextview.widget.SocialEditText;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class CreatePostActivity extends AppCompatActivity {

    private static final int IMAGE_REQUEST = 100;
    // TODO id of Group
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
    private UserViewModel userViewModel;
    private User user;
    private StorageTask uploadTask;
    private StorageReference storageReference;
    private ArrayList<String> urls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);
        id = getIntent().getStringExtra("id" /* group id*/);
        myImage = findViewById(R.id.myImage);
        myName = findViewById(R.id.myName);
        postText = findViewById(R.id.postText);
        imageRecycler = findViewById(R.id.imageRecycler);
        video = findViewById(R.id.video);
        addImages = findViewById(R.id.addImages);
        addVideo = findViewById(R.id.addVideo);
        postbtn = findViewById(R.id.postbtn);
        reference = FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference().child("Posts");
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User u) {
                user = u;
                Glide.with(CreatePostActivity.this).load(u.getImage()).into(myImage);
                myName.setText(u.getName());
            }
        });

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

        postbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
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


    private void UploadPost() {
        HashMap<String, Object> map = new HashMap<>();
        String Pushid = reference.push().getKey().toString();
        map.put("adminId", user.getId());
        map.put("id", Pushid);
        map.put("time", new Date().getTime());
        map.put("text", postText.getText().toString());
        map.put("type", "image");
        map.put("images", urls.toString());
        map.put("video", "");
        map.put("groupId", id);
        reference.child(GROUPS).child(id).child(POSTS).child(Pushid).updateChildren(map);
    }


    public void uploadImage() {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Uploading");
        pd.show();
        if (uris.size() != 0) {
            for (int i = 0; i < uris.size(); i++) {
                final StorageReference fileReference = storageReference.child(System.currentTimeMillis() + "." + getFileExtension(uris.get(i)));
                uploadTask = fileReference.putFile(uris.get(i));
                uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if (!task.isSuccessful()) {
                            throw task.getException();
                        }
                        return fileReference.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()) {
                            Uri downloadUri = task.getResult();
                            String url = downloadUri.toString();
                            urls.add(url);
                            if (urls.size() == uris.size()) {
                                UploadPost();
                            }
                            pd.dismiss();
                        } else {
                            Toast.makeText(CreatePostActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
                            pd.dismiss();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(CreatePostActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        pd.dismiss();
                    }
                });
            }
        } else {
            Toast.makeText(CreatePostActivity.this, "No image selected", Toast.LENGTH_SHORT).show();
        }
    }
}