package com.doubleclick.marktinhome.ui.MainScreen.Frgments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.doubleclick.marktinhome.Model.Product;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.System;
import java.util.HashMap;

public class ViewMoreFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ViewMoreFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private ViewMoreFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ViewMoreFragmentArgs fromBundle(@NonNull Bundle bundle) {
    ViewMoreFragmentArgs __result = new ViewMoreFragmentArgs();
    bundle.setClassLoader(ViewMoreFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("productArray")) {
      Product[] productArray;
      Parcelable[] __array = bundle.getParcelableArray("productArray");
      if (__array != null) {
        productArray = new Product[__array.length];
        System.arraycopy(__array, 0, productArray, 0, __array.length);
      } else {
        productArray = null;
      }
      if (productArray == null) {
        throw new IllegalArgumentException("Argument \"productArray\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("productArray", productArray);
    } else {
      throw new IllegalArgumentException("Required argument \"productArray\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ViewMoreFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    ViewMoreFragmentArgs __result = new ViewMoreFragmentArgs();
    if (savedStateHandle.contains("productArray")) {
      Product[] productArray;
      productArray = savedStateHandle.get("productArray");
      if (productArray == null) {
        throw new IllegalArgumentException("Argument \"productArray\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("productArray", productArray);
    } else {
      throw new IllegalArgumentException("Required argument \"productArray\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Product[] getProductArray() {
    return (Product[]) arguments.get("productArray");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("productArray")) {
      Product[] productArray = (Product[]) arguments.get("productArray");
      __result.putParcelableArray("productArray", productArray);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("productArray")) {
      Product[] productArray = (Product[]) arguments.get("productArray");
      __result.set("productArray", productArray);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    ViewMoreFragmentArgs that = (ViewMoreFragmentArgs) object;
    if (arguments.containsKey("productArray") != that.arguments.containsKey("productArray")) {
      return false;
    }
    if (getProductArray() != null ? !getProductArray().equals(that.getProductArray()) : that.getProductArray() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + java.util.Arrays.hashCode(getProductArray());
    return result;
  }

  @Override
  public String toString() {
    return "ViewMoreFragmentArgs{"
        + "productArray=" + getProductArray()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull ViewMoreFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull Product[] productArray) {
      if (productArray == null) {
        throw new IllegalArgumentException("Argument \"productArray\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("productArray", productArray);
    }

    @NonNull
    public ViewMoreFragmentArgs build() {
      ViewMoreFragmentArgs result = new ViewMoreFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setProductArray(@NonNull Product[] productArray) {
      if (productArray == null) {
        throw new IllegalArgumentException("Argument \"productArray\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("productArray", productArray);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public Product[] getProductArray() {
      return (Product[]) arguments.get("productArray");
    }
  }
}
