package com.example.online;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Data> {
    private Activity context;
    private List<Data> dataList;

    public CustomAdapter(Activity context, List<Data> dataList) {
        super(context, R.layout.fetch_layout, dataList);
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        LayoutInflater layoutInflater= context.getLayoutInflater();
        View view= layoutInflater.inflate(R.layout.fetch_layout,null,true);

        Data data=dataList.get(position);

        TextView fdata;

        fdata= view.findViewById(R.id.fdata);

        fdata.setText(data.getDate()+data.getTime()+"     "+data.getType()+"      "+data.getReading());

        return view;
    }
}
