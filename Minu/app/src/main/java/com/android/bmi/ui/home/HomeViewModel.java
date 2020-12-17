package com.android.bmi.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
//        mText = new MutableLiveData<>();
//        mText.setValue("BMI 확인");
    }

    public LiveData<String> getText() {
        return mText;
    }
}