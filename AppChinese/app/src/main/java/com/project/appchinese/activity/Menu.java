package com.project.appchinese.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.project.appchinese.fragments.Me;
import com.project.appchinese.R;
import com.project.appchinese.fragments.Dashboard;
import com.project.appchinese.fragments.Learn;

public class Menu extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.menu);

        getSupportFragmentManager().beginTransaction().replace(R.id.content, new Learn()).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.learn:
                fragment = new Learn();
                break;

            case R.id.dashboard:
                fragment = new Dashboard();
                break;

            case R.id.me:
                fragment = new Me();
                break;
        }

        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
        }
        return true;
    }

    public void onClickBasis1(View view){
        Intent intent = new Intent(this, Exo1.class);
        startActivity(intent);
    }
}