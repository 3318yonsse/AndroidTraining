package com.android.bmi.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.android.bmi.FatRate;
import com.android.bmi.FatRateAdapter;
import com.android.bmi.R;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private ArrayList<FatRate> data = null;
    private FatRateAdapter adapter = null;
    private ListView listView = null;

    int i = 0;

    ImageView color = null;
    TextView state = null;
    TextView rate = null;
    ImageView manbtn;
    ImageView womanbtn;

    TextView result = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        data = new ArrayList<FatRate>();
        data.add(new FatRate(R.drawable.r, "낮음", "           < 8 %"));
        data.add(new FatRate(R.drawable.e, "정상", "    8 ~ 20 %"));
        data.add(new FatRate(R.drawable.w, "높음", "  20 ~ 25 %"));
        data.add(new FatRate(R.drawable.q, "매우 높음", "> 25 %"));

        EditText mAge = root.findViewById(R.id.member_Age);
        TextView result = root.findViewById(R.id.fat_result);

//        result.setOnClickListener(rClickListener);

        manbtn = root.findViewById(R.id.Manbtn);
        womanbtn = root.findViewById(R.id.Womanbtn);
        manbtn.setOnClickListener(mClickListener);
        womanbtn.setOnClickListener(mClickListener);



        adapter = new FatRateAdapter(getContext(), R.layout.fragment_fatlist_layout, data);
        listView = root.findViewById(R.id.list_state);
        listView.setAdapter(adapter);

        result = root.findViewById(R.id.fat_result);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return root;
    }
    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.Manbtn:
                    if(i == 0){
                        manbtn.setImageResource(R.drawable.m1);

                        i++;
                    }
                    else{
                        manbtn.setImageResource(R.drawable.m2);
                        i--;
                    }
                    break;
                case R.id.Womanbtn:
                    if(i == 0){
                        womanbtn.setImageResource(R.drawable.w2);
                        i++;
                    }else {
                        womanbtn.setImageResource(R.drawable.w1);
                        i--;
                    }
                    break;
            }
        }
    };
    /* View.OnClickListener rClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };*/





//        final TextView textView = root.findViewById(R.id.text_gallery);
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
}
