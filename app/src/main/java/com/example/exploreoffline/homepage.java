package com.example.exploreoffline;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.exploreoffline.databinding.ActivityHomepageBinding;
import com.example.exploreoffline.ui.gallery.fragmentgallery;
import com.example.exploreoffline.ui.home.fragmenthome;
import com.example.exploreoffline.ui.map.fragmentmap;
import com.example.exploreoffline.ui.route.fragmentroute;
import com.google.android.material.navigation.NavigationView;

public class homepage extends AppCompatActivity  {
//implements NavigationView.OnNavigationItemSelectedListener

//    private DrawerLayout drawerLayout;
//    private ActionBarDrawerToggle toggle;
//    private NavigationView navigationView;

    ActivityHomepageBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomepageBinding.inflate(getLayoutInflater());
//        setContentView(R.layout.activity_homepage);
        setContentView(binding.getRoot());
        replaceFragemt(new fragmenthome());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragemt(new fragmenthome());
                    break;
                case R.id.maps:
                    replaceFragemt(new fragmentmap());
                    break;
                case R.id.route:
                    replaceFragemt(new fragmentroute());
                    break;
                case R.id.gallery:
                    replaceFragemt(new fragmentgallery());
                    break;
            }
            return true;
        });


//        drawerLayout = findViewById(R.id.drawerlayout);
//        navigationView = findViewById(R.id.navigation_view);
//
//        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);
//
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//
//        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
//
//        navigationView.setNavigationItemSelectedListener(this);
    }

    private void replaceFragemt(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();

    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.profile:
//                Toast.makeText(this,"Home", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.aboutus:
//                Toast.makeText(this,"About Us", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.contactus:
//                Toast.makeText(this,"Contact Us", Toast.LENGTH_SHORT).show();
//                break;
//        }
//        return true;
//    }
}