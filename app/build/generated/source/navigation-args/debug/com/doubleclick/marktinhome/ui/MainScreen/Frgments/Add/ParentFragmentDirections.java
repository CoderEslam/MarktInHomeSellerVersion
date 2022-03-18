package com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDirections;
import com.doubleclick.marktinhome.Model.ParentCategory;
import com.doubleclick.marktinhome.R;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ParentFragmentDirections {
  private ParentFragmentDirections() {
  }

  @NonNull
  public static ActionParentFragmentToChildFragment actionParentFragmentToChildFragment(
      @Nullable ParentCategory Parent) {
    return new ActionParentFragmentToChildFragment(Parent);
  }

  public static class ActionParentFragmentToChildFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionParentFragmentToChildFragment(@Nullable ParentCategory Parent) {
      this.arguments.put("Parent", Parent);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionParentFragmentToChildFragment setParent(@Nullable ParentCategory Parent) {
      this.arguments.put("Parent", Parent);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("Parent")) {
        ParentCategory Parent = (ParentCategory) arguments.get("Parent");
        if (Parcelable.class.isAssignableFrom(ParentCategory.class) || Parent == null) {
          __result.putParcelable("Parent", Parcelable.class.cast(Parent));
        } else if (Serializable.class.isAssignableFrom(ParentCategory.class)) {
          __result.putSerializable("Parent", Serializable.class.cast(Parent));
        } else {
          throw new UnsupportedOperationException(ParentCategory.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_parentFragment_to_childFragment;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public ParentCategory getParent() {
      return (ParentCategory) arguments.get("Parent");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionParentFragmentToChildFragment that = (ActionParentFragmentToChildFragment) object;
      if (arguments.containsKey("Parent") != that.arguments.containsKey("Parent")) {
        return false;
      }
      if (getParent() != null ? !getParent().equals(that.getParent()) : that.getParent() != null) {
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
      result = 31 * result + (getParent() != null ? getParent().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionParentFragmentToChildFragment(actionId=" + getActionId() + "){"
          + "Parent=" + getParent()
          + "}";
    }
  }
}
