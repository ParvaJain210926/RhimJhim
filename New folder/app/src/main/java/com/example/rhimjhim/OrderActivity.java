package com.example.rhimjhim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.rhimjhim.databinding.ActivityOrderBinding;

public class OrderActivity extends DrawerActivity {
    ActivityOrderBinding activityOrderBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        activityOrderBinding=ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(activityOrderBinding.getRoot());
        allocateActivityTitle("Orders");

    }
}