// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.doubleclick.marktinhome.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentUploadBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final FrameLayout RichTable;

  @NonNull
  public final Button Upload;

  @NonNull
  public final LinearLayout addToggleButton;

  @NonNull
  public final ImageView addView;

  @NonNull
  public final EditText description;

  @NonNull
  public final HorizontalScrollView horizontalScrollView;

  @NonNull
  public final EditText keywords;

  @NonNull
  public final RecyclerView productImages;

  @NonNull
  public final EditText productLastPrice;

  @NonNull
  public final EditText productName;

  @NonNull
  public final EditText productPrice;

  @NonNull
  public final RatingBar ratingSeller;

  @NonNull
  public final Button selectImages;

  @NonNull
  public final AppCompatSpinner trademark;

  private FragmentUploadBinding(@NonNull ConstraintLayout rootView, @NonNull FrameLayout RichTable,
      @NonNull Button Upload, @NonNull LinearLayout addToggleButton, @NonNull ImageView addView,
      @NonNull EditText description, @NonNull HorizontalScrollView horizontalScrollView,
      @NonNull EditText keywords, @NonNull RecyclerView productImages,
      @NonNull EditText productLastPrice, @NonNull EditText productName,
      @NonNull EditText productPrice, @NonNull RatingBar ratingSeller, @NonNull Button selectImages,
      @NonNull AppCompatSpinner trademark) {
    this.rootView = rootView;
    this.RichTable = RichTable;
    this.Upload = Upload;
    this.addToggleButton = addToggleButton;
    this.addView = addView;
    this.description = description;
    this.horizontalScrollView = horizontalScrollView;
    this.keywords = keywords;
    this.productImages = productImages;
    this.productLastPrice = productLastPrice;
    this.productName = productName;
    this.productPrice = productPrice;
    this.ratingSeller = ratingSeller;
    this.selectImages = selectImages;
    this.trademark = trademark;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentUploadBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentUploadBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_upload, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentUploadBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.RichTable;
      FrameLayout RichTable = ViewBindings.findChildViewById(rootView, id);
      if (RichTable == null) {
        break missingId;
      }

      id = R.id.Upload;
      Button Upload = ViewBindings.findChildViewById(rootView, id);
      if (Upload == null) {
        break missingId;
      }

      id = R.id.addToggleButton;
      LinearLayout addToggleButton = ViewBindings.findChildViewById(rootView, id);
      if (addToggleButton == null) {
        break missingId;
      }

      id = R.id.addView;
      ImageView addView = ViewBindings.findChildViewById(rootView, id);
      if (addView == null) {
        break missingId;
      }

      id = R.id.description;
      EditText description = ViewBindings.findChildViewById(rootView, id);
      if (description == null) {
        break missingId;
      }

      id = R.id.horizontalScrollView;
      HorizontalScrollView horizontalScrollView = ViewBindings.findChildViewById(rootView, id);
      if (horizontalScrollView == null) {
        break missingId;
      }

      id = R.id.keywords;
      EditText keywords = ViewBindings.findChildViewById(rootView, id);
      if (keywords == null) {
        break missingId;
      }

      id = R.id.productImages;
      RecyclerView productImages = ViewBindings.findChildViewById(rootView, id);
      if (productImages == null) {
        break missingId;
      }

      id = R.id.productLastPrice;
      EditText productLastPrice = ViewBindings.findChildViewById(rootView, id);
      if (productLastPrice == null) {
        break missingId;
      }

      id = R.id.productName;
      EditText productName = ViewBindings.findChildViewById(rootView, id);
      if (productName == null) {
        break missingId;
      }

      id = R.id.productPrice;
      EditText productPrice = ViewBindings.findChildViewById(rootView, id);
      if (productPrice == null) {
        break missingId;
      }

      id = R.id.ratingSeller;
      RatingBar ratingSeller = ViewBindings.findChildViewById(rootView, id);
      if (ratingSeller == null) {
        break missingId;
      }

      id = R.id.selectImages;
      Button selectImages = ViewBindings.findChildViewById(rootView, id);
      if (selectImages == null) {
        break missingId;
      }

      id = R.id.trademark;
      AppCompatSpinner trademark = ViewBindings.findChildViewById(rootView, id);
      if (trademark == null) {
        break missingId;
      }

      return new FragmentUploadBinding((ConstraintLayout) rootView, RichTable, Upload,
          addToggleButton, addView, description, horizontalScrollView, keywords, productImages,
          productLastPrice, productName, productPrice, ratingSeller, selectImages, trademark);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
