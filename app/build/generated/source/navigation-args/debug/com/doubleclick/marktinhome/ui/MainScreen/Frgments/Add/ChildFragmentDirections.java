package com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.doubleclick.marktinhome.Model.ChildCategory;
import com.doubleclick.marktinhome.Model.ParentCategory;
import com.doubleclick.marktinhome.R;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ChildFragmentDirections {
  private ChildFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionChildFragmentToParentFragment() {
    return new ActionOnlyNavDirections(R.id.action_childFragment_to_parentFragment);
  }

  @NonNull
  public static ActionChildFragmentToUploadFragment actionChildFragmentToUploadFragment(
      @Nullable ChildCategory child, @Nullable ParentCategory Parent) {
    return new ActionChildFragmentToUploadFragment(child, Parent);
  }

  public static class ActionChildFragmentToUploadFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionChildFragmentToUploadFragment(@Nullable ChildCategory child,
        @Nullable ParentCategory Parent) {
      this.arguments.put("child", child);
      this.arguments.put("Parent", Parent);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionChildFragmentToUploadFragment setChild(@Nullable ChildCategory child) {
      this.arguments.put("child", child);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionChildFragmentToUploadFragment setParent(@Nullable ParentCategory Parent) {
      this.arguments.put("Parent", Parent);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("child")) {
        ChildCategory child = (ChildCategory) arguments.get("child");
        if (Parcelable.class.isAssignableFrom(ChildCategory.class) || child == null) {
          __result.putParcelable("child", Parcelable.class.cast(child));
        } else if (Serializable.class.isAssignableFrom(ChildCategory.class)) {
          __result.putSerializable("child", Serializable.class.cast(child));
        } else {
          throw new UnsupportedOperationException(ChildCategory.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
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
      return R.id.action_childFragment_to_uploadFragment;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public ChildCategory getChild() {
      return (ChildCategory) arguments.get("child");
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
      ActionChildFragmentToUploadFragment that = (ActionChildFragmentToUploadFragment) object;
      if (arguments.containsKey("child") != that.arguments.containsKey("child")) {
        return false;
      }
      if (getChild() != null ? !getChild().equals(that.getChild()) : that.getChild() != null) {
        return false;
      }
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
      result = 31 * result + (getChild() != null ? getChild().hashCode() : 0);
      result = 31 * result + (getParent() != null ? getParent().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionChildFragmentToUploadFragment(actionId=" + getActionId() + "){"
          + "child=" + getChild()
          + ", Parent=" + getParent()
          + "}";
    }
  }
}
