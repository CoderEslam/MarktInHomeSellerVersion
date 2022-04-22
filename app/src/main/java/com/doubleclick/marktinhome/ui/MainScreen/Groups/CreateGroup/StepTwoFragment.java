package com.doubleclick.marktinhome.ui.MainScreen.Groups.CreateGroup;

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
import com.google.android.material.progressindicator.CircularProgressIndicator;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StepTwoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StepTwoFragment extends Fragment {

    private CircularProgressIndicator progressIndicator;
    private CircleImageView selectImage;
    private Button next;
    private TextView skip;

    public StepTwoFragment() {
        // Required empty public constructor
    }


    public static StepTwoFragment newInstance(String param1, String param2) {
        StepTwoFragment fragment = new StepTwoFragment();
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
        View view = inflater.inflate(R.layout.fragment_step_two, container, false);
        progressIndicator = view.findViewById(R.id.progressBar);
        selectImage = view.findViewById(R.id.selectImage);
        next = view.findViewById(R.id.next);
        skip = view.findViewById(R.id.skip);

        // todo upload data
        next.setOnClickListener(v -> {
            Navigation.findNavController(getActivity(), R.id.main_fragment_group).navigate(StepTwoFragmentDirections.actionStepTwoFragmentToStepThreeFragment());
        });
        // todo skip
        skip.setOnClickListener(v -> {
            Navigation.findNavController(getActivity(), R.id.main_fragment_group).navigate(StepTwoFragmentDirections.actionStepTwoFragmentToStepThreeFragment());
        });


        return view;
    }
}