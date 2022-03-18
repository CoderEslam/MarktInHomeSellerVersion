package com.doubleclick.marktinhome.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.doubleclick.OnCartLisnter;
import com.doubleclick.marktinhome.Model.Cart;
import com.doubleclick.marktinhome.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created By Eslam Ghazy on 3/2/2022
 */
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private ArrayList<Cart> carts = new ArrayList<>();
    private OnCartLisnter onCartLisnter;

    public CartAdapter(ArrayList<Cart> carts) {
        this.carts = carts;
    }

    public CartAdapter(ArrayList<Cart> carts, OnCartLisnter onCartLisnter) {
        this.carts = carts;
        this.onCartLisnter = onCartLisnter;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CartViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layaut_cart, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        if (carts.size() != 0) {
            holder.CartName.setText(carts.get(position).getProductName());
            holder.price.setText(String.format("%s", carts.get(position).getPrice()));
            holder.quantity.setText(String.format("%s", carts.get(position).getQuantity()));
            Glide.with(holder.itemView.getContext()).load(carts.get(position).getImages()).into(holder.imageCart);

            holder.add.setOnClickListener(v -> {
                onCartLisnter.OnAddItemOrder(carts.get(position));
            });
            holder.mins.setOnClickListener(v -> {
                onCartLisnter.OnMinsItemOrder(carts.get(position));
            });

            holder.delete.setOnClickListener(v -> {
                try {
                    onCartLisnter.OnDeleteItemOrder(carts.get(position));
                    holder.itemView.setVisibility(View.GONE);
                    notifyItemRemoved(holder.getAdapterPosition());
                    Toast.makeText(holder.itemView.getContext(), "Deleted swipe to refresh", Toast.LENGTH_SHORT).show();
                } catch (IndexOutOfBoundsException e) {
                    Log.e("CartAdapterException", e.getMessage());
                }

            });

        }


    }

    @Override
    public int getItemCount() {
        return carts.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView imageCart;
        private TextView CartName, price, quantity;
        private ImageView add, mins, delete;


        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            imageCart = itemView.findViewById(R.id.imageCart);
            CartName = itemView.findViewById(R.id.CartName);
            price = itemView.findViewById(R.id.price);
            quantity = itemView.findViewById(R.id.quantity);
            add = itemView.findViewById(R.id.add);
            mins = itemView.findViewById(R.id.mins);
            delete = itemView.findViewById(R.id.delete);
        }
    }
}
