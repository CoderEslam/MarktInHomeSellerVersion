package com.doubleclick.ViewHolder;

import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleclick.OnProduct;
import com.doubleclick.ViewMore;
import com.doubleclick.marktinhome.Adapters.ProductAdapterSmall;
import com.doubleclick.marktinhome.Model.Product;
import com.doubleclick.marktinhome.R;

import java.util.ArrayList;

/**
 * Created By Eslam Ghazy on 3/10/2022
 */
public class TopDealsViewHolder extends RecyclerView.ViewHolder {

    private RecyclerView TopDeals;
    private TextView viewmore;

    public TopDealsViewHolder(@NonNull View itemView) {
        super(itemView);
        TopDeals = itemView.findViewById(R.id.idGVTopDeals);
        viewmore = itemView.findViewById(R.id.viewmore);
        ViewCompat.setNestedScrollingEnabled(TopDeals, true);
    }

    public void setTopDeals(ArrayList<Product> products, OnProduct onProduct,ViewMore viewMore) {
        ProductAdapterSmall gridViewAdapter = new ProductAdapterSmall(products,onProduct);
        TopDeals.setAdapter(gridViewAdapter);
        viewmore.setOnClickListener(v -> {
            viewMore.getViewMore(products);
        });
    }
}
