package com.doubleclick.marktinhome.ui.Advertisement;

import static com.doubleclick.marktinhome.Model.Constantes.ADVERTISEMENT;
import static com.doubleclick.marktinhome.Model.Constantes.TRADEMARK;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.doubleclick.marktinhome.Model.Advertisement;
import com.doubleclick.marktinhome.Model.Trademark;
import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.ui.Trademark.EditTradmarkActivity;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class EditAdvertisementActivity extends AppCompatActivity {


    private static int IMAGE_REQUEST = 100;
    private ImageView image;
    private EditText name;
    private Button upload;
    private Advertisement advertisement;
    private static Uri imageUri;
    private DatabaseReference reference;
    private StorageReference storageReference;
    private StorageTask uploadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_advertisement);
        image = findViewById(R.id.image);
        name = findViewById(R.id.name);
        upload = findViewById(R.id.upload);
        advertisement = (Advertisement) getIntent().getSerializableExtra("Advertisement");
        storageReference = FirebaseStorage.getInstance().getReference(ADVERTISEMENT);
        reference = FirebaseDatabase.getInstance("https://marketinhome-99d25-default-rtdb.firebaseio.com").getReference();
        image.setOnClickListener(v -> {
            openImage();
        });

        upload.setOnClickListener(v -> {
            UpdateData();
        });
    }

    public String getFileExtension(Uri uri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }

    public void openImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            image.setImageURI(imageUri);
            if (uploadTask != null && uploadTask.isInProgress()) {
                Toast.makeText(EditAdvertisementActivity.this, "Upload in progress", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void UpdateData() {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Uploading");
        pd.show();
        if (imageUri != null) {
            final StorageReference fileReference = storageReference.child(System.currentTimeMillis() + "." + getFileExtension(imageUri));
            uploadTask = fileReference.putFile(imageUri);
            uploadTask.continueWithTask((Continuation<UploadTask.TaskSnapshot, Task<Uri>>) task -> {
                if (!task.isSuccessful()) {
                    Toast.makeText(EditAdvertisementActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    throw task.getException();
                }
                return fileReference.getDownloadUrl();
            }).addOnCompleteListener((OnCompleteListener<Uri>) task -> {
                if (task.isSuccessful()) {
                    Uri downloadUri = task.getResult();
                    String mUri = downloadUri.toString();
                    HashMap<String, Object> map = new HashMap<>();
                    // todo update name and image
                    if (!name.getText().toString().equals("") && !mUri.equals("")) {
                        map.put("text", name.getText().toString());
                        map.put("image", mUri);
                        Toast.makeText(EditAdvertisementActivity.this, "Updated", Toast.LENGTH_SHORT).show();

                    }
                    // todo update only image
                    if (name.getText().toString().equals("") && !mUri.equals("")) {
                        map.put("image", mUri);
                        Toast.makeText(EditAdvertisementActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                    reference.child(ADVERTISEMENT).child(advertisement.getId()).updateChildren(map);
                    name.setText("");
                    image.setImageURI(null);
                    pd.dismiss();
                } else {
                    Toast.makeText(EditAdvertisementActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
                    pd.dismiss();
                }
            }).addOnFailureListener(e -> {
                Toast.makeText(EditAdvertisementActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                pd.dismiss();
            });
            // todo update only name
        } else if (!name.getText().toString().equals("") && imageUri == null) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("text", name.getText().toString());
            reference.child(ADVERTISEMENT).child(advertisement.getId()).updateChildren(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        name.setText("");
                        Toast.makeText(EditAdvertisementActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                        pd.dismiss();
                    } else {
                        Toast.makeText(EditAdvertisementActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });


        }
    }
}