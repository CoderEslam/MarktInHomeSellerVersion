package com.doubleclick.marktinhome.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.doubleclick.marktinhome.ui.MainScreen.Groups.AllGroupsFragment;
import com.doubleclick.marktinhome.ui.MainScreen.Groups.MyGroupsFragment;

/**
 * Created By Eslam Ghazy on 4/22/2022
 */
public class ViewPagerGroupAdapter extends FragmentPagerAdapter {

    public ViewPagerGroupAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AllGroupsFragment();
            case 1:
                return new MyGroupsFragment();
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "All Groups";
        } else if (position == 1) {
            return "My Groups";
        } else {
            return super.getPageTitle(position);
        }

    }

    @Override
    public int getCount() {
        return 2;
    }
}
