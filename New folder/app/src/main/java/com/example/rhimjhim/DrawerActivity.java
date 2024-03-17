package com.example.rhimjhim;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class DrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    @Override
   public void setContentView(View view){


        drawer=(DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer,null);
        FrameLayout container = drawer.findViewById(R.id.activityContainer);
        container.addView(view);
        super.setContentView(drawer);

        Toolbar toolbar=drawer.findViewById(R.id.navi_Toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView=drawer.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.Dopen,R.string.Dclose);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }

    @SuppressLint("NonConstantResourceId")
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               drawer.closeDrawer(GravityCompat.START);


       /* switch (item.getItemId()){

            case R.id.nav_customer :
                startActivity(new Intent(this,CustomerActivity.class));
                overridePendingTransition(0,0);
                break;


            case R.id.nav_order:
                startActivity(new Intent(this,OrderActivity.class));
                overridePendingTransition(0,0);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        } */
        return false;
    }

    protected void  allocateActivityTitle(String titleString){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(titleString);
        }
    }
}