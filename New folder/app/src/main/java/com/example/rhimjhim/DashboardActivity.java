package com.example.rhimjhim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.rhimjhim.databinding.ActivityDashboardBinding;

public class DashboardActivity extends DrawerActivity {

    ActivityDashboardBinding activityDashboardBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        activityDashboardBinding=ActivityDashboardBinding.inflate(getLayoutInflater());
        allocateActivityTitle("Dashboard");
        setContentView(activityDashboardBinding.getRoot());
    }
}