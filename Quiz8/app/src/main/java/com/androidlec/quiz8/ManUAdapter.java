package com.androidlec.quiz8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ManUAdapter extends BaseAdapter {

    // Field

    private Context mContext = null;
    private int layout = 0;
    private ArrayList<ManU> data = null;
    private LayoutInflater inflater = null;

    // constructor


    public ManUAdapter(Context mContext, int layout, ArrayList<ManU> data) {
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getBack();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(this.layout, parent ,false);
        }

        TextView tv_back = convertView.findViewById(R.id.tv_back);
        ImageView iv_icon = convertView.findViewById(R.id.iv_players);
        TextView tv_comment = convertView.findViewById(R.id.tv_comment);

        ImageView iv_icon1 = convertView.findViewById(R.id.iv_nationi);

        tv_back.setText(data.get(position).getBack()+ " ");
        iv_icon.setImageResource(data.get(position).getIcon());
        tv_comment.setText(data.get(position).getComment());

        iv_icon1.setImageResource(data.get(position).getIcon1());



        return convertView;
    }




}
