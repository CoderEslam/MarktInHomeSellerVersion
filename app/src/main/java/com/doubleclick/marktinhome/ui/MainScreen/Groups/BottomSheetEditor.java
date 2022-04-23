package com.doubleclick.marktinhome.ui.MainScreen.Groups;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.doubleclick.marktinhome.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Objects;

/**
 * Created By Eslam Ghazy on 4/23/2022
 */
public class BottomSheetEditor extends BottomSheetDialogFragment {

    private EditText et_user_input_bottom_sheet_fragment;
    private TextView btn_save_bottom_sheet, btn_cancel_bottom_sheet;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_editor, container, false);
        Objects.requireNonNull(Objects.requireNonNull(getDialog()).getWindow()).setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        et_user_input_bottom_sheet_fragment = view.findViewById(R.id.et_user_input_bottom_sheet_fragment);
        btn_save_bottom_sheet = view.findViewById(R.id.btn_save_bottom_sheet);
        btn_cancel_bottom_sheet = view.findViewById(R.id.btn_cancel_bottom_sheet);
        btn_save_bottom_sheet.setOnClickListener(v -> {
            updateUsernameAndBio();
        });

        btn_cancel_bottom_sheet.setOnClickListener(v -> {
            dismiss();
        });

        return view;
    }

    private void updateUsernameAndBio() {



    }
}
