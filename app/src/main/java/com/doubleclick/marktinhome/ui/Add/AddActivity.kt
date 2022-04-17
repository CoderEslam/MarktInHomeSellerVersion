package com.doubleclick.marktinhome.ui.Add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.doubleclick.marktinhome.R
import com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add.RichFragment
import com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add.UploadFragment

class AddActivity : AppCompatActivity(), RichFragment.ShareHTML {


    var uploadFragment = UploadFragment();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //this activity to cary fragments
        setContentView(R.layout.activity_add)
    }

    override fun input(html: String) {
        uploadFragment.ShowHTML(html);
    }
}