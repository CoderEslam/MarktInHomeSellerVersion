// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.divyanshu.colorseekbar.ColorSeekBar;
import com.doubleclick.marktinhome.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AddToggalBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ColorSeekBar colorSeekBar;

  @NonNull
  public final EditText descriptionOfButton;

  @NonNull
  public final TextInputEditText editname;

  @NonNull
  public final TextInputLayout textInputLayout3;

  private AddToggalBinding(@NonNull ConstraintLayout rootView, @NonNull ColorSeekBar colorSeekBar,
      @NonNull EditText descriptionOfButton, @NonNull TextInputEditText editname,
      @NonNull TextInputLayout textInputLayout3) {
    this.rootView = rootView;
    this.colorSeekBar = colorSeekBar;
    this.descriptionOfButton = descriptionOfButton;
    this.editname = editname;
    this.textInputLayout3 = textInputLayout3;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AddToggalBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AddToggalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.add_toggal, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AddToggalBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.color_seek_bar;
      ColorSeekBar colorSeekBar = ViewBindings.findChildViewById(rootView, id);
      if (colorSeekBar == null) {
        break missingId;
      }

      id = R.id.descriptionOfButton;
      EditText descriptionOfButton = ViewBindings.findChildViewById(rootView, id);
      if (descriptionOfButton == null) {
        break missingId;
      }

      id = R.id.editname;
      TextInputEditText editname = ViewBindings.findChildViewById(rootView, id);
      if (editname == null) {
        break missingId;
      }

      id = R.id.textInputLayout3;
      TextInputLayout textInputLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (textInputLayout3 == null) {
        break missingId;
      }

      return new AddToggalBinding((ConstraintLayout) rootView, colorSeekBar, descriptionOfButton,
          editname, textInputLayout3);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}