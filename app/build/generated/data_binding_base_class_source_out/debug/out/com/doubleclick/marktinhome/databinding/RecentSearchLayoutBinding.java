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

public final class RecentSearchLayoutBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView recentSearch;

  @NonNull
  public final TextView viewmore;

  private RecentSearchLayoutBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView recentSearch, @NonNull TextView viewmore) {
    this.rootView = rootView;
    this.recentSearch = recentSearch;
    this.viewmore = viewmore;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static RecentSearchLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RecentSearchLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.recent_search_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RecentSearchLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.recentSearch;
      RecyclerView recentSearch = ViewBindings.findChildViewById(rootView, id);
      if (recentSearch == null) {
        break missingId;
      }

      id = R.id.viewmore;
      TextView viewmore = ViewBindings.findChildViewById(rootView, id);
      if (viewmore == null) {
        break missingId;
      }

      return new RecentSearchLayoutBinding((ConstraintLayout) rootView, recentSearch, viewmore);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}