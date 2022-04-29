package com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.doubleclick.marktinhome.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

/**
 * Created By Eslam Ghazy on 4/29/2022
 */
public class KeywordBottomSheet extends BottomSheetDialogFragment  {


    private EditText keyword;
    private ImageView send;
    ArrayList<String> texts = new ArrayList<>();
    private Keywords keywords;

    public KeywordBottomSheet(Keywords keywords) {
        this.keywords = keywords;
    }

    public KeywordBottomSheet() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_dialog_keyword, container, false);
        keyword = view.findViewById(R.id.keyword);
        send = view.findViewById(R.id.send);

        send.setOnClickListener(v -> {
            if (!keyword.getText().toString().equals("")) {
                texts.add(keyword.getText().toString());
                keyword.setText("");
                keywords.ItemsKeyword(texts);
            }
        });
        return view;
    }

    public void Store() {
        keywords.ItemsKeyword(texts);
    }

    public interface Keywords {
        void ItemsKeyword(ArrayList<String> items);
    }
}
