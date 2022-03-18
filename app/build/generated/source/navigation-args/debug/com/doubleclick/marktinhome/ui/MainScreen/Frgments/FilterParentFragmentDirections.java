package com.doubleclick.marktinhome.ui.MainScreen.Frgments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDirections;
import com.doubleclick.marktinhome.Model.Product;
import com.doubleclick.marktinhome.R;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class FilterParentFragmentDirections {
  private FilterParentFragmentDirections() {
  }

  @NonNull
  public static ActionFilterParentFragmentToProductFragment actionFilterParentFragmentToProductFragment(
      @Nullable Product Product) {
    return new ActionFilterParentFragmentToProductFragment(Product);
  }

  public static class ActionFilterParentFragmentToProductFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionFilterParentFragmentToProductFragment(@Nullable Product Product) {
      this.arguments.put("Product", Product);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionFilterParentFragmentToProductFragment setProduct(@Nullable Product Product) {
      this.arguments.put("Product", Product);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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

    @Override
    public int getActionId() {
      return R.id.action_filterParentFragment_to_productFragment;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public Product getProduct() {
      return (Product) arguments.get("Product");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionFilterParentFragmentToProductFragment that = (ActionFilterParentFragmentToProductFragment) object;
      if (arguments.containsKey("Product") != that.arguments.containsKey("Product")) {
        return false;
      }
      if (getProduct() != null ? !getProduct().equals(that.getProduct()) : that.getProduct() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getProduct() != null ? getProduct().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionFilterParentFragmentToProductFragment(actionId=" + getActionId() + "){"
          + "Product=" + getProduct()
          + "}";
    }
  }
}
