package com.doubleclick.ViewHolder;

import static android.content.Context.DOWNLOAD_SERVICE;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.ContextWrapper;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.doubleclick.marktinhome.Model.Chat;
import com.doubleclick.marktinhome.R;

import java.io.File;
import java.util.Date;
import java.util.Objects;

/**
 * Created By Eslam Ghazy on 2/7/2022
 */
public class VoiceViewHolder extends BaseViewHolder {

    private VideoView voice;
    private ConstraintLayout ContinerVoice;
    private ImageView downloadVoice;
    private boolean isPlay = false;
    private ProgressBar progress;


    public VoiceViewHolder(@NonNull View itemView) {
        super(itemView);
        voice = itemView.findViewById(R.id.video);
        downloadVoice = itemView.findViewById(R.id.downloadVoice);
        ContinerVoice = itemView.findViewById(R.id.ContinerVoice);
        progress = itemView.findViewById(R.id.progress);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void Play(Chat chat, int position) {
        //        if (Servies.isNetworkConnected(itemView.getContext())) {
        if (!chat.getMessage().equals("")) {
            progress.setVisibility(View.GONE);
            downloadVoice.setImageDrawable(itemView.getResources().getDrawable(R.drawable.play));
            voice.setVideoURI(Uri.parse(chat.getMessage())); //the string of the URL mentioned above
            voice.stopPlayback();
            voice.pause();
        }
        voice.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                downloadVoice.setImageDrawable(itemView.getResources().getDrawable(R.drawable.play));
            }
        });
        MediaController ctlr = new MediaController(itemView.getContext());
        ctlr.setMediaPlayer(voice);
        ctlr.findFocus();
        ctlr.show(0);
        ctlr.setAnchorView(voice);
        ctlr.setEnabled(true);
        voice.setMediaController(ctlr);
        voice.requestFocus();
        downloadVoice.setOnClickListener(v -> {
            if (!chat.getMessage().equals("")) {
                if (isPlay) {
                    downloadVoice.setImageDrawable(itemView.getResources().getDrawable(R.drawable.play));
                    voice.pause();
                    voice.stopPlayback();
                    isPlay = false;
                } else {
                    downloadVoice.setImageDrawable(itemView.getResources().getDrawable(R.drawable.pause));
                    voice.setVideoURI(Uri.parse(chat.getMessage()));
                    voice.start();
                    isPlay = true;
                }
            } else {
                try {
                    progress.setVisibility(View.VISIBLE);
                    download(chat);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ContinerVoice.setOnLongClickListener(v -> {
//            Intent intent = new Intent(itemView.getContext(), ViewActivity.class);
//            intent.putExtra("video", chat.getMessage());
//            itemView.getContext().startActivity(intent);
            return true;
        });
//        } else {
//            Toast.makeText(itemView.getContext(), "you don't have an internet connection", Toast.LENGTH_LONG).show();
//        }

    }

    @SuppressLint("NotifyDataSetChanged")
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void download(Chat chat) throws Exception {
        try {
            downloadVoice.setEnabled(false);
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(chat.getMessage()));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "voice" + chat.getId());
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); // to notify when download is complete
            request.allowScanningByMediaScanner();// if you want to be available from media players
            DownloadManager manager = (DownloadManager) itemView.getContext().getSystemService(DOWNLOAD_SERVICE);
            Uri uri = manager.getUriForDownloadedFile(manager.enqueue(request));
            if (!uri.toString().equals("")) {
                progress.setVisibility(View.GONE);
            }
            Log.e("ImageURI", uri.toString());
            voice.setVideoURI(uri);
        } catch (IllegalStateException | NullPointerException e) {
            Log.e("ExceptionVoice", e.getMessage());
        }
    }

    private String getFilePath() {
        ContextWrapper contextWrapper = new ContextWrapper(itemView.getContext());
        File file = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        File f = new File(file, "ChatApp/Recording/voice" + new Date().getTime());
        if (!f.exists()) {
            f.mkdirs();
        }
        return f.getPath();
    }


}
