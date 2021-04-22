package com.anasdroid.worldclockapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class ClockActivity extends AppCompatActivity{

    RecyclerView selectedCountriesRecyclerView;
    dataAdapterClock adapter;
    ImageView addCountryButton;
    ArrayList<country> ParentArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        selectedCountriesRecyclerView = findViewById(R.id.selectedCountriesRecycler);
        Bundle bundle = getIntent().getExtras();
        //ArrayList<country> arrayList = bundle.getParcelableArrayList("freshDataList");
       if ( bundle == null ) {
            System.out.println("OnCreate:If-ClockActivity");
            // This is the case when you are opening this Activity for the for the first time
            set_SelectedCountries_RecyclerView(null);
       } else {
            // Restore value of members from saved state
            System.out.println("OnCreate:Else");
            set_SelectedCountries_RecyclerView(bundle.getParcelableArrayList("freshDataList"));
        }

        // ======== Adding Click Listener for Activity Switch ======
        addCountryButton = (ImageView) findViewById(R.id.addCountry);
        addCountryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mainActivityInit();
            }
        });
    }

    private ArrayList<country> getData() {
        ArrayList<country> dataList = new ArrayList<>();
        dataList.add(new country("America","11:01 PM",true));
        dataList.add(new country("Afghanistan","11:01 PM",false));
        dataList.add(new country("Algeria","11:01 PM",true));
        dataList.add(new country("Andorra","11:01 PM",false));
        dataList.add(new country("Austria","1:01 PM",false));
        dataList.add(new country("Austrian Empire","12:01 PM",false));
        dataList.add(new country("Azerbaijan","2:01 PM",false));
        dataList.add(new country("Bahrain","4:01 PM",true));
        dataList.add(new country("Bangladesh","11:01 PM",false));
        dataList.add(new country("Belarus","3:01 PM",false));
        dataList.add(new country("Belgium","11:01 PM",false));
        dataList.add(new country("Bolivia","11:01 PM",false));
        dataList.add(new country("Brazil","9:01 PM",false));
        dataList.add(new country("Bulgaria","11:01 PM",true));
        dataList.add(new country("Burma","11:01 PM",false));
        dataList.add(new country("Burundi","10:00 AM",false));
        dataList.add(new country("Madagascar","11:01 PM",true));
        dataList.add(new country("Malawi","11:01 PM",false));
        dataList.add(new country("Maldives","11:01 PM",false));
        dataList.add(new country("Mali","11:01 PM",true));
        dataList.add(new country("Malta","11:01 PM",false));
        dataList.add(new country("Austrian Marshall Islands","11:01 PM",false));
        return dataList;
    }
    public ArrayList<country> getCorrectData(ArrayList<country> countryArray){
        ArrayList<country> returnArray= new ArrayList<>();
        for(int i=0;i<countryArray.size();i++){
            if(countryArray.get(i).VisibilityCountry==true){
                returnArray.add(new country(countryArray.get(i)));
            }
        }
        return returnArray;
    }
    private void set_SelectedCountries_RecyclerView(ArrayList<country> arrayL) {
        this.selectedCountriesRecyclerView.setHasFixedSize(true);
        this.selectedCountriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        if(arrayL==null) {
            this.ParentArray = getData();
            adapter = new dataAdapterClock(this, getCorrectData(getData()));
        }
        else {
            this.ParentArray=arrayL;
            adapter = new dataAdapterClock(this, getCorrectData(arrayL));
        }
        this.selectedCountriesRecyclerView.setAdapter(adapter);
    }

    public ArrayList<country> getFreshDataForNewActivity(){
        return this.ParentArray;
    }//OnSaveInstanceState Ends Here !
    // ============
    public void mainActivityInit(){
        //
        Intent intent = new Intent(this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("freshDataList", getFreshDataForNewActivity());
        System.out.println("In: mainActivityInit-ClockActivity");
        intent.putExtras(bundle);
        this.startActivity(intent);
        finish();
    }
    // ============
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
}