package com.doubleclick.marktinhome.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.Views.carousellayoutmanager.CarouselLayoutManager;
import com.doubleclick.marktinhome.Views.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.doubleclick.marktinhome.Views.carousellayoutmanager.CenterScrollListener;
import com.doubleclick.marktinhome.ui.MainScreen.Groups.GroupsActivity;

/**
 * Created By Eslam Ghazy on 4/20/2022
 */
public class GroupsAdapter extends RecyclerView.Adapter<GroupsAdapter.GroupViewHolder> {


    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GroupViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_group, parent, false));
    }

    @Override
    public int getItemCount() {
        return 50;
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
    }

    public class GroupViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView images;
        private ConstraintLayout ConstraintLayoutimage_name;
        private ImageView option;
        private LinearLayout likeButton, comment, share;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.images);
            ConstraintLayoutimage_name = itemView.findViewById(R.id.ConstraintLayoutimage_name);
            option = itemView.findViewById(R.id.option);
            likeButton = itemView.findViewById(R.id.likeButton);
            comment = itemView.findViewById(R.id.comment);
            share = itemView.findViewById(R.id.share);
            CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL);
            images.setLayoutManager(layoutManager);
            images.setHasFixedSize(true);
            images.addOnScrollListener(new CenterScrollListener());
            layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
            images.setAdapter(new ImagesGroupAdapter());

            itemView.setOnClickListener(v -> {
                itemView.getContext().startActivity(new Intent(itemView.getContext(), GroupsActivity.class));
            });

        }
    }
}
