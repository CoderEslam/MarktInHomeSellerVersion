package com.doubleclick.marktinhome.ui.MainScreen;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.doubleclick.ViewModel.ProductViewModel;
import com.doubleclick.ViewModel.RecentSearchViewModel;
import com.doubleclick.ViewModel.UserViewModel;
import com.doubleclick.marktinhome.Adapters.NavAdapter;
import com.doubleclick.marktinhome.Model.ChildCategory;
import com.doubleclick.marktinhome.Model.ClassificationPC;
import com.doubleclick.marktinhome.Model.User;
import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.Repository.Sending;
import com.doubleclick.marktinhome.Views.SmoothButtom.SmoothBottomBar;
import com.doubleclick.marktinhome.ui.Filter.FilterActivity;
import com.doubleclick.marktinhome.ui.MainScreen.Frgments.RecentOrderFragment;
import com.doubleclick.marktinhome.ui.MainScreen.Parents.ParentActivity;
import com.doubleclick.marktinhome.ui.ProductActivity.productFragment;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainScreenActivity extends AppCompatActivity implements NavAdapter.onClickChild {

    private SmoothBottomBar bottomBar;
    private NavController navController;
    private RecyclerView menu_recycler_view;
    private ProductViewModel productViewModel;
    private SearchView search;
    private FlowingDrawer drawerLayout;
    private ImageView openDrawer;
    private UserViewModel userViewModel;
    private CircleImageView myImage;
    private View main_fragment;
    private RecentSearchViewModel recentSearchViewModel;
    private String ProductId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        recentSearchViewModel = new ViewModelProvider(this).get(RecentSearchViewModel.class);
        ProductId = getIntent().getStringExtra("ProductId");
        main_fragment = findViewById(R.id.main_fragment);
        navController = Navigation.findNavController(this, main_fragment.getId());
        menu_recycler_view = findViewById(R.id.menu_recycler_view);
        search = findViewById(R.id.search);
        bottomBar = findViewById(R.id.bottomBar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        openDrawer = findViewById(R.id.openDrawer);
        drawerLayout = findViewById(R.id.drawer_layout);
        myImage = findViewById(R.id.myImage);
        drawerLayout.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                Glide.with(MainScreenActivity.this).load(user.getImage()).into(myImage);
            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.menu_Cart, R.id.menu_group, R.id.homeFragment, R.id.menu_profile).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        setupSmoothBottomMenu();
        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        productViewModel.getClassificationPC().observe(this, classificationPCS -> {
            NavAdapter catecoriesAdapter = new NavAdapter(classificationPCS, this);
            menu_recycler_view.setAdapter(catecoriesAdapter);
        });

        openDrawer.setOnClickListener(v -> {
            drawerLayout.openMenu(true);
        });

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.contains("https://com.doubleclick.marktinhome/")) {
                    String[] url = query.split("com.doubleclick.marktinhome/");
                    String idProduct = url[1];
                    Intent intent = new Intent(MainScreenActivity.this, FilterActivity.class);
                    intent.putExtra("id", idProduct);
                    intent.putExtra("type", "ProductId");
                    startActivity(intent);
                } else {
                    Sending.Check(query, MainScreenActivity.this, MainScreenActivity.this);
                    Intent intent = new Intent(MainScreenActivity.this, FilterActivity.class);
                    intent.putExtra("id", query);
                    intent.putExtra("type", "search");
                    startActivity(intent);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        //  https://developer.android.com/training/sharing/receive#java
        Share(ProductId);
    }

    private void Share(String idProduct) {
        try {
            if (!ProductId.equals("")) {
                Intent intent = new Intent(MainScreenActivity.this, FilterActivity.class);
                intent.putExtra("id", idProduct);
                intent.putExtra("type", "ProductId");
                startActivity(intent);
            }
        } catch (NullPointerException e) {

        }

    }


    private void setupSmoothBottomMenu() {
        PopupMenu popupMenu = new PopupMenu(this, null);
        popupMenu.inflate(R.menu.menu_bottom);
        Menu menu = popupMenu.getMenu();
        bottomBar.setupWithNavController(menu, navController);
    }

    @Override
    public void onClickedNavChild(ChildCategory childCategory) {
        Intent intent = new Intent(MainScreenActivity.this, FilterActivity.class);
        intent.putExtra("id", childCategory.getPushId());
        intent.putExtra("type", "childId");
        startActivity(intent);
    }

    @Override
    public void onClickedNavParent(ClassificationPC classificationPC) {
        Intent intent = new Intent(MainScreenActivity.this, ParentActivity.class);
        intent.putExtra("classificationPC", classificationPC);
        startActivity(intent);
    }

}