package com.doubleclick.marktinhome.ui.MainScreen.Chat;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.doubleclick.marktinhome.Model.User;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class callUsFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private callUsFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private callUsFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static callUsFragmentArgs fromBundle(@NonNull Bundle bundle) {
    callUsFragmentArgs __result = new callUsFragmentArgs();
    bundle.setClassLoader(callUsFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("user")) {
      User user;
      if (Parcelable.class.isAssignableFrom(User.class) || Serializable.class.isAssignableFrom(User.class)) {
        user = (User) bundle.get("user");
      } else {
        throw new UnsupportedOperationException(User.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      if (user == null) {
        throw new IllegalArgumentException("Argument \"user\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("user", user);
    } else {
      throw new IllegalArgumentException("Required argument \"user\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static callUsFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    callUsFragmentArgs __result = new callUsFragmentArgs();
    if (savedStateHandle.contains("user")) {
      User user;
      user = savedStateHandle.get("user");
      if (user == null) {
        throw new IllegalArgumentException("Argument \"user\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("user", user);
    } else {
      throw new IllegalArgumentException("Required argument \"user\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public User getUser() {
    return (User) arguments.get("user");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("user")) {
      User user = (User) arguments.get("user");
      if (Parcelable.class.isAssignableFrom(User.class) || user == null) {
        __result.putParcelable("user", Parcelable.class.cast(user));
      } else if (Serializable.class.isAssignableFrom(User.class)) {
        __result.putSerializable("user", Serializable.class.cast(user));
      } else {
        throw new UnsupportedOperationException(User.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("user")) {
      User user = (User) arguments.get("user");
      if (Parcelable.class.isAssignableFrom(User.class) || user == null) {
        __result.set("user", Parcelable.class.cast(user));
      } else if (Serializable.class.isAssignableFrom(User.class)) {
        __result.set("user", Serializable.class.cast(user));
      } else {
        throw new UnsupportedOperationException(User.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
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
    callUsFragmentArgs that = (callUsFragmentArgs) object;
    if (arguments.containsKey("user") != that.arguments.containsKey("user")) {
      return false;
    }
    if (getUser() != null ? !getUser().equals(that.getUser()) : that.getUser() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "callUsFragmentArgs{"
        + "user=" + getUser()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull callUsFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull User user) {
      if (user == null) {
        throw new IllegalArgumentException("Argument \"user\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("user", user);
    }

    @NonNull
    public callUsFragmentArgs build() {
      callUsFragmentArgs result = new callUsFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setUser(@NonNull User user) {
      if (user == null) {
        throw new IllegalArgumentException("Argument \"user\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("user", user);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public User getUser() {
      return (User) arguments.get("user");
    }
  }
}
