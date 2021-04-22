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

public class dataAdapter extends RecyclerView.Adapter<dataAdapter.ViewHolder> {

    View view;
    Context context;
    ArrayList<country> arrayList;
    dataListener DataListener;

    public ArrayList<country> getFreshData() {
        return this.arrayList;
    }
//    ArrayList<country> arrayListSelected = new ArrayList<>();

    public class ViewHolder extends RecyclerView.ViewHolder {

        CheckBox checkbox;
        TextView timetxt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkbox = itemView.findViewById(R.id.checkbox);
            timetxt = itemView.findViewById(R.id.timeCountry);
        }
    }

    public dataAdapter(Context context, ArrayList<country> arrayList, dataListener DataListener) {
        this.context = context;
        this.arrayList = arrayList;
        this.DataListener = DataListener;
    }

    public View getView() {
        return view;
    }

    // double click Adapter written after RecyclerView, it auto creates 3hree methods
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.countryitemwithcheckbox, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(arrayList!=null && arrayList.size()>0){
            if(arrayList.get(position).VisibilityCountry==true){
                holder.checkbox.setChecked(true);
            }
            holder.checkbox.setText(arrayList.get(position).CountryName);
            holder.timetxt.setText(arrayList.get(position).Time);
            holder.checkbox.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    if(holder.checkbox.isChecked()){
                        arrayList.get(position).VisibilityCountry=true;
                        //arrayListSelected.add(arrayList.get(position));
                        DataListener.onDataChange(true);
                    }
                    else
                    {
                        arrayList.get(position).VisibilityCountry=false;
                        //arrayListSelected.remove(arrayList.get(position));
                        DataListener.onDataChange(false);
                    }

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
