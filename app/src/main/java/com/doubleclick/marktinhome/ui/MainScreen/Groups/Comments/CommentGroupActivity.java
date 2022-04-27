package com.doubleclick.marktinhome.ui.MainScreen.Groups.Comments;

import static com.doubleclick.marktinhome.Model.Constantes.COMMENTS_GROUP;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.doubleclick.ViewModel.CommentsGroupViewModel;
import com.doubleclick.marktinhome.Adapters.CommentGroupAdapter;
import com.doubleclick.marktinhome.Model.CommentsGroupData;
import com.doubleclick.marktinhome.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class CommentGroupActivity extends AppCompatActivity {

    private RecyclerView Comments;
    private ImageView send;
    private DatabaseReference reference;
    private EditText textComment;
    private String id;
    private String userId;
    private CommentsGroupViewModel commentsGroupViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_group);
        Comments = findViewById(R.id.Comments);
        send = findViewById(R.id.send);
        textComment = findViewById(R.id.textComment);
        commentsGroupViewModel = new ViewModelProvider(this).get(CommentsGroupViewModel.class);
        id = getIntent().getStringExtra("id"/* post id*/);
        commentsGroupViewModel.GetComments(id);
        commentsGroupViewModel.getCommentsLiveData().observe(this, new Observer<ArrayList<CommentsGroupData>>() {
            @Override
            public void onChanged(ArrayList<CommentsGroupData> commentsGroupData) {
                Comments.setAdapter(new CommentGroupAdapter(commentsGroupData));
            }
        });
        userId = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid().toString();
        reference = FirebaseDatabase.getInstance().getReference();

        send.setOnClickListener(v -> {

            if (!textComment.getText().toString().equals("")) {
                HashMap<String, Object> map = new HashMap<>();
                long time = new Date().getTime();
                String pushid = reference.push().getKey().toString() + ":" + time;
                map.put("id", pushid);
                map.put("time", time);
                map.put("comment", textComment.getText().toString());
                map.put("userId", userId);
                reference.child(COMMENTS_GROUP).child(id/* post id*/).child(pushid/*comment id*/).updateChildren(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            textComment.setText("");
                        }

                    }
                });
            } else {
                Snackbar.make(v, "Empty comment", Snackbar.LENGTH_LONG).show();
            }

        });
    }
}