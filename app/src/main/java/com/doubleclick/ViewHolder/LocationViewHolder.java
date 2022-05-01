package com.doubleclick.ViewHolder;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.doubleclick.marktinhome.Model.Chat;
import com.doubleclick.marktinhome.R;

/**
 * Created By Eslam Ghazy on 2/7/2022
 */
public class LocationViewHolder extends BaseViewHolder {
    private LottieAnimationView location_lotte;
    public LocationViewHolder(@NonNull View itemView) {
        super(itemView);
        location_lotte = itemView.findViewById(R.id.location_lotte);
    }

    public void OpenLocation(Chat chat) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(chat.getMessage()));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.setPackage("com.android.chrome");
                try {
                    itemView.getContext().startActivity(i);
                } catch (ActivityNotFoundException e) {
                    // Chrome is probably not installed
                    // Try with the default browser
                    i.setPackage(null);
                    itemView.getContext().startActivity(i);
                }
            }
        });
    }
}
