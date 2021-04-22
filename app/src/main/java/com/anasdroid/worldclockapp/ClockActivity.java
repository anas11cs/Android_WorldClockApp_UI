package com.anasdroid.worldclockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class ClockActivity extends AppCompatActivity implements dataListener{

    ImageView addCountryButton;
    ArrayList<country> arrayL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        // ======= Getting Data from Parcelable =======
        Bundle bundle = getIntent().getExtras();
        //ArrayList<country> arrayList = bundle.getParcelableArrayList("freshDataList");
        arrayL = bundle.getParcelableArrayList("freshDataList");
        // ======== Adding Click Listener for Activity Switch ======
        addCountryButton = (ImageView) findViewById(R.id.addCountry);
        addCountryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mainActivityInit();
            }
        });
    }
    public ArrayList<country> getFreshDataForNewActivity(){
        return this.arrayL;
    }//OnSaveInstanceState Ends Here !
    // ============
    public void mainActivityInit(){
        //
        Intent intent = new Intent(this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("freshDataList", getFreshDataForNewActivity());
        System.out.println("In: mainActivityInit");
        intent.putExtras(bundle);
        this.startActivity(intent);
        finish();
    }
    // ============
    @Override
    public void onDataChange(boolean AddOrRemove) {
        return;
    }
}