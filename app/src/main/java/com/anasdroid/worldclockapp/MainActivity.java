package com.anasdroid.worldclockapp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements dataListener{

    RecyclerView availableCountriesRecyclerView;
    dataAdapter adapter;
    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        availableCountriesRecyclerView = findViewById(R.id.availableCountriesRecyclerView);
        set_AvailableCountries_RecyclerView();
        // Back Button in Main Activity
        backButton= (ImageView) findViewById(R.id.showCountries);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clockActivityInit();
            }
        });

/*        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    public void clockActivityInit(){
        Intent intent = new Intent(this, ClockActivity.class);
        startActivity(intent);
    }

    private ArrayList<country> getData(){
        ArrayList<country> dataList = new ArrayList<>();
        dataList.add(new country("Germany","11:01 PM"));
        dataList.add(new country("France","11:01 PM"));
        dataList.add(new country("America","11:01 PM"));
        dataList.add(new country("Afghanistan","11:01 PM"));
        dataList.add(new country("Algeria","11:01 PM"));
        dataList.add(new country("Andorra","11:01 PM"));
        dataList.add(new country("Austria","11:01 PM"));
        dataList.add(new country("Austrian Empire","11:01 PM"));
        dataList.add(new country("Azerbaijan","11:01 PM"));
        dataList.add(new country("Bahrain","11:01 PM"));
        dataList.add(new country("Bangladesh","11:01 PM"));
        dataList.add(new country("Belarus","11:01 PM"));
        dataList.add(new country("Belgium","11:01 PM"));
        dataList.add(new country("Bolivia","11:01 PM"));
        dataList.add(new country("Brazil","11:01 PM"));
        dataList.add(new country("Bulgaria","11:01 PM"));
        dataList.add(new country("Burma","11:01 PM"));
        dataList.add(new country("Burundi","11:01 PM"));
        dataList.add(new country("Madagascar","11:01 PM"));
        dataList.add(new country("Malawi","11:01 PM"));
        dataList.add(new country("Maldives","11:01 PM"));
        dataList.add(new country("Mali","11:01 PM"));
        dataList.add(new country("Malta","11:01 PM"));
        dataList.add(new country("Austrian Marshall Islands","11:01 PM"));
        return dataList;
    }

    private void set_AvailableCountries_RecyclerView() {
        availableCountriesRecyclerView.setHasFixedSize(true);
        availableCountriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new dataAdapter(this, getData(), this);
        availableCountriesRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDataChange(boolean AddOrRemove) {
        if(AddOrRemove) {
            Toast.makeText(this, "Country Added", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Country Removed", Toast.LENGTH_SHORT).show();
        }
    }
}