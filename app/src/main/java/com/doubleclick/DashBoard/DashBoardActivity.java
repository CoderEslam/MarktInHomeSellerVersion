package com.doubleclick.DashBoard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.databinding.ActivityDashBoardBinding;


public class DashBoardActivity extends AppCompatActivity {

    private ActivityDashBoardBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().add(R.id.containerStatistics, new StatisticsFragment()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.mapContiner, new MapsFragment()).commit();
        binding.speedView.speedTo(2000);

    }

}