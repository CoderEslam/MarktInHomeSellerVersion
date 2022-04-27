package com.doubleclick.marktinhome.Adapters;

import static com.doubleclick.marktinhome.Model.Constantes.LIKES;
import static com.doubleclick.marktinhome.Model.Constantes.LIKES_ON_COMMENTS;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.doubleclick.marktinhome.Model.CommentsGroupData;
import com.doubleclick.marktinhome.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.todkars.shimmer.ShimmerRecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created By Eslam Ghazy on 4/27/2022
 * import de.hdodenhof.circleimageview.CircleImageView;
 */
public class CommentGroupAdapter extends RecyclerView.Adapter<CommentGroupAdapter.CommentsViewHolder> {

    private ArrayList<CommentsGroupData> commentsGroupData;
    private DatabaseReference reference;
    String myId = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid().toString();
    private boolean LikeChecker = false;

    public CommentGroupAdapter(ArrayList<CommentsGroupData> commentsGroupData) {
        this.commentsGroupData = commentsGroupData;
    }

    @NonNull
    @Override
    public CommentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        reference = FirebaseDatabase.getInstance().getReference();
        return new CommentsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.comments_group_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsViewHolder holder, int position) {

        Glide.with(holder.itemView.getContext()).load(commentsGroupData.get(holder.getAdapterPosition()).getUser().getImage()).into(holder.imageUser);
        holder.userName.setText(commentsGroupData.get(holder.getAdapterPosition()).getUser().getName());
        holder.comment.setText(commentsGroupData.get(holder.getAdapterPosition()).getCommentsGroup().getComment());
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd/MM/yyyy HH:mm aa");
        holder.time.setText(String.format("%s ", simpleDateFormat.format(commentsGroupData.get(holder.getAdapterPosition()).getCommentsGroup().getTime())));

        holder.like.setOnClickListener(v -> {
            LikeChecker = true;
            reference.child(LIKES_ON_COMMENTS).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    //CHECKING IF THE POST IS LIKED OR NOT.....
                    if (LikeChecker == true) {
                        if (dataSnapshot.child(commentsGroupData.get(holder.getAdapterPosition()).getCommentsGroup().getId()).hasChild(myId)) {
                            reference.child(LIKES_ON_COMMENTS).child(commentsGroupData.get(holder.getAdapterPosition()).getCommentsGroup().getId()).child(myId).removeValue();
                            LikeChecker = false;
                        } else {
                            reference.child(LIKES_ON_COMMENTS).child(commentsGroupData.get(holder.getAdapterPosition()).getCommentsGroup().getId()).child(myId).setValue(true);
                            LikeChecker = false;
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        });
        holder.setLike(commentsGroupData.get(holder.getAdapterPosition()).getCommentsGroup().getId());

    }

    @Override
    public int getItemCount() {
        return commentsGroupData.size();
    }

    public class CommentsViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView imageUser;
        private TextView userName, comment, time, like, replay;
        private ImageView img_like;
        private ShimmerRecyclerView RecyclerReplay;

        public CommentsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageUser = itemView.findViewById(R.id.imageUser);
            userName = itemView.findViewById(R.id.userName);
            comment = itemView.findViewById(R.id.comment);
            time = itemView.findViewById(R.id.time);
            like = itemView.findViewById(R.id.like);
            replay = itemView.findViewById(R.id.replay);
            img_like = itemView.findViewById(R.id.img_like);
            RecyclerReplay = itemView.findViewById(R.id.RecyclerReplay);
            RecyclerReplay.showShimmer();
        }


        public void setLike(String PostKey) {
            reference.child(LIKES_ON_COMMENTS).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.child(PostKey).hasChild(myId)) {
//                        like.setText("liked");
                        like.setText(String.format("%s Like", String.valueOf(dataSnapshot.child(commentsGroupData.get(getAdapterPosition()).getCommentsGroup().getId()).getChildrenCount())));
                        img_like.setImageResource(R.drawable.like_thumb_up);
                    } else {
//                        like.setText("like");
                        like.setText(String.format("%s Like", String.valueOf(dataSnapshot.child(commentsGroupData.get(getAdapterPosition()).getCommentsGroup().getId()).getChildrenCount())));
                        img_like.setImageResource(R.drawable.ic_like);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }


}
