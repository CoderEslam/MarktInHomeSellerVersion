// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.doubleclick.marktinhome.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TopDealLayoutBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView image;

  @NonNull
  public final TextView productName;

  @NonNull
  public final TextView productPrice;

  private TopDealLayoutBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView image,
      @NonNull TextView productName, @NonNull TextView productPrice) {
    this.rootView = rootView;
    this.image = image;
    this.productName = productName;
    this.productPrice = productPrice;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TopDealLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TopDealLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.top_deal_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TopDealLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.image;
      ImageView image = ViewBindings.findChildViewById(rootView, id);
      if (image == null) {
        break missingId;
      }

      id = R.id.productName;
      TextView productName = ViewBindings.findChildViewById(rootView, id);
      if (productName == null) {
        break missingId;
      }

      id = R.id.productPrice;
      TextView productPrice = ViewBindings.findChildViewById(rootView, id);
      if (productPrice == null) {
        break missingId;
      }

      return new TopDealLayoutBinding((ConstraintLayout) rootView, image, productName,
          productPrice);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
