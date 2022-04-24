package com.doubleclick.ViewHolder;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleclick.marktinhome.R;

/**
 * Created By Eslam Ghazy on 2/7/2022
 */
public class ContactViewHolder extends RecyclerView.ViewHolder {

    private TextView nameContact, numberContact;
    private String massege;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        nameContact = itemView.findViewById(R.id.nameContact);
        numberContact = itemView.findViewById(R.id.numberContact);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) itemView.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                clipboardManager.setText(massege);
                Toast.makeText(itemView.getContext(), "Copied", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void Contact(String massege) {
        this.massege =massege;
        String[] n = massege.split("\n");
        nameContact.setText(n[0]);
        numberContact.setText(n[1]);
    }
}
