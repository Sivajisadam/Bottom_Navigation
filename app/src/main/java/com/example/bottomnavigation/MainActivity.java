package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bottomnavigation.fragment.HomeFragment;
import com.example.bottomnavigation.fragment.ProfileFragment;
import com.example.bottomnavigation.fragment.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Fragment home = new HomeFragment();
    Fragment profile = new ProfileFragment();
    Fragment settings = new SettingsFragment();

    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment active = home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav();
    }

    private void bottomNav() {
        bottomNavigationView = findViewById(R.id.bottom_nav);
        fragmentManager.beginTransaction().add(R.id.frame_lay, settings, "3").hide(settings).commit();
        fragmentManager.beginTransaction().add(R.id.frame_lay, profile, "2").hide(profile).commit();
        fragmentManager.beginTransaction().add(R.id.frame_lay, home, "1").commit();

        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home :
                        fragmentManager.beginTransaction().hide(active).show(home).commit();
                        active = home;
                        return true;

                    case R.id.profile:
                        fragmentManager.beginTransaction().hide(active).show(profile).commit();
                        active = profile;
                        return true;

                    case R.id.settings:
                        fragmentManager.beginTransaction().hide(active).show(settings).commit();
                        active = settings;
                        return true;
                }
                return false;
            }
        });

    }
}