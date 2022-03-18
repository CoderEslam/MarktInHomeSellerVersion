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

public class UploadFragmentDirections {
  private UploadFragmentDirections() {
  }

  @NonNull
  public static ActionUploadFragmentToChildFragment actionUploadFragmentToChildFragment(
      @Nullable ParentCategory Parent) {
    return new ActionUploadFragmentToChildFragment(Parent);
  }

  public static class ActionUploadFragmentToChildFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionUploadFragmentToChildFragment(@Nullable ParentCategory Parent) {
      this.arguments.put("Parent", Parent);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionUploadFragmentToChildFragment setParent(@Nullable ParentCategory Parent) {
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
      return R.id.action_uploadFragment_to_childFragment;
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
      ActionUploadFragmentToChildFragment that = (ActionUploadFragmentToChildFragment) object;
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
      return "ActionUploadFragmentToChildFragment(actionId=" + getActionId() + "){"
          + "Parent=" + getParent()
          + "}";
    }
  }
}
