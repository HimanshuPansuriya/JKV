package com.example.jkv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @BindView(R.id.jkv_logo)
    ImageView jkv_logo;
    @BindView(R.id.navigationView)
    NavigationView navigationView;

    @BindView(R.id.dropdown_menu)
    ImageView dropdown_menu;

    @SuppressLint({"MissingInflatedId", "RestrictedApi"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        registerForContextMenu(dropdown_menu);

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);


        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        View headerView = getLayoutInflater().inflate(R.layout.navigation_header_view, drawerLayout, false);
        navigationView.addHeaderView(headerView);

        dropdown_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
                setNavigationViewListener();

            }
        });

    }
   
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        // Handle other menu item clicks here
        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
                return true;
            case R.id.about_us:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new AboutFragment()).commit();
                return true;
            case R.id.our_products:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new AccessoriesFragment()).commit();
                return true;
            case R.id.contect_us:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new ContectFragment()).commit();
                return true;
            case R.id.inquire_form:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new EnquiryFragment()).commit();
                return true;
            default:

        }

        return false;
    }

}
