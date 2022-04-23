package com.doubleclick.marktinhome.ui.MainScreen.Groups;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.doubleclick.marktinhome.Adapters.ViewPagerGroupAdapter;
import com.doubleclick.marktinhome.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GroupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GroupFragment extends Fragment {

    private FloatingActionButton addGroup;
    private ViewPager pager;
    private TabLayout tab_layout;

    public GroupFragment() {
        // Required empty public constructor
    }

    public static GroupFragment newInstance(String param1, String param2) {
        GroupFragment fragment = new GroupFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_group, container, false);
        addGroup = view.findViewById(R.id.addGroup);
        tab_layout = view.findViewById(R.id.tab_layout);
        pager = view.findViewById(R.id.viewpager);
        tab_layout.setupWithViewPager(pager);
        pager.setAdapter(new ViewPagerGroupAdapter(requireActivity().getSupportFragmentManager()));
        addGroup.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), CreateGroupActivity.class));
        });

        return view;
    }
}