package com.stq.whattoeat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.OnKeyboardListener;
import com.stq.whattoeat.adapter.ViewPagerAdapter;
import com.stq.whattoeat.fragment.HomeFragment;
import com.stq.whattoeat.fragment.UserFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImmersionBar.with(this)
                .transparentNavigationBar()
                .statusBarDarkFont(true)
                .fitsSystemWindows(true)
                .autoDarkModeEnable(true, 0.2f)
                .navigationBarDarkIcon(true)
                .init();

        initBottomNavigation();
        initPager();
    }

    //fragment初始化
    private void initPager() {
        viewPager = findViewById(R.id.viewpager);
        ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new UserFragment());
        ViewPagerAdapter myViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle(), fragmentList);
        viewPager.setAdapter(myViewPagerAdapter);
    }

    //bottomNavigation
    private void initBottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        viewPager.setCurrentItem(0);
                        bottomNavigationView.getMenu().getItem(0).setChecked(true);
                        return true;
                    case R.id.user:
                        viewPager.setCurrentItem(1);
                        bottomNavigationView.getMenu().getItem(1).setChecked(true);
                        return true;
                }
                return false;
            }
        });
    }


}