// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.doubleclick.marktinhome.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentCartBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView Continue;

  @NonNull
  public final TextView MyOrder;

  @NonNull
  public final LottieAnimationView animationView;

  @NonNull
  public final RecyclerView cartRecycler;

  @NonNull
  public final LinearLayout linearLayout3;

  @NonNull
  public final TextView totalPrice;

  private FragmentCartBinding(@NonNull ConstraintLayout rootView, @NonNull TextView Continue,
      @NonNull TextView MyOrder, @NonNull LottieAnimationView animationView,
      @NonNull RecyclerView cartRecycler, @NonNull LinearLayout linearLayout3,
      @NonNull TextView totalPrice) {
    this.rootView = rootView;
    this.Continue = Continue;
    this.MyOrder = MyOrder;
    this.animationView = animationView;
    this.cartRecycler = cartRecycler;
    this.linearLayout3 = linearLayout3;
    this.totalPrice = totalPrice;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentCartBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentCartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_cart, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentCartBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Continue;
      TextView Continue = ViewBindings.findChildViewById(rootView, id);
      if (Continue == null) {
        break missingId;
      }

      id = R.id.MyOrder;
      TextView MyOrder = ViewBindings.findChildViewById(rootView, id);
      if (MyOrder == null) {
        break missingId;
      }

      id = R.id.animationView;
      LottieAnimationView animationView = ViewBindings.findChildViewById(rootView, id);
      if (animationView == null) {
        break missingId;
      }

      id = R.id.cartRecycler;
      RecyclerView cartRecycler = ViewBindings.findChildViewById(rootView, id);
      if (cartRecycler == null) {
        break missingId;
      }

      id = R.id.linearLayout3;
      LinearLayout linearLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout3 == null) {
        break missingId;
      }

      id = R.id.totalPrice;
      TextView totalPrice = ViewBindings.findChildViewById(rootView, id);
      if (totalPrice == null) {
        break missingId;
      }

      return new FragmentCartBinding((ConstraintLayout) rootView, Continue, MyOrder, animationView,
          cartRecycler, linearLayout3, totalPrice);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
