package com.improlabs.godslave.teletalkwebapp;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    String HOME_PAGE = "http://sts.teletalk.com.bd";
    private WebView ttalkWebView;
    private Handler handler;
    private LayoutRunnable layoutRunnable;

    public MainActivity() {
        super();
        this.layoutRunnable = new LayoutRunnable();
        this.handler = new Handler();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.handler.post(this.layoutRunnable);


        }


    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        if (ttalkWebView.canGoBack()) {
            ttalkWebView.goBack();
        } else {
            super.onBackPressed();
        }
        }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Asad","Web view Activity is paused");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("Asad", "Web view Activity is resumed");
    }

    public class LayoutRunnable implements Runnable {
        @Override
        public void run() {

            MainActivity.this.setContentView(R.layout.activity_main);
           // setContentView(R.layout.activity_main);

            MainActivity.this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            MainActivity.this.getSupportActionBar().setCustomView(R.layout.custom_actionbar);

            MainActivity.this.ttalkWebView = (WebView) findViewById(R.id.myWebView);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                ttalkWebView.setVerticalScrollbarPosition(2);
            }
            MainActivity.this.ttalkWebView.loadUrl(HOME_PAGE);
            MainActivity.this.ttalkWebView.setWebViewClient(new ImproWebViewClient(MainActivity.this));
            WebSettings webSettings = ttalkWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            ///
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.this.ttalkWebView.scrollTo(0, 0);
                }
            });


            MainActivity.this.fireSplashScreen();

        }
    }

    private void fireSplashScreen() {
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
    }
}
