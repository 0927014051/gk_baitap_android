package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class MainHome extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        setControl();
        setEvent();
    }

    private void setEvent() {
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.namebt,R.string.namebt );
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                if(item.getItemId() == R.id.mnDanhSach){
                    Toast.makeText(MainHome.this, "Danh sách", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(MainHome.this, MainDanhSach.class);
//                    startActivity(intent);
                    fragment = new FragmentDanhSach();

                }
                if(item.getItemId() == R.id.mnGioHang){
                    Toast.makeText(MainHome.this, "Giỏ hàng", Toast.LENGTH_SHORT).show();
                    fragment = new FragmentGioHang();
                }
                if(item.getItemId() == R.id.mnCaiDat){
                    Toast.makeText(MainHome.this, "Cài đặt", Toast.LENGTH_SHORT).show();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.flContent, fragment).commit();
                drawerLayout.close();
                return false;
            }
        });
    }

    private void setControl() {
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        if(item.getItemId() == R.id.mnDanhSach){
            Toast.makeText(this, "Danh sách 1", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


}