package com.doubleclick.ViewHolder;

import static android.content.Context.DOWNLOAD_SERVICE;

import static com.doubleclick.marktinhome.BaseApplication.isNetworkConnected;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.doubleclick.Servies.Servies;
import com.doubleclick.ViewModel.ChatViewModel;
import com.doubleclick.marktinhome.Model.Chat;
import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.Views.PhotoView.PhotoView;


/**
 * Created By Eslam Ghazy on 2/7/2022
 */
public class ImageViewHolder extends RecyclerView.ViewHolder {
    public PhotoView imageView;
    public ImageView download;
    private ConstraintLayout ContinnerImage;

    public ImageViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image);
        download = itemView.findViewById(R.id.downloadImage);
        ContinnerImage = itemView.findViewById(R.id.ContinnerImage);
    }

    public void ShowImage(Chat chat, int position) {
        if (chat.getMessage().equals("")) {
            download.setVisibility(View.VISIBLE);
            ContinnerImage.setEnabled(false);
        } else {
            ContinnerImage.setEnabled(true);
            download.setVisibility(View.GONE);
            Glide.with(itemView.getContext()).load(Uri.parse(chat.getMessage())).into(imageView);
        }

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chat.getMessage().equals("") || chat.getMessage() == null) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        try {
                            download(chat);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });

        ContinnerImage.setOnClickListener(v -> {
//            Intent intent = new Intent(itemView.getContext(), ViewActivity.class);
//            intent.putExtra("chat", chat);
//            itemView.getContext().startActivity(intent);
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void download(Chat chat) throws Exception {
        if (isNetworkConnected()) {
            try {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(chat.getMessage()));
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "image" + chat.getId());
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); // to notify when download is complete
                request.allowScanningByMediaScanner();// if you want to be available from media players
                DownloadManager manager = (DownloadManager) itemView.getContext().getSystemService(DOWNLOAD_SERVICE);
                Uri uri = manager.getUriForDownloadedFile(manager.enqueue(request));
                Log.e("ImageURI",uri.toString());
            } catch (IllegalStateException | NullPointerException e) {
                Log.e("ExeptionImage", e.getMessage());
            }
        } else {
            Toast.makeText(itemView.getContext(), "you don't have an internet connection", Toast.LENGTH_LONG).show();
        }

    }
}
