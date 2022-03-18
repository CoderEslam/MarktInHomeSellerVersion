package com.doubleclick.marktinhome.ui.MainScreen.Frgments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.doubleclick.marktinhome.Model.ParentCategory;
import com.doubleclick.marktinhome.Model.Product;
import com.doubleclick.marktinhome.Model.Trademark;
import com.doubleclick.marktinhome.R;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class HomeFragmentDirections {
  private HomeFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionHomeFragmentToMenuCart() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_menu_Cart);
  }

  @NonNull
  public static ActionHomeFragmentToProductFragment actionHomeFragmentToProductFragment(
      @Nullable Product Product) {
    return new ActionHomeFragmentToProductFragment(Product);
  }

  @NonNull
  public static ActionHomeFragmentToFilterParentFragment actionHomeFragmentToFilterParentFragment(
      @Nullable ParentCategory ParentCategory) {
    return new ActionHomeFragmentToFilterParentFragment(ParentCategory);
  }

  @NonNull
  public static ActionHomeFragmentToTrademarkFragment actionHomeFragmentToTrademarkFragment(
      @Nullable Trademark trademark) {
    return new ActionHomeFragmentToTrademarkFragment(trademark);
  }

  @NonNull
  public static ActionHomeFragmentToViewMoreFragment actionHomeFragmentToViewMoreFragment(
      @NonNull Product[] productArray) {
    return new ActionHomeFragmentToViewMoreFragment(productArray);
  }

  public static class ActionHomeFragmentToProductFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionHomeFragmentToProductFragment(@Nullable Product Product) {
      this.arguments.put("Product", Product);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionHomeFragmentToProductFragment setProduct(@Nullable Product Product) {
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
      return R.id.action_homeFragment_to_productFragment;
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
      ActionHomeFragmentToProductFragment that = (ActionHomeFragmentToProductFragment) object;
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
      return "ActionHomeFragmentToProductFragment(actionId=" + getActionId() + "){"
          + "Product=" + getProduct()
          + "}";
    }
  }

  public static class ActionHomeFragmentToFilterParentFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionHomeFragmentToFilterParentFragment(@Nullable ParentCategory ParentCategory) {
      this.arguments.put("ParentCategory", ParentCategory);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionHomeFragmentToFilterParentFragment setParentCategory(
        @Nullable ParentCategory ParentCategory) {
      this.arguments.put("ParentCategory", ParentCategory);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("ParentCategory")) {
        ParentCategory ParentCategory = (ParentCategory) arguments.get("ParentCategory");
        if (Parcelable.class.isAssignableFrom(ParentCategory.class) || ParentCategory == null) {
          __result.putParcelable("ParentCategory", Parcelable.class.cast(ParentCategory));
        } else if (Serializable.class.isAssignableFrom(ParentCategory.class)) {
          __result.putSerializable("ParentCategory", Serializable.class.cast(ParentCategory));
        } else {
          throw new UnsupportedOperationException(ParentCategory.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_homeFragment_to_filterParentFragment;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public ParentCategory getParentCategory() {
      return (ParentCategory) arguments.get("ParentCategory");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionHomeFragmentToFilterParentFragment that = (ActionHomeFragmentToFilterParentFragment) object;
      if (arguments.containsKey("ParentCategory") != that.arguments.containsKey("ParentCategory")) {
        return false;
      }
      if (getParentCategory() != null ? !getParentCategory().equals(that.getParentCategory()) : that.getParentCategory() != null) {
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
      result = 31 * result + (getParentCategory() != null ? getParentCategory().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionHomeFragmentToFilterParentFragment(actionId=" + getActionId() + "){"
          + "ParentCategory=" + getParentCategory()
          + "}";
    }
  }

  public static class ActionHomeFragmentToTrademarkFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionHomeFragmentToTrademarkFragment(@Nullable Trademark trademark) {
      this.arguments.put("trademark", trademark);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionHomeFragmentToTrademarkFragment setTrademark(@Nullable Trademark trademark) {
      this.arguments.put("trademark", trademark);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("trademark")) {
        Trademark trademark = (Trademark) arguments.get("trademark");
        if (Parcelable.class.isAssignableFrom(Trademark.class) || trademark == null) {
          __result.putParcelable("trademark", Parcelable.class.cast(trademark));
        } else if (Serializable.class.isAssignableFrom(Trademark.class)) {
          __result.putSerializable("trademark", Serializable.class.cast(trademark));
        } else {
          throw new UnsupportedOperationException(Trademark.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_homeFragment_to_trademarkFragment;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public Trademark getTrademark() {
      return (Trademark) arguments.get("trademark");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionHomeFragmentToTrademarkFragment that = (ActionHomeFragmentToTrademarkFragment) object;
      if (arguments.containsKey("trademark") != that.arguments.containsKey("trademark")) {
        return false;
      }
      if (getTrademark() != null ? !getTrademark().equals(that.getTrademark()) : that.getTrademark() != null) {
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
      result = 31 * result + (getTrademark() != null ? getTrademark().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionHomeFragmentToTrademarkFragment(actionId=" + getActionId() + "){"
          + "trademark=" + getTrademark()
          + "}";
    }
  }

  public static class ActionHomeFragmentToViewMoreFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionHomeFragmentToViewMoreFragment(@NonNull Product[] productArray) {
      if (productArray == null) {
        throw new IllegalArgumentException("Argument \"productArray\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("productArray", productArray);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionHomeFragmentToViewMoreFragment setProductArray(@NonNull Product[] productArray) {
      if (productArray == null) {
        throw new IllegalArgumentException("Argument \"productArray\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("productArray", productArray);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("productArray")) {
        Product[] productArray = (Product[]) arguments.get("productArray");
        __result.putParcelableArray("productArray", productArray);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_homeFragment_to_ViewMoreFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Product[] getProductArray() {
      return (Product[]) arguments.get("productArray");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionHomeFragmentToViewMoreFragment that = (ActionHomeFragmentToViewMoreFragment) object;
      if (arguments.containsKey("productArray") != that.arguments.containsKey("productArray")) {
        return false;
      }
      if (getProductArray() != null ? !getProductArray().equals(that.getProductArray()) : that.getProductArray() != null) {
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
      result = 31 * result + java.util.Arrays.hashCode(getProductArray());
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionHomeFragmentToViewMoreFragment(actionId=" + getActionId() + "){"
          + "productArray=" + getProductArray()
          + "}";
    }
  }
}
