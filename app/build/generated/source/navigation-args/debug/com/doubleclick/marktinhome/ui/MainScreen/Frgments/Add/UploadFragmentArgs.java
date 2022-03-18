package com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.doubleclick.marktinhome.Model.ChildCategory;
import com.doubleclick.marktinhome.Model.ParentCategory;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class UploadFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private UploadFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private UploadFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static UploadFragmentArgs fromBundle(@NonNull Bundle bundle) {
    UploadFragmentArgs __result = new UploadFragmentArgs();
    bundle.setClassLoader(UploadFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("child")) {
      ChildCategory child;
      if (Parcelable.class.isAssignableFrom(ChildCategory.class) || Serializable.class.isAssignableFrom(ChildCategory.class)) {
        child = (ChildCategory) bundle.get("child");
      } else {
        throw new UnsupportedOperationException(ChildCategory.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      __result.arguments.put("child", child);
    } else {
      throw new IllegalArgumentException("Required argument \"child\" is missing and does not have an android:defaultValue");
    }
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
  public static UploadFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    UploadFragmentArgs __result = new UploadFragmentArgs();
    if (savedStateHandle.contains("child")) {
      ChildCategory child;
      child = savedStateHandle.get("child");
      __result.arguments.put("child", child);
    } else {
      throw new IllegalArgumentException("Required argument \"child\" is missing and does not have an android:defaultValue");
    }
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
  public ChildCategory getChild() {
    return (ChildCategory) arguments.get("child");
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

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("child")) {
      ChildCategory child = (ChildCategory) arguments.get("child");
      if (Parcelable.class.isAssignableFrom(ChildCategory.class) || child == null) {
        __result.set("child", Parcelable.class.cast(child));
      } else if (Serializable.class.isAssignableFrom(ChildCategory.class)) {
        __result.set("child", Serializable.class.cast(child));
      } else {
        throw new UnsupportedOperationException(ChildCategory.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    }
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
    UploadFragmentArgs that = (UploadFragmentArgs) object;
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
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getChild() != null ? getChild().hashCode() : 0);
    result = 31 * result + (getParent() != null ? getParent().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "UploadFragmentArgs{"
        + "child=" + getChild()
        + ", Parent=" + getParent()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull UploadFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@Nullable ChildCategory child, @Nullable ParentCategory Parent) {
      this.arguments.put("child", child);
      this.arguments.put("Parent", Parent);
    }

    @NonNull
    public UploadFragmentArgs build() {
      UploadFragmentArgs result = new UploadFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setChild(@Nullable ChildCategory child) {
      this.arguments.put("child", child);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setParent(@Nullable ParentCategory Parent) {
      this.arguments.put("Parent", Parent);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @Nullable
    public ChildCategory getChild() {
      return (ChildCategory) arguments.get("child");
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @Nullable
    public ParentCategory getParent() {
      return (ParentCategory) arguments.get("Parent");
    }
  }
}
