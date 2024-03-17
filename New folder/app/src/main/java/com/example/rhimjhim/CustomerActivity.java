package com.example.rhimjhim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.rhimjhim.databinding.ActivityCustomerBinding;

public class CustomerActivity extends DrawerActivity {

    ActivityCustomerBinding activityCustomerBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        activityCustomerBinding=ActivityCustomerBinding.inflate(getLayoutInflater());
        setContentView(activityCustomerBinding.getRoot());
        allocateActivityTitle("Customers");
    }
}