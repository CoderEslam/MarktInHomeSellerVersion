package com.doubleclick.DashBoard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.doubleclick.ViewModel.RecentOrdersForSellerViewModel;
import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.databinding.ActivityDashBoardBinding;


public class DashBoardActivity extends AppCompatActivity {

    private ActivityDashBoardBinding binding;
    private RecentOrdersForSellerViewModel recentOrdersForSellerViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().add(R.id.containerStatistics, new StatisticsFragment()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.mapContiner, new MapsFragment()).commit();
        recentOrdersForSellerViewModel = new ViewModelProvider(this).get(RecentOrdersForSellerViewModel.class);
        recentOrdersForSellerViewModel.getMoneyLiveData().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double money) {
                binding.totalSales.setText(String.valueOf(money));
            }
        });
        binding.speedView.speedTo(2000);

    }

}