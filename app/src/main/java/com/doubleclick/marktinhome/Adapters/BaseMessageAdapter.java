package com.doubleclick.marktinhome.Adapters;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleclick.ViewHolder.BaseViewHolder;
import com.doubleclick.ViewHolder.ContactViewHolder;
import com.doubleclick.ViewHolder.FileViewHolder;
import com.doubleclick.ViewHolder.ImageViewHolder;
import com.doubleclick.ViewHolder.LocationViewHolder;
import com.doubleclick.ViewHolder.MessageTextViewHolder;
import com.doubleclick.ViewHolder.VideoViewHolder;
import com.doubleclick.ViewHolder.VoiceViewHolder;
import com.doubleclick.marktinhome.Model.Chat;
import com.doubleclick.marktinhome.Model.Constantes;
import com.doubleclick.marktinhome.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

/**
 * Created By Eslam Ghazy on 2/7/2022
 */
public class BaseMessageAdapter extends RecyclerView.Adapter {


    private List<Chat> chats;
    private String myId;

    public BaseMessageAdapter(List<Chat> chats) {
        this.chats = chats;
    }

    public BaseMessageAdapter(List<Chat> chats, String myId) {
        this.chats = chats;
        this.myId = myId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case Constantes.VIDEO_RIGHT:
                return new VideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_right, parent, false));
            case Constantes.VOICE_RIGHT:
                return new VoiceViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.play_voice_right, parent, false));
            case Constantes.CONTACT_RIGHT:
                return new ContactViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact_right, parent, false));
            case Constantes.TEXT_RIGHT:
                return new MessageTextViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.right_chat, parent, false));
            case Constantes.LOCATION_RIGHT:
                return new LocationViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location_right, parent, false));
            case Constantes.IMAGE_RIGHT:
                return new ImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_right, parent, false));
            case Constantes.FILE_RIGHT:
                return new FileViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_file_right, parent, false));
            case Constantes.VIDEO_LEFT:
                return new VideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_left, parent, false));
            case Constantes.VOICE_LEFT:
                return new VoiceViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.play_voice_left, parent, false));
            case Constantes.CONTACT_LEFT:
                return new ContactViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact_left, parent, false));
            case Constantes.TEXT_LEFT:
                return new MessageTextViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.left_chat, parent, false));
            case Constantes.LOCATION_LEFT:
                return new LocationViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location_left, parent, false));
            case Constantes.IMAGE_LEFT:
                return new ImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_left, parent, false));
            case Constantes.FILE_LEFT:
                return new FileViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_file_left, parent, false));
            default:
                return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_view, parent, false));  // return  view  defulte
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        try {
            switch (chats.get(position).getType()) {
                case "voice":
                    ((VoiceViewHolder) holder).Play(chats.get(holder.getAdapterPosition()), position);
                    break;
                case "text":
                    ((MessageTextViewHolder) holder).SetTextMessage(chats.get(position), position);
                    break;
                case "image":
                    ((ImageViewHolder) holder).ShowImage(chats.get(position), position);
                    break;
                case "video":
                    ((VideoViewHolder) holder).play(chats.get(position), position);
                    break;
                case "contact":
                    ((ContactViewHolder) holder).Contact(chats.get(position).getMessage());
                    break;
                case "file":
                    ((FileViewHolder) holder).downloadFile(chats.get(position), position);
                    break;
                case "location":
                    ((LocationViewHolder) holder).OpenLocation(chats.get(position));
                    break;
                default:
                    ((BaseViewHolder) holder).animationView.setVisibility(View.VISIBLE);
            }
        } catch (NullPointerException e) {
            Log.e("Exception", e.getMessage());
        }

    }


    @Override
    public int getItemCount() {
        return chats.size();
    }


    @Override
    public int getItemViewType(int position) {
        try {
            if (chats.get(position).getType() != null) {
                if (chats.get(position).getType().equals("voice")) {
                    if (chats.get(position).getSender().equals(FirebaseAuth.getInstance().getCurrentUser().getUid().toString())) {
                        return Constantes.VOICE_RIGHT;
                    } else {
                        return Constantes.VOICE_LEFT;
                    }
                }
                if (chats.get(position).getType().equals("image")) {
                    if (chats.get(position).getSender().equals(FirebaseAuth.getInstance().getCurrentUser().getUid().toString())) {
                        return Constantes.IMAGE_RIGHT;
                    } else {
                        return Constantes.IMAGE_LEFT;
                    }

                }
                if (chats.get(position).getType().equals("text")) {
                    if (chats.get(position).getSender().equals(FirebaseAuth.getInstance().getCurrentUser().getUid().toString())) {
                        return Constantes.TEXT_RIGHT;
                    } else {
                        return Constantes.TEXT_LEFT;
                    }
                }
                if (chats.get(position).getType().equals("contact")) {
                    if (chats.get(position).getSender().equals(FirebaseAuth.getInstance().getCurrentUser().getUid().toString())) {
                        return Constantes.CONTACT_RIGHT;
                    } else {
                        return Constantes.CONTACT_LEFT;
                    }
                }
                if (chats.get(position).getType().equals("file")) {
                    if (chats.get(position).getSender().equals(FirebaseAuth.getInstance().getCurrentUser().getUid().toString())) {
                        return Constantes.FILE_RIGHT;
                    } else {
                        return Constantes.FILE_LEFT;
                    }
                }
                if (chats.get(position).getType().equals("location")) {
                    if (chats.get(position).getSender().equals(FirebaseAuth.getInstance().getCurrentUser().getUid().toString())) {
                        return Constantes.LOCATION_RIGHT;
                    } else {
                        return Constantes.LOCATION_LEFT;
                    }
                }
                if (chats.get(position).getType().equals("video")) {
                    if (chats.get(position).getSender().equals(FirebaseAuth.getInstance().getCurrentUser().getUid().toString())) {
                        return Constantes.VIDEO_RIGHT;
                    } else {
                        return Constantes.VIDEO_LEFT;
                    }
                }
            } else {
                return Constantes.DEFAULT_LAYOUT;
            }
        } catch (NullPointerException e) {
            Log.e("Exception", e.getMessage());
        }
        return 0;
    }

}
