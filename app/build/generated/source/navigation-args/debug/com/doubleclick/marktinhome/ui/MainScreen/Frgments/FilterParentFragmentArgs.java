package com.doubleclick.marktinhome.ui.MainScreen.Frgments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.doubleclick.marktinhome.Model.ParentCategory;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class FilterParentFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private FilterParentFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private FilterParentFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static FilterParentFragmentArgs fromBundle(@NonNull Bundle bundle) {
    FilterParentFragmentArgs __result = new FilterParentFragmentArgs();
    bundle.setClassLoader(FilterParentFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("ParentCategory")) {
      ParentCategory ParentCategory;
      if (Parcelable.class.isAssignableFrom(ParentCategory.class) || Serializable.class.isAssignableFrom(ParentCategory.class)) {
        ParentCategory = (ParentCategory) bundle.get("ParentCategory");
      } else {
        throw new UnsupportedOperationException(ParentCategory.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      __result.arguments.put("ParentCategory", ParentCategory);
    } else {
      throw new IllegalArgumentException("Required argument \"ParentCategory\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static FilterParentFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    FilterParentFragmentArgs __result = new FilterParentFragmentArgs();
    if (savedStateHandle.contains("ParentCategory")) {
      ParentCategory ParentCategory;
      ParentCategory = savedStateHandle.get("ParentCategory");
      __result.arguments.put("ParentCategory", ParentCategory);
    } else {
      throw new IllegalArgumentException("Required argument \"ParentCategory\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public ParentCategory getParentCategory() {
    return (ParentCategory) arguments.get("ParentCategory");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("ParentCategory")) {
      ParentCategory ParentCategory = (ParentCategory) arguments.get("ParentCategory");
      if (Parcelable.class.isAssignableFrom(ParentCategory.class) || ParentCategory == null) {
        __result.set("ParentCategory", Parcelable.class.cast(ParentCategory));
      } else if (Serializable.class.isAssignableFrom(ParentCategory.class)) {
        __result.set("ParentCategory", Serializable.class.cast(ParentCategory));
      } else {
        throw new UnsupportedOperationException(ParentCategory.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
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
    FilterParentFragmentArgs that = (FilterParentFragmentArgs) object;
    if (arguments.containsKey("ParentCategory") != that.arguments.containsKey("ParentCategory")) {
      return false;
    }
    if (getParentCategory() != null ? !getParentCategory().equals(that.getParentCategory()) : that.getParentCategory() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getParentCategory() != null ? getParentCategory().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "FilterParentFragmentArgs{"
        + "ParentCategory=" + getParentCategory()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull FilterParentFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@Nullable ParentCategory ParentCategory) {
      this.arguments.put("ParentCategory", ParentCategory);
    }

    @NonNull
    public FilterParentFragmentArgs build() {
      FilterParentFragmentArgs result = new FilterParentFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setParentCategory(@Nullable ParentCategory ParentCategory) {
      this.arguments.put("ParentCategory", ParentCategory);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @Nullable
    public ParentCategory getParentCategory() {
      return (ParentCategory) arguments.get("ParentCategory");
    }
  }
}
