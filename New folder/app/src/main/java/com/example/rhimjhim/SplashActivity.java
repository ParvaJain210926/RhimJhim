package com.example.rhimjhim;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TextView textView=findViewById(R.id.Text1);
        textView.animate().translationX(2000).setDuration(2000).setStartDelay(3500);
        Thread thread=new Thread()
        {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(4000);

                }
                catch(Exception e){
                    e.printStackTrace();

                }
                finally {
                    Intent intent = new Intent(SplashActivity.this,WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }


        };
        thread.start();

        }



    };