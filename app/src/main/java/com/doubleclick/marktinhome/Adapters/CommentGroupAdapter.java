package com.doubleclick.marktinhome.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.doubleclick.marktinhome.Model.CommentsGroupData;
import com.doubleclick.marktinhome.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created By Eslam Ghazy on 4/27/2022
 */
public class CommentGroupAdapter extends RecyclerView.Adapter<CommentGroupAdapter.CommentsViewHolder> {

    private ArrayList<CommentsGroupData> commentsGroupData;

    public CommentGroupAdapter(ArrayList<CommentsGroupData> commentsGroupData) {
        this.commentsGroupData = commentsGroupData;
    }

    @NonNull
    @Override
    public CommentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CommentsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.comments_group_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsViewHolder holder, int position) {

        Glide.with(holder.itemView.getContext()).load(commentsGroupData.get(holder.getAdapterPosition()).getUser().getImage()).into(holder.imageUser);
        holder.userName.setText(commentsGroupData.get(holder.getAdapterPosition()).getUser().getName());
        holder.comment.setText(commentsGroupData.get(holder.getAdapterPosition()).getCommentsGroup().getComment());
        holder.time.setText(String.valueOf(commentsGroupData.get(holder.getAdapterPosition()).getCommentsGroup().getTime()));
    }

    @Override
    public int getItemCount() {
        return commentsGroupData.size();
    }

    public class CommentsViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView imageUser;
        private TextView userName, comment, time, like;

        public CommentsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageUser = itemView.findViewById(R.id.imageUser);
            userName = itemView.findViewById(R.id.userName);
            comment = itemView.findViewById(R.id.comment);
            time = itemView.findViewById(R.id.time);
            like = itemView.findViewById(R.id.like);
        }
    }
}
