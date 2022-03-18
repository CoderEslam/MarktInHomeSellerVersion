package com.doubleclick.marktinhome.ui.ProductActivity;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.doubleclick.marktinhome.Model.Product;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class productFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private productFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private productFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static productFragmentArgs fromBundle(@NonNull Bundle bundle) {
    productFragmentArgs __result = new productFragmentArgs();
    bundle.setClassLoader(productFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("Product")) {
      Product Product;
      if (Parcelable.class.isAssignableFrom(Product.class) || Serializable.class.isAssignableFrom(Product.class)) {
        Product = (Product) bundle.get("Product");
      } else {
        throw new UnsupportedOperationException(Product.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      __result.arguments.put("Product", Product);
    } else {
      throw new IllegalArgumentException("Required argument \"Product\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static productFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    productFragmentArgs __result = new productFragmentArgs();
    if (savedStateHandle.contains("Product")) {
      Product Product;
      Product = savedStateHandle.get("Product");
      __result.arguments.put("Product", Product);
    } else {
      throw new IllegalArgumentException("Required argument \"Product\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public Product getProduct() {
    return (Product) arguments.get("Product");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("Product")) {
      Product Product = (Product) arguments.get("Product");
      if (Parcelable.class.isAssignableFrom(Product.class) || Product == null) {
        __result.putParcelable("Product", Parcelable.class.cast(Product));
      } else if (Serializable.class.isAssignableFrom(Product.class)) {
        __result.putSerializable("Product", Serializable.class.cast(Product));
      } else {
        throw new UnsupportedOperationException(Product.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("Product")) {
      Product Product = (Product) arguments.get("Product");
      if (Parcelable.class.isAssignableFrom(Product.class) || Product == null) {
        __result.set("Product", Parcelable.class.cast(Product));
      } else if (Serializable.class.isAssignableFrom(Product.class)) {
        __result.set("Product", Serializable.class.cast(Product));
      } else {
        throw new UnsupportedOperationException(Product.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
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
    productFragmentArgs that = (productFragmentArgs) object;
    if (arguments.containsKey("Product") != that.arguments.containsKey("Product")) {
      return false;
    }
    if (getProduct() != null ? !getProduct().equals(that.getProduct()) : that.getProduct() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getProduct() != null ? getProduct().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "productFragmentArgs{"
        + "Product=" + getProduct()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull productFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@Nullable Product Product) {
      this.arguments.put("Product", Product);
    }

    @NonNull
    public productFragmentArgs build() {
      productFragmentArgs result = new productFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setProduct(@Nullable Product Product) {
      this.arguments.put("Product", Product);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @Nullable
    public Product getProduct() {
      return (Product) arguments.get("Product");
    }
  }
}
