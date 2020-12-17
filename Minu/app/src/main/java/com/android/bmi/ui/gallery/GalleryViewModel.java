package com.android.bmi.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() { // BMI
        mText = new MutableLiveData<>();
        mText.setValue("체지방");
    }

    public LiveData<String> getText() {
        return mText;
    }
}