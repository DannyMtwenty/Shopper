package com.example.shopper.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.shopper.R;
import com.example.shopper.ShopperActivity;

import gr.net.maroulis.library.EasySplashScreen;

public class SplachActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);
        EasySplashScreen welcome = new EasySplashScreen(SplachActivity.this)
                .withFullScreen()
                .withTargetActivity(ShopperActivity.class)
                .withSplashTimeOut(5000)
                //.withLogo(R.drawable.key1)
                .withBackgroundColor(Color.parseColor("#FFFFFF"))
                .withHeaderText("Welcome to The Shopper!")
                .withAfterLogoText("Helping to plan wisely for better tommorow")
                .withFooterText("Copyright @ WannyWanyoike");

        welcome.getHeaderTextView().setTextColor(Color.BLUE);
        welcome.getHeaderTextView().setTextSize(15);
        welcome.getFooterTextView().setTextSize(15);
        welcome.getAfterLogoTextView().setTextSize(15);
        welcome.getAfterLogoTextView().setTextColor(Color.GREEN);
        welcome.getFooterTextView().setTextColor(Color.DKGRAY);

        View view = welcome.create();
        setContentView(view);
    }
}