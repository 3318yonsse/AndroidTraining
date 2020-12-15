package com.androidlec.customadapterview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WeatherAdapter extends BaseAdapter {

    // field

    // mainactivity
    private Context mContext = null;
    private int layout = 0;
    // 요일을 한번에 묶어 가져옴
    private ArrayList<Weather> data = null;
    // adapter역할을 하려면 인플레이터가 필요함
    private LayoutInflater inflater = null;


    // constructor

    public WeatherAdapter(Context mContext, int layout, ArrayList<Weather> data) {
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        // 선언할때는 안써준다!
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        // array의 사이
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getDay();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // data를 불러오는데 불러올게 없으면 끝내라?
        if(convertView == null){
            convertView = inflater.inflate(this.layout, parent, false);
        }
        // 여기서 listview를 만들어줌
        TextView tv_day = convertView.findViewById(R.id.tv_day);
        ImageView iv_icon = convertView.findViewById(R.id.iv_weather);
        TextView tv_commnet = convertView.findViewById(R.id.tv_comment);

        tv_day.setText(data.get(position).getDay() + " ");
        iv_icon.setImageResource(data.get(position).getIcon());
        tv_commnet.setText(data.get(position).getComment());

        if(position % 2 == 1){
            convertView.setBackgroundColor(0x5000ff00);
        }else{
            convertView.setBackgroundColor(0x2000ff00);
        }

        return convertView;
    }

}
