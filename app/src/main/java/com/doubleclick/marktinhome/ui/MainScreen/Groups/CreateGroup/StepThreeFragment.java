package com.doubleclick.marktinhome.ui.MainScreen.Groups.CreateGroup;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.ui.MainScreen.Groups.GroupsActivity;
import com.google.android.material.progressindicator.CircularProgressIndicator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StepThreeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StepThreeFragment extends Fragment {


    private CircularProgressIndicator progressIndicator;
    private ImageView selectCover;
    private TextView skip;
    private Button next;

    public StepThreeFragment() {
        // Required empty public constructor
    }


    public static StepThreeFragment newInstance(String param1, String param2) {
        StepThreeFragment fragment = new StepThreeFragment();
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
        View view = inflater.inflate(R.layout.fragment_step_three, container, false);
        progressIndicator = view.findViewById(R.id.progressBar);
        selectCover = view.findViewById(R.id.selectCover);
        skip = view.findViewById(R.id.skip);
        next = view.findViewById(R.id.next);

        // todo upload data
        next.setOnClickListener(v -> {

            startActivity(new Intent(getContext(), GroupsActivity.class));
        });
        // todo  skip
        skip.setOnClickListener(v -> {

            startActivity(new Intent(getContext(), GroupsActivity.class));
        });

        return view;
    }
}