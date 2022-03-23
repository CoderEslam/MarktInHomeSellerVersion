// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public final class NotificationExpandedBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView imageViewExpanded;

  @NonNull
  public final TextView textViewExpanded;

  private NotificationExpandedBinding(@NonNull LinearLayout rootView,
      @NonNull ImageView imageViewExpanded, @NonNull TextView textViewExpanded) {
    this.rootView = rootView;
    this.imageViewExpanded = imageViewExpanded;
    this.textViewExpanded = textViewExpanded;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static NotificationExpandedBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static NotificationExpandedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.notification_expanded, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static NotificationExpandedBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.image_view_expanded;
      ImageView imageViewExpanded = ViewBindings.findChildViewById(rootView, id);
      if (imageViewExpanded == null) {
        break missingId;
      }

      id = R.id.text_view_expanded;
      TextView textViewExpanded = ViewBindings.findChildViewById(rootView, id);
      if (textViewExpanded == null) {
        break missingId;
      }

      return new NotificationExpandedBinding((LinearLayout) rootView, imageViewExpanded,
          textViewExpanded);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}