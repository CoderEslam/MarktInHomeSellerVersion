package com.doubleclick.marktinhome.ui.MainScreen.Groups;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.doubleclick.marktinhome.R;

public class ViewActivity extends AppCompatActivity {

    private VideoView video;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        video = findViewById(R.id.video);
        url = getIntent().getStringExtra("url");
        video.setVideoURI(Uri.parse(url));
        MediaController ctlr = new MediaController(this);
        ctlr.setMediaPlayer(video);
        video.setMediaController(ctlr);
        video.requestFocus();

    }
}