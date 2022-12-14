package com.stq.whattoeat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.WindowManager;

import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.OnKeyboardListener;
import com.stq.whattoeat.adapter.ViewPagerAdapter;
import com.stq.whattoeat.fragment.HomeFragment;
import com.stq.whattoeat.fragment.UserFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager;

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



}