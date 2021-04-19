package com.anasdroid.worldclockapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements dataListener{

    RecyclerView availableCountriesRecyclerView;
    dataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        availableCountriesRecyclerView = findViewById(R.id.availableCountriesRecyclerView);
        set_AvailableCountries_RecyclerView();
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

    private ArrayList<Country> getData(){
        ArrayList<Country> dataList = new ArrayList<>();
        dataList.add(new Country("Germany","11:01 PM"));
        dataList.add(new Country("France","11:01 PM"));
        dataList.add(new Country("America","11:01 PM"));
        dataList.add(new Country("Afghanistan","11:01 PM"));
        dataList.add(new Country("Algeria","11:01 PM"));
        dataList.add(new Country("Andorra","11:01 PM"));
        dataList.add(new Country("Austria","11:01 PM"));
        dataList.add(new Country("Austrian Empire","11:01 PM"));
        dataList.add(new Country("Azerbaijan","11:01 PM"));
        dataList.add(new Country("Bahrain","11:01 PM"));
        dataList.add(new Country("Bangladesh","11:01 PM"));
        dataList.add(new Country("Belarus","11:01 PM"));
        dataList.add(new Country("Belgium","11:01 PM"));
        dataList.add(new Country("Bolivia","11:01 PM"));
        dataList.add(new Country("Brazil","11:01 PM"));
        dataList.add(new Country("Bulgaria","11:01 PM"));
        dataList.add(new Country("Burma","11:01 PM"));
        dataList.add(new Country("Burundi","11:01 PM"));
        dataList.add(new Country("Madagascar","11:01 PM"));
        dataList.add(new Country("Malawi","11:01 PM"));
        dataList.add(new Country("Maldives","11:01 PM"));
        dataList.add(new Country("Mali","11:01 PM"));
        dataList.add(new Country("Malta","11:01 PM"));
        dataList.add(new Country("Austrian Marshall Islands","11:01 PM"));
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