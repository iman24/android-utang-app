package com.imanancin.utangapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.imanancin.utangapp.R;

public class SplashScreenActivity extends AppCompatActivity {

    private int WAIT_TIME = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                // panggil finish supaya aktivity di hapus / tdk bisa di back
                finish();
            }
        }, WAIT_TIME);
    }
}