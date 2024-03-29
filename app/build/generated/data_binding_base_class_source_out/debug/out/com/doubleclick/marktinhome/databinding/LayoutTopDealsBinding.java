// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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

public final class LayoutTopDealsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView idGVTopDeals;

  @NonNull
  public final TextView viewmore;

  private LayoutTopDealsBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView idGVTopDeals, @NonNull TextView viewmore) {
    this.rootView = rootView;
    this.idGVTopDeals = idGVTopDeals;
    this.viewmore = viewmore;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutTopDealsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutTopDealsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_top_deals, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutTopDealsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.idGVTopDeals;
      RecyclerView idGVTopDeals = ViewBindings.findChildViewById(rootView, id);
      if (idGVTopDeals == null) {
        break missingId;
      }

      id = R.id.viewmore;
      TextView viewmore = ViewBindings.findChildViewById(rootView, id);
      if (viewmore == null) {
        break missingId;
      }

      return new LayoutTopDealsBinding((ConstraintLayout) rootView, idGVTopDeals, viewmore);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
