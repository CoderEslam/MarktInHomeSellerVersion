package com.doubleclick.marktinhome.ui.MainScreen.Frgments;

import android.os.Bundle;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.doubleclick.ViewModel.ProductViewModel;
import com.doubleclick.marktinhome.BaseFragment;
import com.doubleclick.marktinhome.Model.Product;
import com.doubleclick.marktinhome.R;

import java.util.ArrayList;
import java.util.Objects;


public class menu_storeFragment extends BaseFragment {


    private ProductViewModel productViewModel;


    public menu_storeFragment() {
        // Required empty public constructor
    }


    public static menu_storeFragment newInstance(String param1, String param2) {
        menu_storeFragment fragment = new menu_storeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_store, container, false);
        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        productViewModel.getArranged().observe(getViewLifecycleOwner(), new Observer<ArrayList<ArrayList<ArrayList<Product>>>>() {
            @Override
            public void onChanged(ArrayList<ArrayList<ArrayList<Product>>> arrayLists) {
                Log.e("arrayLists", arrayLists.toString());
            }
        });
        productViewModel.getParent().observe(getViewLifecycleOwner(), parentCategories -> {
            Log.e("Parents", parentCategories.toString());
        });
        productViewModel.getChildren().observe(getViewLifecycleOwner(), childCategories -> {
            Log.e("Children", childCategories.toString());
        });
        FragmentManager fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
        fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, new HomeFragment()).commit();

        return view;
    }

}