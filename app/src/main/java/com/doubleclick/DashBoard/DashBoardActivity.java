package com.doubleclick.DashBoard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.databinding.ActivityDashBoardBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Objects;


public class DashBoardActivity extends AppCompatActivity  {

    private ActivityDashBoardBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().add(R.id.container, new LineColumnFragment()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.mapContiner,new MapsFragment()).commit();
        binding.speedView.speedTo(2000);



    }

}