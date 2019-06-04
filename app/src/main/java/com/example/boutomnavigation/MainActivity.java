package com.example.boutomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;
    ActionBar toolbar;
    Fragment fragment;
    int selected = R.id.home;
    Stack<Integer> stack = new Stack<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = getSupportActionBar();
        toolbar.setTitle("Home");

        loadFragment(new HomeFragment(), true);
        stack.push(R.id.home);

        navigationView = findViewById(R.id.nav);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.home:
                        stack.push(selected);
                        selected = R.id.home;
                        toolbar.setTitle("Home");
                        fragment = new HomeFragment();
                        loadFragment(fragment, false);
                        return true;
                    case R.id.world:
                        stack.push(selected);
                        selected = R.id.world;
                        toolbar.setTitle("World");
                        fragment = new WorldFragment();
                        loadFragment(fragment, false);
                        return true;
                    case R.id.sport:
                        stack.push(selected);
                        selected = R.id.sport;
                        toolbar.setTitle("Sport");
                        fragment = new SportFragment();
                        loadFragment(fragment, false);
                        return true;
                    case R.id.pol:
                        stack.push(selected);
                        selected = R.id.pol;
                        toolbar.setTitle("Politics");
                        fragment = new PoliticsFragment();
                        loadFragment(fragment, false);
                        return true;
                    case R.id.movie:
                        stack.push(selected);
                        selected = R.id.movie;
                        toolbar.setTitle("Movie");
                        fragment = new MovieFragment();
                        loadFragment(fragment, false);
                        return true;


                }
                return true;
            }

        });
    }


    private void loadFragment(Fragment fragment, boolean flag) {

        if (flag) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame, fragment);
            transaction.commit();
        } else {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame, fragment, "A");
            transaction.addToBackStack("A");
            transaction.commit();
        }

    }

    @Override
    public void onBackPressed() {


        super.onBackPressed();

        if(!stack.empty())
        switch (stack.pop()) {
            case R.id.home:
                navigationView.getMenu().findItem(R.id.home).setChecked(true);
                break;
            case R.id.world:
                navigationView.getMenu().findItem(R.id.world).setChecked(true);
                break;
            case R.id.sport:
                navigationView.getMenu().findItem(R.id.sport).setChecked(true);
                break;
            case R.id.pol:
                navigationView.getMenu().findItem(R.id.pol).setChecked(true);
                break;
            case R.id.movie:
                navigationView.getMenu().findItem(R.id.movie).setChecked(true);
                break;


        }

    }

}
