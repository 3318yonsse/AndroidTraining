package com.androidlec.dbcrud01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {


    // Field

    Context mContext = null;
    int layout = 0;
    ArrayList<Student> data = null;
    LayoutInflater inflater = null;


    // Consturctor


    public StudentAdapter(Context mContext, int layout, ArrayList<Student> data) {                  // Generate 생성 할때 Inflater 빼서 하고 따로 밑에 적어줌.
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
        return data.get(position).getCode();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(this.layout, parent, false);
        }

        TextView tv_code = convertView.findViewById(R.id.tv_code);
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_dept = convertView.findViewById(R.id.tv_dept);
        TextView tv_phone = convertView.findViewById(R.id.tv_phone);


        tv_code.setText("학번 : " + data.get(position).getCode());
        tv_name.setText("성명 : " + data.get(position).getName());
        tv_dept.setText("전공 : " + data.get(position).getDept());
        tv_phone.setText("번화번호 : " + data.get(position).getPhone());


        if((position % 2) == 1){
            convertView.setBackgroundColor(0x50000000);
        }else{
            convertView.setBackgroundColor(0x50dddddd);
        }

        return convertView;
    }


}
