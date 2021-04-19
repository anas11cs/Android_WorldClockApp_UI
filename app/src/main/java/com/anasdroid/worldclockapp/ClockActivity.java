package com.anasdroid.worldclockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ClockActivity extends AppCompatActivity implements dataListener{

    ImageView addCountryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        // ========
        addCountryButton= (ImageView) findViewById(R.id.addCountry);
        addCountryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mainActivityInit();
            }
        });
    }
    // ============
    public void mainActivityInit(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    // ============
    @Override
    public void onDataChange(boolean AddOrRemove) {

    }
}