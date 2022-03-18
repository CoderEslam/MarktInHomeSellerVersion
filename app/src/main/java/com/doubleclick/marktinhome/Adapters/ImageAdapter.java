package com.doubleclick.marktinhome.Adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleclick.marktinhome.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Eslam Ghazy on 3/14/2022
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    List<Uri> uris = new ArrayList<>();

    public ImageAdapter(List<Uri> uris) {
        this.uris = uris;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.images, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.image.setImageURI(uris.get(position));
    }

    @Override
    public int getItemCount() {
        return uris.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }
}
