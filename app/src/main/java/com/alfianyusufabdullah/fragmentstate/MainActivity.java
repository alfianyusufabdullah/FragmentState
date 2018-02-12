package com.alfianyusufabdullah.fragmentstate;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.alfianyusufabdullah.fragmentstate.fragment.Fragment1;
import com.alfianyusufabdullah.fragmentstate.fragment.Fragment2;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    Fragment fragment;
    String KEY_FRAGMENT = "FRAGMENT_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);

        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.menu_1:
                        fragment = new Fragment1();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragmentContainer, fragment)
                                .commit();
                        return true;
                    case R.id.menu_2:
                        fragment = new Fragment2();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragmentContainer, fragment)
                                .commit();
                        return true;
                    default:
                        return false;
                }
            }
        });

        if (savedInstanceState != null){
            fragment = getSupportFragmentManager().getFragment(savedInstanceState , KEY_FRAGMENT);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .commit();
        } else {
            fragment = new Fragment1();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        getSupportFragmentManager().putFragment(outState , KEY_FRAGMENT , fragment);
        super.onSaveInstanceState(outState);
    }
}
