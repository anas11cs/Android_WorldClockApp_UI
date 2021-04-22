package com.anasdroid.worldclockapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class dataAdapterClock extends RecyclerView.Adapter<dataAdapterClock.ViewHolder> {

    View view;
    Context context;
    ArrayList<country> arrayL;

/*    public ArrayList<country> getFreshData() {
        return this.arrayL;
    }*/

    public dataAdapterClock(Context context, ArrayList<country> arrayL) {
        this.context = context;
        this.arrayL = arrayL;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.countryitemtime, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(arrayL!=null && arrayL.size()>0){
            if(arrayL.get(position).VisibilityCountry){
                //System.out.println(arrayL.get(position).CountryName);
                holder.countrytxt.setText(arrayL.get(position).CountryName);
                holder.timetxt.setText(arrayL.get(position).Time);
            }
        }
    }

    @Override
    public int getItemCount() {
        return arrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView countrytxt;
        TextView timetxt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            countrytxt = itemView.findViewById(R.id.countryName);
            timetxt = itemView.findViewById(R.id.timeMainCountry);
        }
    }

    // Class Variables and Methods Above ==========

/*    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.countryitemtime, parent, false);
        return new ViewHolder(view);
    }
    // =========
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(arrayL!=null && arrayL.size()>0){
            if(arrayL.get(position).VisibilityCountry){
                System.out.println(arrayL.get(position).CountryName);
                holder.countrytxt.setText(arrayL.get(position).CountryName);
                holder.timetxt.setText(arrayL.get(position).Time);
            }
        }
    }
    // =========
    @Override
    public int getItemCount() {
        return 0;
    }*/
}
