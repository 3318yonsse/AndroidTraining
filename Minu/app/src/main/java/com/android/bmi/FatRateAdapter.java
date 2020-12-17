package com.android.bmi;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FatRateAdapter extends BaseAdapter {

    //field
    private Context fContext = null;
    private int layout = 0;

    //Bean
    private ArrayList<FatRate> data = null;
    private LayoutInflater inflater = null;

    //---------------------------------------


    public FatRateAdapter(Context fContext, int layout, ArrayList<FatRate> data) {
        this.fContext = fContext;
        this.layout = layout;
        this.data = data;

        this.inflater = (LayoutInflater) fContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getState();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = inflater.inflate(this.layout,parent, false);
        }

        ImageView color = convertView.findViewById(R.id.image_color);
        TextView state = convertView.findViewById(R.id.textview_state);
        TextView rate = convertView.findViewById(R.id.textview_rate);
        //        java Bean에서 가져오는 것.
        Log.v("로그", String.valueOf(color));
        color.setImageResource(data.get(position).getColor());
        state.setText(data.get(position).getState());
        rate.setText(data.get(position).getPercentage());


        return convertView;

    }


}
