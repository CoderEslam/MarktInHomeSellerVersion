package com.doubleclick.marktinhome.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.Views.PhotoView.PhotoView;

import java.util.ArrayList;

/**
 * Created By Eslam Ghazy on 4/20/2022
 */
public class ImagesGroupAdapter extends RecyclerView.Adapter<ImagesGroupAdapter.ImagesGroupViewHolder> {

    private ArrayList<String> images = new ArrayList<>();

    public ImagesGroupAdapter(ArrayList<String> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public ImagesGroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImagesGroupViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_images, parent, false));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesGroupViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext()).load(images.get(holder.getAdapterPosition())).into(holder.image);
    }

    public class ImagesGroupViewHolder extends RecyclerView.ViewHolder {

        private PhotoView image;

        public ImagesGroupViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }
}
