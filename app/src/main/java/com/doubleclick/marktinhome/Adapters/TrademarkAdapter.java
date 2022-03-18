package com.doubleclick.marktinhome.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.doubleclick.Tradmarkinterface;
import com.doubleclick.marktinhome.Model.Trademark;
import com.doubleclick.marktinhome.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created By Eslam Ghazy on 3/8/2022
 */
public class TrademarkAdapter extends RecyclerView.Adapter<TrademarkAdapter.TrademarkViewHolder> {

    ArrayList<Trademark> trademarks = new ArrayList<>();
    private Tradmarkinterface tradmarkinterface;

    public TrademarkAdapter(ArrayList<Trademark> trademarks) {
        this.trademarks = trademarks;
    }

    public TrademarkAdapter(ArrayList<Trademark> trademarks, Tradmarkinterface tradmarkinterface) {
        this.trademarks = trademarks;
        this.tradmarkinterface = tradmarkinterface;
    }

    @NonNull
    @Override
    public TrademarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TrademarkViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trademark, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TrademarkViewHolder holder, int position) {
        if (trademarks.size() != 0) {
            Glide.with(holder.itemView.getContext()).load(trademarks.get(holder.getAdapterPosition()).getImage()).into(holder.imageTrademark);
            holder.name.setText(trademarks.get(holder.getAdapterPosition()).getName());
            holder.itemView.setOnClickListener(v -> {
                tradmarkinterface.OnItemTradmark(trademarks.get(position));
            });
        }
    }

    @Override
    public int getItemCount() {
        return trademarks.size();
    }

    public class TrademarkViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView imageTrademark;
        private TextView name;

        public TrademarkViewHolder(@NonNull View itemView) {
            super(itemView);
            imageTrademark = itemView.findViewById(R.id.imageTrademark);
            name = itemView.findViewById(R.id.name);
        }
    }
}
