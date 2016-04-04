package com.improlabs.godslave.teletalkwebapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by godslave on 03/04/2016.
 */
public class ImproWebViewClient extends WebViewClient{
    String HOME_PAGE = "sts.teletalk.com.bd";
    private Activity callerActivity;
    public ImproWebViewClient(Activity callerActivity) {
        callerActivity = callerActivity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
      //  return super.shouldOverrideUrlLoading(view, url);
        if(Uri.parse(url).getHost().equals(HOME_PAGE)){
            return false;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        callerActivity.startActivity(intent);
        return true;
    }
}
