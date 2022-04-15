package com.doubleclick.RichEditor.sample.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.doubleclick.marktinhome.R;


public class EditTableFragment extends Fragment {
    private EditText etRows;
    private EditText etCols;
    private Button btn_ok;
    private ImageView iv_back;
    private OnTableListener mOnTableListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_edit_table, container, false);
        etRows = rootView.findViewById(R.id.et_rows);
        etCols = rootView.findViewById(R.id.et_cols);
        btn_ok = rootView.findViewById(R.id.btn_ok);
        iv_back = rootView.findViewById(R.id.iv_back);

        btn_ok.setOnClickListener(v -> {
            onClickBack();
        });

        iv_back.setOnClickListener(v -> {
            onClickOK();
        });
        return rootView;
    }

    void onClickBack() {
        assert getFragmentManager() != null;
        getFragmentManager().beginTransaction().remove(this).commit();
    }

    void onClickOK() {
        if (mOnTableListener != null) {
            mOnTableListener.onTableOK(Integer.parseInt(etRows.getText().toString().trim()), Integer.parseInt(etCols.getText().toString().trim()));
            onClickBack();
        }
    }

    public void setOnTableListener(OnTableListener mOnTableListener) {
        this.mOnTableListener = mOnTableListener;
    }

    public interface OnTableListener {
        void onTableOK(int rows, int cols);
    }
}
