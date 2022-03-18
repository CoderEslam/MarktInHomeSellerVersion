package com.doubleclick.marktinhome.ui.MainScreen.Frgments;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleclick.ViewModel.CartViewModel;
import com.doubleclick.marktinhome.Adapters.CartAdapter;
import com.doubleclick.marktinhome.BaseFragment;
import com.doubleclick.marktinhome.R;


public class menu_CartFragment extends BaseFragment {


    private CartViewModel cartViewModel;
    private RecyclerView cartRecycler;
    private CartAdapter cartAdapter;
    private TextView Continue, totalPrice;
    private double Total = 0;
//    public menu_CartFragment() {
//        // Required empty public constructor
//    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu__cart, container, false);
        cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        cartRecycler = view.findViewById(R.id.cartRecycler);
        Continue = view.findViewById(R.id.Continue);
        totalPrice = view.findViewById(R.id.totalPrice);
        cartViewModel.CartLiveData().observe(getViewLifecycleOwner(), carts -> {
            if (carts.size() != 0) {
                cartAdapter = new CartAdapter(carts);
                cartRecycler.setAdapter(cartAdapter);
                for (int i = 0; i < carts.size(); i++) {
                    Total = Total + carts.get(i).getPrice() * carts.get(i).getQuantity();
                    totalPrice.setText(String.format("%s", Total));
                }
            }

        });
        Continue.setOnClickListener(v -> {
            Intent intent = new Intent();
            Navigation.findNavController(v).navigate(R.id.action_menu_Cart_to_addressFragment, new Bundle());
        });

        return view;
    }
}