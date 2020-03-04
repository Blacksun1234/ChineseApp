package com.project.appchinese;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new Learn()).commit();
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.neg_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
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

                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
                    return true;
                }
            };
}
