package com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add;

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

public class ChildFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ChildFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private ChildFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ChildFragmentArgs fromBundle(@NonNull Bundle bundle) {
    ChildFragmentArgs __result = new ChildFragmentArgs();
    bundle.setClassLoader(ChildFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("Parent")) {
      ParentCategory Parent;
      if (Parcelable.class.isAssignableFrom(ParentCategory.class) || Serializable.class.isAssignableFrom(ParentCategory.class)) {
        Parent = (ParentCategory) bundle.get("Parent");
      } else {
        throw new UnsupportedOperationException(ParentCategory.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      __result.arguments.put("Parent", Parent);
    } else {
      throw new IllegalArgumentException("Required argument \"Parent\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ChildFragmentArgs fromSavedStateHandle(@NonNull SavedStateHandle savedStateHandle) {
    ChildFragmentArgs __result = new ChildFragmentArgs();
    if (savedStateHandle.contains("Parent")) {
      ParentCategory Parent;
      Parent = savedStateHandle.get("Parent");
      __result.arguments.put("Parent", Parent);
    } else {
      throw new IllegalArgumentException("Required argument \"Parent\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public ParentCategory getParent() {
    return (ParentCategory) arguments.get("Parent");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("Parent")) {
      ParentCategory Parent = (ParentCategory) arguments.get("Parent");
      if (Parcelable.class.isAssignableFrom(ParentCategory.class) || Parent == null) {
        __result.set("Parent", Parcelable.class.cast(Parent));
      } else if (Serializable.class.isAssignableFrom(ParentCategory.class)) {
        __result.set("Parent", Serializable.class.cast(Parent));
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
    ChildFragmentArgs that = (ChildFragmentArgs) object;
    if (arguments.containsKey("Parent") != that.arguments.containsKey("Parent")) {
      return false;
    }
    if (getParent() != null ? !getParent().equals(that.getParent()) : that.getParent() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getParent() != null ? getParent().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ChildFragmentArgs{"
        + "Parent=" + getParent()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull ChildFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@Nullable ParentCategory Parent) {
      this.arguments.put("Parent", Parent);
    }

    @NonNull
    public ChildFragmentArgs build() {
      ChildFragmentArgs result = new ChildFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setParent(@Nullable ParentCategory Parent) {
      this.arguments.put("Parent", Parent);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @Nullable
    public ParentCategory getParent() {
      return (ParentCategory) arguments.get("Parent");
    }
  }
}
