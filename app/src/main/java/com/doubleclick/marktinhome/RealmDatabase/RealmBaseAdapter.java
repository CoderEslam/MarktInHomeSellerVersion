package com.doubleclick.marktinhome.RealmDatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleclick.ViewHolder.ContactViewHolder;
import com.doubleclick.ViewHolder.FileViewHolder;
import com.doubleclick.ViewHolder.LocationViewHolder;
import com.doubleclick.ViewHolder.MessageTextViewHolder;
import com.doubleclick.ViewHolder.VideoViewHolder;
import com.doubleclick.ViewHolder.VoiceViewHolder;
import com.doubleclick.marktinhome.Model.Constantes;
import com.doubleclick.marktinhome.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

/**
 * Created By Eslam Ghazy on 4/25/2022
 */
public class RealmBaseAdapter extends RealmRecyclerViewAdapter<ChatRealm, RealmBaseAdapter.RealmBaseViewHolder> {

    List<ChatRealm> chats = new ArrayList<>();

    public RealmBaseAdapter(@Nullable OrderedRealmCollection<ChatRealm> data, boolean autoUpdate) {
        super(data, autoUpdate);
        chats = data;
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

//    @Override
//    public long getItemId(int position) {
//        return getItem(position);
//    }

    @NonNull
    @Override
    public RealmBaseAdapter.RealmBaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        switch (viewType) {
//            case Constantes.VIDEO_RIGHT:
//                return new VideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_right, parent, false));
//            case Constantes.VOICE_RIGHT:
//                return new VoiceViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.play_voice_right, parent, false));
//            case Constantes.CONTACT_RIGHT:
//                return new ContactViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact_right, parent, false));
//            case Constantes.TEXT_RIGHT:
//                return new MessageTextViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_right, parent, false));
//            case Constantes.LOCATION_RIGHT:
//                return new LocationViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location_right, parent, false));
//            case Constantes.IMAGE_RIGHT:
//                return new ImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_right, parent, false));
//            case Constantes.FILE_RIGHT:
//                return new FileViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_file_right, parent, false));
//            case Constantes.VIDEO_LEFT:
//                return new VideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_left, parent, false));
//            case Constantes.VOICE_LEFT:
//                return new VoiceViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.play_voice_left, parent, false));
//            case Constantes.CONTACT_LEFT:
//                return new ContactViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact_left, parent, false));
//            case Constantes.TEXT_LEFT:
//                return new MessageTextViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_left, parent, false));
//            case Constantes.LOCATION_LEFT:
//                return new LocationViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location_left, parent, false));
//            case Constantes.IMAGE_LEFT:
//                return new ImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_left, parent, false));
//            case Constantes.FILE_LEFT:
//                return new FileViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_file_left, parent, false));
//        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RealmBaseAdapter.RealmBaseViewHolder holder, int position) {

    }

    public class RealmBaseViewHolder extends RecyclerView.ViewHolder {
        public RealmBaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
