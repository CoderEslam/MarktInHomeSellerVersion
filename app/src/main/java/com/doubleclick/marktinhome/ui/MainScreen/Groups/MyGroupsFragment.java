package com.doubleclick.marktinhome.ui.MainScreen.Groups;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doubleclick.marktinhome.Adapters.ItemGroupsAdapter;
import com.doubleclick.marktinhome.R;


public class MyGroupsFragment extends Fragment {

    private RecyclerView myGroupsRecycler;

    public MyGroupsFragment() {
        // Required empty public constructor
    }


    public static MyGroupsFragment newInstance(String param1, String param2) {
        MyGroupsFragment fragment = new MyGroupsFragment();
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
        View view = inflater.inflate(R.layout.fragment_my_groups, container, false);
        myGroupsRecycler = view.findViewById(R.id.MyGroupsRecycler);
        myGroupsRecycler.setAdapter(new ItemGroupsAdapter());

        return view;
    }
}