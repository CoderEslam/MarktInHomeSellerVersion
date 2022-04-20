package com.doubleclick.ViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.doubleclick.AdvInterface;
import com.doubleclick.marktinhome.Model.Advertisement;
import com.doubleclick.marktinhome.Repository.AdvertisementRepository;

import java.util.ArrayList;

/**
 * Created By Eslam Ghazy on 3/8/2022
 */
public class AdvertisementViewModel extends ViewModel implements AdvInterface {

    MutableLiveData<ArrayList<Advertisement>> mutableLiveData = new MutableLiveData<>();

    AdvertisementRepository repository = new AdvertisementRepository(this);

    public AdvertisementViewModel() {
        repository.getAdvertisement();
    }

    public LiveData<ArrayList<Advertisement>> getAllAdv() {
        return mutableLiveData;
    }

    @Override
    public void AllAdvertisement(@Nullable ArrayList<Advertisement> advertisement) {
        mutableLiveData.setValue(advertisement);
    }

    @Override
    public void OnEditAdvertisement(@NonNull Advertisement advertisement) {

    }

    @Override
    public void OnDeleteAdvertisement(@NonNull Advertisement advertisement) {

    }
}
