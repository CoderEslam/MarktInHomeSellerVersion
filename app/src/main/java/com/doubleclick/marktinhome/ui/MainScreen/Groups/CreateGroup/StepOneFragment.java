package com.doubleclick.marktinhome.ui.MainScreen.Groups.CreateGroup;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.ui.MainScreen.MainScreenActivity;
import com.google.android.material.progressindicator.CircularProgressIndicator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StepOneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StepOneFragment extends Fragment {


    private EditText name, username, details, link;
    private Button next;
    private CircularProgressIndicator progressIndicator;
    private ImageView back;


    public StepOneFragment() {
        // Required empty public constructor
    }


    public static StepOneFragment newInstance(String param1, String param2) {
        StepOneFragment fragment = new StepOneFragment();
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
        View view = inflater.inflate(R.layout.fragment_step_one, container, false);
        name = view.findViewById(R.id.name);
        username = view.findViewById(R.id.username);
        details = view.findViewById(R.id.details);
        link = view.findViewById(R.id.link);
        next = view.findViewById(R.id.next);
        progressIndicator = view.findViewById(R.id.progressBar);
        back = view.findViewById(R.id.back);
        back.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), MainScreenActivity.class));
        });

        next.setOnClickListener(v -> {
            Navigation.findNavController(getActivity(),R.id.main_fragment_group).navigate(StepOneFragmentDirections.actionStepOneFragmentToStepTwoFragment());
        });


        return view;
    }
}