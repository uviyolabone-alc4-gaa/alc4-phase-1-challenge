package com.uviyolabone.alcchallenge;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutALCActivity extends AppCompatActivity {

    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myWebView = new WebView(getApplicationContext());
        setContentView(myWebView);

        initView();
    }

    private void initView() {

        //setting the toolbar
        setTitle(R.string.about_alc);

        // Configure related browser settings
        myWebView.getSettings().setLoadsImagesAutomatically(true);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        myWebView.setWebViewClient(new WebViewClient(){


            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }

        });

        // Load the initial URL
        myWebView.loadUrl("https://andela.com/alc");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
