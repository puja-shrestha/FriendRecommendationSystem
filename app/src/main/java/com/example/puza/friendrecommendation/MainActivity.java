package com.example.puza.friendrecommendation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.puza.friendrecommendation.fragments.HomeFragment;
import com.example.puza.friendrecommendation.fragments.MoreFragment;
import com.example.puza.friendrecommendation.fragments.UserFragment;
import com.example.puza.friendrecommendation.helper.BottomNavigationHelper;

public class MainActivity extends AppCompatActivity {

    private static final String SELECTED_ITEM = "arg_selected_item";

    private BottomNavigationView mBottomNav;
    private int mSelectedItem;
    FragmentTransaction transaction;

    Toolbar toolbar;
    TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarTitle = (TextView) findViewById(R.id.toolbarName);

        setSupportActionBar(toolbar);
        setUpBottomNavigation();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, mSelectedItem);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        MenuItem homeItem = mBottomNav.getMenu().getItem(0);
        if (mSelectedItem != homeItem.getItemId()) {
            // select home item
            selectFragment(homeItem);
        } else if (mSelectedItem == homeItem.getItemId()) {
            onBackPressed();
        }
    }

    private void setUpBottomNavigation() {
        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationHelper.removeShiftMode(mBottomNav);
        if (mBottomNav != null) {

            // Select first menu item by default and show Fragment accordingly.
            Menu menu = mBottomNav.getMenu();
            selectFragment(menu.getItem(0));
            mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    selectFragment(item);
                    return true;
                }
            });
        }

    }

    private void selectFragment(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.menu_home:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new HomeFragment());
                toolbarTitle.setText("Users");
                break;
            case R.id.menu_user:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new UserFragment());
                toolbarTitle.setText("Home");
                break;
            case R.id.menu_offer:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new MoreFragment());
                toolbarTitle.setText("More");
                break;
        }
        transaction.commit();
    }
}
