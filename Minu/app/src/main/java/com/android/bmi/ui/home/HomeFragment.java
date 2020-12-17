package com.android.bmi.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.android.bmi.BmiResult;
import com.android.bmi.CalculationActivity;
import com.android.bmi.R;
import com.android.bmi.SubActivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    Button nextBtn = null;
    Intent intent = null;
    EditText userAge;
    EditText height;
    EditText weight;
    double bmi;
    String gender;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        Log.v("Check TAG", "HomeFragment ---1---");

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        Log.v("Check TAG", "HomeFragment ---2---");
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        Log.v("Check TAG", "HomeFragment ---3---");
//        final TextView textView = root.findViewById(R.id.text_home);
        nextBtn = root.findViewById(R.id.btnNext);
        Log.v("Check TAG", "HomeFragment ---4---");

        userAge = root.findViewById(R.id.userAge);
        Log.v("Check TAG", "HomeFragment ---5---");
        height = root.findViewById(R.id.height);
        Log.v("Check TAG", "HomeFragment ---6---");
        weight = root.findViewById(R.id.weight);
        Log.v("Check TAG", "HomeFragment ---7---");

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Check TAG", "HomeFragment ---8---");
                if(userAge.getText().length()==0){
                    Toast.makeText(getActivity(),"나이를 입력해 주세요.",Toast.LENGTH_SHORT).show();
                } else if (height.getText().length()==0) {
                    Toast.makeText(getActivity(),"키를 입력해 주세요.",Toast.LENGTH_SHORT).show();
                } else if(weight.getText().length()==0){
                    Toast.makeText(getActivity(),"몸무게를 입력해 주세요.",Toast.LENGTH_SHORT).show();
                }else {
                    Log.v("Check TAG", "HomeFragment ---9---");

                    double he = Double.parseDouble(height.getText().toString());
                    double we = Double.parseDouble(weight.getText().toString());
                    Log.v("Check TAG", "HomeFragment ---he--- : " + Double.toString(he));
                    Log.v("Check TAG", "HomeFragment ---he--- : " + Double.toString(we));

                    bmi = (10000 * we) / (he * he);
                    Log.v("Check TAG", "HomeFragment ---10---");
                    intent = new Intent(getActivity(), BmiResult.class);
                    Log.v("Check TAG", "HomeFragment ---11---");

                    intent.putExtra("BMI", Double.toString(bmi));
                    Log.v("Check TAG", "HomeFragment ---11---");
                    intent.putExtra("gender", gender);
                    Log.v("Check TAG", "HomeFragment ---12---");
                    intent.putExtra("userAge", userAge.getText().toString());
                    Log.v("Check TAG", "HomeFragment ---13---");
                    intent.putExtra("height", height.getText().toString());
                    Log.v("Check TAG", "HomeFragment ---14---");
                    intent.putExtra("weight", weight.getText().toString());
                    Log.v("Check TAG", "HomeFragment ---15---");


                    startActivity(intent);

                }
            }
        });

//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        return root;
    }
}