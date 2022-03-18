package com.doubleclick.marktinhome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.doubleclick.marktinhome.Adapters.ViewPagerAdapter;
import com.doubleclick.marktinhome.Views.liquid_swipe.LiquidPager;
import com.doubleclick.marktinhome.ui.MainScreen.MainScreenActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private LiquidPager pager;
    private ViewPagerAdapter viewPager;
    public FirebaseAuth mAuth;
    public FirebaseAuth.AuthStateListener firebaseAuthListener;
    String ProductId = "NoUrl";

    public MainActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.pager);
        viewPager = new ViewPagerAdapter(getSupportFragmentManager(), 1);
        pager.setAdapter(viewPager);
        mAuth = FirebaseAuth.getInstance();
        Share();
        firebaseAuthListener = firebaseAuth -> {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                Intent intent = new Intent(this, MainScreenActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                finish();
                startActivity(intent);
            }
        };


    }

    private void Share() {
        Uri uri = getIntent().getData();
        if (uri != null) {
            List<String> parms = uri.getPathSegments();
            ProductId = parms.get(parms.size() - 1);
            Intent intent = new Intent(this, MainScreenActivity.class);
            if (!ProductId.equals("NoUrl")) {
                intent.putExtra("ProductId", ProductId);
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            finish();
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseAuthListener);
    }
}