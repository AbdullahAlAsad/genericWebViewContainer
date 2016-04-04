package com.improlabs.godslave.teletalkwebapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.os.Handler;

/**
 * Created by godslave on 03/04/2016.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      //  Intent intent = new Intent(this, MainActivity.class);
      //  startActivity(intent);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },3000);
//        finish();
    }
}
