package com.project.appchinese.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.project.appchinese.R;
import com.project.appchinese.adapters.MenuAdapter;

public class MenuActivity extends AppCompatActivity
{
    private ViewPager pager;
    private MenuAdapter adapter;


    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        pager = findViewById(R.id.pager);
        tabs = findViewById(R.id.navigation);

        adapter = new MenuAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);

        setTabs();
    }

    private  void setTabs()
    {
        tabs.getTabAt(0).setIcon(R.drawable.ic_learn_black_24dp);
        tabs.getTabAt(0).setText(R.string.learn);

        tabs.getTabAt(1).setIcon(R.drawable.ic_dashboard_black_24dp);
        tabs.getTabAt(1).setText(R.string.dashboard);

        tabs.getTabAt(2).setIcon(R.drawable.ic_account_circle_black_24dp);
        tabs.getTabAt(2).setText(R.string.me);
    }
}