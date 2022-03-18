package com.doubleclick.marktinhome.ui.ProductActivity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.doubleclick.marktinhome.R;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class productFragmentDirections {
  private productFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionProductFragmentToHomeFragment() {
    return new ActionOnlyNavDirections(R.id.action_productFragment_to_homeFragment);
  }

  @NonNull
  public static ActionProductFragmentToCommentsFragment actionProductFragmentToCommentsFragment(
      @Nullable String idProduct) {
    return new ActionProductFragmentToCommentsFragment(idProduct);
  }

  public static class ActionProductFragmentToCommentsFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionProductFragmentToCommentsFragment(@Nullable String idProduct) {
      this.arguments.put("idProduct", idProduct);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionProductFragmentToCommentsFragment setIdProduct(@Nullable String idProduct) {
      this.arguments.put("idProduct", idProduct);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("idProduct")) {
        String idProduct = (String) arguments.get("idProduct");
        __result.putString("idProduct", idProduct);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_productFragment_to_commentsFragment;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getIdProduct() {
      return (String) arguments.get("idProduct");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionProductFragmentToCommentsFragment that = (ActionProductFragmentToCommentsFragment) object;
      if (arguments.containsKey("idProduct") != that.arguments.containsKey("idProduct")) {
        return false;
      }
      if (getIdProduct() != null ? !getIdProduct().equals(that.getIdProduct()) : that.getIdProduct() != null) {
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
      result = 31 * result + (getIdProduct() != null ? getIdProduct().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionProductFragmentToCommentsFragment(actionId=" + getActionId() + "){"
          + "idProduct=" + getIdProduct()
          + "}";
    }
  }
}
