package com.doubleclick.marktinhome.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleclick.marktinhome.R;

/**
 * Created By Eslam Ghazy on 4/20/2022
 */
public class ImagesGroupAdapter extends RecyclerView.Adapter<ImagesGroupAdapter.ImagesGroupViewHolder>{
    @NonNull
    @Override
    public ImagesGroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImagesGroupViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_images,parent,false));
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesGroupViewHolder holder, int position) {

    }

    public class ImagesGroupViewHolder extends RecyclerView.ViewHolder {

        public ImagesGroupViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
