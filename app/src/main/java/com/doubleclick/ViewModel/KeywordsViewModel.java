package com.doubleclick.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add.KeywordBottomSheet;

import java.util.ArrayList;

/**
 * Created By Eslam Ghazy on 4/29/2022
 */
public class KeywordsViewModel extends ViewModel implements KeywordBottomSheet.Keywords {

    MutableLiveData<ArrayList<String>> mutableLiveData = new MutableLiveData<>();
    KeywordBottomSheet keywordBottomSheet = new KeywordBottomSheet(this);

    public KeywordsViewModel() {
        keywordBottomSheet.Store();
    }

    public LiveData<ArrayList<String>> getKeys() {
        return mutableLiveData;
    }

    @Override
    public void ItemsKeyword(ArrayList<String> items) {
        mutableLiveData.setValue(items);
    }
}
