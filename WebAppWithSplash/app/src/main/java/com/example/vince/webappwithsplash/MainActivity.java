package com.example.vince.webappwithsplash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView pageone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       pageone = findViewById(R.id.web);
        WebSettings settings = pageone.getSettings();
        settings.setJavaScriptEnabled(true);
        pageone.loadUrl("https://www.emobilis.ac.ke");
        //pageone.loadUrl("file://android_asset/home.html");
    }
}