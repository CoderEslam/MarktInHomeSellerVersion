package com.doubleclick.marktinhome.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.doubleclick.UserInter;
import com.doubleclick.marktinhome.Model.User;
import com.doubleclick.marktinhome.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created By Eslam Ghazy on 3/18/2022
 */
public class AllUserChatListAdapter extends RecyclerView.Adapter<AllUserChatListAdapter.AllUserViewHolder> {

    private ArrayList<User> userArrayList;
    private UserInter onUser;

    public AllUserChatListAdapter(ArrayList<User> userArrayList, UserInter onUser) {
        this.userArrayList = userArrayList;
        this.onUser = onUser;
    }

    @NonNull
    @Override
    public AllUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AllUserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_chat_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AllUserViewHolder holder, int position) {
        if (userArrayList.size() != 0) {
            holder.name.setText(userArrayList.get(position).getName());
            Glide.with(holder.itemView.getContext()).load(userArrayList.get(position).getImage()).into(holder.image);
            holder.itemView.setOnClickListener(v -> {
                onUser.OnUserLisitner(userArrayList.get(position));
            });
        }

    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public class AllUserViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView image;
        private TextView name;

        public AllUserViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
        }
    }

}
