package com.doubleclick.ViewHolder;

import static android.content.Context.DOWNLOAD_SERVICE;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleclick.ViewModel.ChatViewModel;
import com.doubleclick.marktinhome.Model.Chat;
import com.doubleclick.marktinhome.R;


/**
 * Created By Eslam Ghazy on 2/7/2022
 */
public class VideoViewHolder extends RecyclerView.ViewHolder {

    private VideoView video;
    private ConstraintLayout ContinerViedo;
    private ImageView downloadVideo;

    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);
        video = itemView.findViewById(R.id.video);
        ContinerViedo = itemView.findViewById(R.id.ContinerViedo);
        downloadVideo = itemView.findViewById(R.id.downloadVideo);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void play(Chat chat, int position) {
        if (!chat.getMessage().equals("")) {
            downloadVideo.setVisibility(View.GONE);
            downloadVideo.setEnabled(false);
            video.setVideoURI(Uri.parse(chat.getMessage())); //the string of the URL mentioned above
            video.stopPlayback();
            video.pause();
        } else {
            downloadVideo.setVisibility(View.VISIBLE);
            downloadVideo.setEnabled(true);
        }
        MediaController ctlr = new MediaController(itemView.getContext());
        ctlr.setMediaPlayer(video);
        video.setMediaController(ctlr);
        video.requestFocus();
        ContinerViedo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
//                Intent intent = new Intent(itemView.getContext(), ViewActivity.class);
//                intent.putExtra("chat", chat);
//                itemView.getContext().startActivity(intent);
                return true;
            }
        });
        downloadVideo.setOnClickListener(v -> {
            if (!chat.getMessage().equals("")) {
                Toast.makeText(itemView.getContext(), "You have it", Toast.LENGTH_LONG).show();
                video.setVideoURI(Uri.parse(chat.getMessage()));
                video.start();
            } else {
                try {
                    download(chat);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void download(Chat chat) throws Exception {
        try {
            downloadVideo.setEnabled(false);
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(chat.getMessage()));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "video" + chat.getId());
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); // to notify when download is complete
            request.allowScanningByMediaScanner();// if you want to be available from media players
            DownloadManager manager = (DownloadManager) itemView.getContext().getSystemService(DOWNLOAD_SERVICE);
            Uri u = manager.getUriForDownloadedFile(manager.enqueue(request));
//            chat.setUri(u.toString());
//            chatViewModel.update(chat);
            video.setVideoURI(u);
        } catch (IllegalStateException | NullPointerException e) {
            Log.e("Exeption Voice", e.getMessage());
        }

    }
}
