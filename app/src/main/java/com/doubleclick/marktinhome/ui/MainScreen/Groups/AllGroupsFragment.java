package com.doubleclick.marktinhome.ui.MainScreen.Groups;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doubleclick.ViewModel.GroupViewModel;
import com.doubleclick.marktinhome.Adapters.ItemGroupsAdapter;
import com.doubleclick.marktinhome.Model.Group;
import com.doubleclick.marktinhome.R;
import com.todkars.shimmer.ShimmerRecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllGroupsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllGroupsFragment extends Fragment {

    private ShimmerRecyclerView allGroupsRecycler;
    private GroupViewModel groupViewModel;

    public AllGroupsFragment() {
        // Required empty public constructor
    }


    public static AllGroupsFragment newInstance(String param1, String param2) {
        AllGroupsFragment fragment = new AllGroupsFragment();
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
        View view = inflater.inflate(R.layout.fragment_all_groups, container, false);
        allGroupsRecycler = view.findViewById(R.id.AllGroupsRecycler);
        allGroupsRecycler.showShimmer();     // to start showing shimmer
        groupViewModel = new ViewModelProvider(this).get(GroupViewModel.class);
        groupViewModel.AllGroups().observe(getViewLifecycleOwner(), new Observer<ArrayList<Group>>() {
            @Override
            public void onChanged(ArrayList<Group> groups) {
                if (groups.size()!=0){
                    allGroupsRecycler.setAdapter(new ItemGroupsAdapter(groups));
                    allGroupsRecycler.hideShimmer();
                }else {

                }
            }
        });


        return view;
    }
}