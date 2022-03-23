// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.doubleclick.marktinhome.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityTrademarkBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView MyTrademark;

  @NonNull
  public final ImageView imageTrademark;

  @NonNull
  public final EditText trademark;

  @NonNull
  public final Button upload;

  private ActivityTrademarkBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView MyTrademark, @NonNull ImageView imageTrademark,
      @NonNull EditText trademark, @NonNull Button upload) {
    this.rootView = rootView;
    this.MyTrademark = MyTrademark;
    this.imageTrademark = imageTrademark;
    this.trademark = trademark;
    this.upload = upload;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTrademarkBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTrademarkBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_trademark, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTrademarkBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.MyTrademark;
      RecyclerView MyTrademark = ViewBindings.findChildViewById(rootView, id);
      if (MyTrademark == null) {
        break missingId;
      }

      id = R.id.imageTrademark;
      ImageView imageTrademark = ViewBindings.findChildViewById(rootView, id);
      if (imageTrademark == null) {
        break missingId;
      }

      id = R.id.trademark;
      EditText trademark = ViewBindings.findChildViewById(rootView, id);
      if (trademark == null) {
        break missingId;
      }

      id = R.id.upload;
      Button upload = ViewBindings.findChildViewById(rootView, id);
      if (upload == null) {
        break missingId;
      }

      return new ActivityTrademarkBinding((ConstraintLayout) rootView, MyTrademark, imageTrademark,
          trademark, upload);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}