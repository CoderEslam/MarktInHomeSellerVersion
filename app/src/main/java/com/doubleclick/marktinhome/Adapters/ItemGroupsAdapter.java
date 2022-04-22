package com.doubleclick.marktinhome.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.ui.MainScreen.Groups.GroupsActivity;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created By Eslam Ghazy on 4/22/2022
 */
public class ItemGroupsAdapter extends RecyclerView.Adapter<ItemGroupsAdapter.ItemViewHolder> {


    @NonNull
    @Override
    public ItemGroupsAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_group_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemGroupsAdapter.ItemViewHolder holder, int position) {

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), GroupsActivity.class);
            holder.itemView.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView imageGroup;
        private TextView name, creator;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageGroup = itemView.findViewById(R.id.imageGroup);
            name = itemView.findViewById(R.id.name);
            creator = itemView.findViewById(R.id.creator);

        }
    }
}
