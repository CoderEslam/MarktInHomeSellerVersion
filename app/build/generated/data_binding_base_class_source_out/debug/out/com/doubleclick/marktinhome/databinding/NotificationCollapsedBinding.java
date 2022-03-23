// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.doubleclick.marktinhome.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class NotificationCollapsedBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView textViewCollapsed1;

  @NonNull
  public final TextView textViewCollapsed2;

  private NotificationCollapsedBinding(@NonNull LinearLayout rootView,
      @NonNull TextView textViewCollapsed1, @NonNull TextView textViewCollapsed2) {
    this.rootView = rootView;
    this.textViewCollapsed1 = textViewCollapsed1;
    this.textViewCollapsed2 = textViewCollapsed2;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static NotificationCollapsedBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static NotificationCollapsedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.notification_collapsed, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static NotificationCollapsedBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.text_view_collapsed_1;
      TextView textViewCollapsed1 = ViewBindings.findChildViewById(rootView, id);
      if (textViewCollapsed1 == null) {
        break missingId;
      }

      id = R.id.text_view_collapsed_2;
      TextView textViewCollapsed2 = ViewBindings.findChildViewById(rootView, id);
      if (textViewCollapsed2 == null) {
        break missingId;
      }

      return new NotificationCollapsedBinding((LinearLayout) rootView, textViewCollapsed1,
          textViewCollapsed2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}