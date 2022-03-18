package com.doubleclick.marktinhome.Repository;

import static com.doubleclick.marktinhome.BaseApplication.isNetworkConnected;
import static com.doubleclick.marktinhome.Model.Constantes.ADVERTISEMENT;

import android.util.Log;

import androidx.annotation.NonNull;

import com.doubleclick.Adv;
import com.doubleclick.marktinhome.Model.Advertisement;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

/**
 * Created By Eslam Ghazy on 3/8/2022
 */
public class AdvertisementRepository extends BaseRepository {

    private ArrayList<Advertisement> advertisements = new ArrayList<>();
    private Adv adv;

    public AdvertisementRepository(Adv adv) {
        this.adv = adv;
    }

    public void getAdvertisement() {
        reference.child(ADVERTISEMENT).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                try {
                    if (isNetworkConnected() && task.getResult().exists()) {
                        for (DataSnapshot snapshot : task.getResult().getChildren()) {
                            Advertisement advertisement = snapshot.getValue(Advertisement.class);
                            advertisements.add(advertisement);
                        }
                        adv.AllAdvertisement(advertisements);
                    }
                } catch (Exception e) {
                    ShowToast("No Internet Connection");
                    Log.e("Exception", e.getMessage());
                }
            }
        });
    }

}
