package com.android.bmi.ui.slideshow;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.android.bmi.CalorieActivity;
import com.android.bmi.R;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    int mSelect = 0;
    TextView Height;
    int normal = 21;
    Button button;
    TextView tvheight;
    TextView tvweight;
    TextView tvweight1;
    double weight;
    double result;
    LinearLayout input;
    LinearLayout print;
    LinearLayout resultlin;
    LinearLayout activity1;
    Intent intent = null;
    ImageView imagegood;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);


        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        // XML 연결 //
        input = root.findViewById(R.id.inputh);
        print = root.findViewById(R.id.printh);
        resultlin = root.findViewById(R.id.resultlin);
        activity1 = root.findViewById(R.id.activitys);

        tvweight = root.findViewById(R.id.tv_weight);
        tvheight = root.findViewById(R.id.tv_height);
        tvweight1 = root.findViewById(R.id.tv_weighti);
        button = root.findViewById(R.id.hb01);
        Log.v("MainActivity TAG", "구간 2----------------");
        // XML 연결 //



        // intent //
//        intent = intent
//        int height = intent.getIntExtra("height" , 0);
//        tvheight.setText(height);
        // intent 받기 전 예비 //

        //표준체중 구하기 버튼
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                double heightextra = 1.75;
                Log.v("TAG","weight-----------------------");
                if(tvheight.getText().length()==0){
                    Toast.makeText(getActivity(),"정보를 입력헤주세요.",Toast.LENGTH_SHORT).show();
                }else {

                    if(input.getVisibility() == v.VISIBLE) {
                        input.setVisibility(v.INVISIBLE);
                        print.setVisibility(v.VISIBLE);


                    }
                    double heightValue = Double.parseDouble(String.valueOf(tvheight.getText()));
                    Log.v("MainActivity TAG", "구간 3----------------");
                    weight = (heightValue * heightValue)*0.0001*normal;
                    tvweight.setText((String.format("%.1f",weight))+ " Kg");
                    Log.v("MainActivity TAG", "구간 4----------------");

                }


            }
        });

        // 필요 칼로리 버튼
        root.findViewById(R.id.callButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("TAG","activity-----------------------");
                new AlertDialog.Builder(getContext())
                        .setTitle("당신의 활동 정도는?")
                        .setCancelable(false)
                        .setIcon(R.drawable.checkimage)
                        .setSingleChoiceItems(R.array.act, mSelect,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mSelect = which;
                                    }
                                }
                        )
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Log.v("aaa", Integer.toString(which));
                                String[] act = getResources().getStringArray(R.array.act);
                                TextView text = root.findViewById(R.id.result1);

                                switch (which){
                                    case -1:
                                        Log.v("aaa","1");
                                        result = 30 * weight;
                                        Log.v("aaa","2");
                                        if(print.getVisibility() == v.VISIBLE) {
                                            print.setVisibility(v.INVISIBLE);
                                            resultlin.setVisibility(v.VISIBLE);
                                            }
                                        if(activity1.getVisibility() == v.VISIBLE) {
                                            activity1.setVisibility(v.INVISIBLE);
                                        }
                                        break;
                                    case 0:
                                        Log.v("aaa","11112");
                                        result = 35 * weight;
                                        Log.v("aaa","dfffff2");
                                        if(print.getVisibility() == v.VISIBLE) {
                                            print.setVisibility(v.INVISIBLE);
                                            resultlin.setVisibility(v.VISIBLE);
                                        }
                                        if(activity1.getVisibility() == v.VISIBLE) {
                                            activity1.setVisibility(v.INVISIBLE);
                                        }
                                        break;
                                    case 1:
                                        result = 40 * weight;
                                        if(print.getVisibility() == v.VISIBLE) {
                                            print.setVisibility(v.INVISIBLE);
                                            resultlin.setVisibility(v.VISIBLE);
                                        }
                                        if(activity1.getVisibility() == v.VISIBLE) {
                                            activity1.setVisibility(v.INVISIBLE);
                                        }
                                        break;
                                }
                                Log.v("aaa","233");
                                String re = Double.toString(result).substring(0,7);
                                text.setText(re+ " Kcal");
                                Log.v("aaa","3444");

                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
            }
        });

        root.findViewById(R.id.infoButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("TAG","button-----------------------");
                if(activity1.getVisibility() == v.INVISIBLE) {
                    activity1.setVisibility(v.VISIBLE);
                } else if(activity1.getVisibility() == v.VISIBLE) {
                    activity1.setVisibility(v.INVISIBLE);
                }

            }
        });

        root.findViewById(R.id.retry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resultlin.getVisibility() == v.VISIBLE) {
                    resultlin.setVisibility(v.INVISIBLE);
                    input.setVisibility(v.VISIBLE);
                    tvheight.setText(null);
                    tvweight1.setText(null);


                }
            }
        });






//        final TextView textView = root.findViewById(R.id.text_slideshow);
//        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });


        return root;
    }
}