package com.doubleclick.ViewHolder;

import static android.content.Context.DOWNLOAD_SERVICE;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.PopupMenu;
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
    private ImageView options;

    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);
        video = itemView.findViewById(R.id.video);
        ContinerViedo = itemView.findViewById(R.id.ContinerViedo);
        options = itemView.findViewById(R.id.options);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void play(Chat chat, int position) {
        if (!chat.getMessage().equals("")) {
            video.setVideoURI(Uri.parse(chat.getMessage())); //the string of the URL mentioned above
            video.stopPlayback();
            video.pause();
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
        options.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(itemView.getContext(), v);
            popupMenu.getMenuInflater().inflate(R.menu.menu_chat, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    int id = item.getItemId();
                    if (R.id.deleteforeveryone == id) {
                        Toast.makeText(itemView.getContext(),"deleteforeveryone",Toast.LENGTH_LONG).show();
                    }
                    if (R.id.deleteForme == id) {
                        Toast.makeText(itemView.getContext(),"deleteForme",Toast.LENGTH_LONG).show();
                    }
                    if (R.id.download == id) {
                        try {
                            download(chat);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    return true;
                }
            });
            popupMenu.show();


        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void download(Chat chat) throws Exception {
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(chat.getMessage()));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "video" + chat.getId());
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); // to notify when download is complete
            request.allowScanningByMediaScanner();// if you want to be available from media players
            DownloadManager manager = (DownloadManager) itemView.getContext().getSystemService(DOWNLOAD_SERVICE);
            Uri u = manager.getUriForDownloadedFile(manager.enqueue(request));
            video.setVideoURI(u);
        } catch (IllegalStateException | NullPointerException e) {
            Log.e("Exeption Voice", e.getMessage());
        }

    }
}
