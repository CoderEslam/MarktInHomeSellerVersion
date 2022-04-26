package com.doubleclick.marktinhome.Adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleclick.marktinhome.Model.PostData;
import com.doubleclick.marktinhome.Model.PostsGroup;
import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.Views.carousellayoutmanager.CarouselLayoutManager;
import com.doubleclick.marktinhome.Views.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.doubleclick.marktinhome.Views.carousellayoutmanager.CenterScrollListener;
import com.doubleclick.marktinhome.ui.MainScreen.Groups.GroupsActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created By Eslam Ghazy on 4/20/2022
 */
public class GroupsAdapter extends RecyclerView.Adapter<GroupsAdapter.GroupViewHolder> {

    private ArrayList<PostData> postsGroups = new ArrayList<>();

    public GroupsAdapter(ArrayList<PostData> postsGroups) {
        this.postsGroups = postsGroups;
    }

    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GroupViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_group, parent, false));
    }

    @Override
    public int getItemCount() {
        return postsGroups.size();
    }

    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {

        holder.option.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(holder.itemView.getContext(), v);
            popupMenu.getMenuInflater().inflate(R.menu.option_group, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    int id = item.getItemId();
                    if (id == R.id.deleteOption) {
                        Toast.makeText(holder.itemView.getContext(), "ddddd", Toast.LENGTH_SHORT).show();
                    }
                    if (id == R.id.editOption) {
                        Toast.makeText(holder.itemView.getContext(), "eeeee", Toast.LENGTH_SHORT).show();

                    }
                    if (id == R.id.saveOption) {
                        Toast.makeText(holder.itemView.getContext(), "ssssss", Toast.LENGTH_SHORT).show();

                    }
                    return true;
                }
            });
            popupMenu.show();
        });
        List<String> image = Arrays.asList(postsGroups.get(holder.getAdapterPosition()).getPostsGroup().getImages().replace("[", "").replace("]", "").replace(" ", "").split(","));
        holder.images.setAdapter(new ImagesGroupAdapter(image));
        holder.namePublisher.setText(postsGroups.get(holder.getAdapterPosition()).getUser().getName());
        holder.likeButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View v) {
                holder.likeButton.setBackgroundDrawable(holder.itemView.getContext().getResources().getDrawable(R.drawable.add));
            }
        });

    }

    public class GroupViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView images;
        private ConstraintLayout ConstraintLayoutimage_name;
        private ImageView option;
        private TextView namePublisher;
        private LinearLayout likeButton, comment, share;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.images);
            ConstraintLayoutimage_name = itemView.findViewById(R.id.ConstraintLayoutimage_name);
            option = itemView.findViewById(R.id.option);
            likeButton = itemView.findViewById(R.id.likeButton);
            comment = itemView.findViewById(R.id.comment);
            namePublisher = itemView.findViewById(R.id.namePublisher);
            share = itemView.findViewById(R.id.share);
            CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL);
            images.setLayoutManager(layoutManager);
            images.setHasFixedSize(true);
            images.addOnScrollListener(new CenterScrollListener());
            layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());

        }
    }
}
