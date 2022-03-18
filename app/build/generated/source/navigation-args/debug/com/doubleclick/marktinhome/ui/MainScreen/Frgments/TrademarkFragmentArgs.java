package com.doubleclick.marktinhome.ui.MainScreen.Frgments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.doubleclick.marktinhome.Model.Trademark;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class TrademarkFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private TrademarkFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private TrademarkFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static TrademarkFragmentArgs fromBundle(@NonNull Bundle bundle) {
    TrademarkFragmentArgs __result = new TrademarkFragmentArgs();
    bundle.setClassLoader(TrademarkFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("trademark")) {
      Trademark trademark;
      if (Parcelable.class.isAssignableFrom(Trademark.class) || Serializable.class.isAssignableFrom(Trademark.class)) {
        trademark = (Trademark) bundle.get("trademark");
      } else {
        throw new UnsupportedOperationException(Trademark.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      __result.arguments.put("trademark", trademark);
    } else {
      throw new IllegalArgumentException("Required argument \"trademark\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static TrademarkFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    TrademarkFragmentArgs __result = new TrademarkFragmentArgs();
    if (savedStateHandle.contains("trademark")) {
      Trademark trademark;
      trademark = savedStateHandle.get("trademark");
      __result.arguments.put("trademark", trademark);
    } else {
      throw new IllegalArgumentException("Required argument \"trademark\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public Trademark getTrademark() {
    return (Trademark) arguments.get("trademark");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("trademark")) {
      Trademark trademark = (Trademark) arguments.get("trademark");
      if (Parcelable.class.isAssignableFrom(Trademark.class) || trademark == null) {
        __result.set("trademark", Parcelable.class.cast(trademark));
      } else if (Serializable.class.isAssignableFrom(Trademark.class)) {
        __result.set("trademark", Serializable.class.cast(trademark));
      } else {
        throw new UnsupportedOperationException(Trademark.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
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
    TrademarkFragmentArgs that = (TrademarkFragmentArgs) object;
    if (arguments.containsKey("trademark") != that.arguments.containsKey("trademark")) {
      return false;
    }
    if (getTrademark() != null ? !getTrademark().equals(that.getTrademark()) : that.getTrademark() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getTrademark() != null ? getTrademark().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "TrademarkFragmentArgs{"
        + "trademark=" + getTrademark()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull TrademarkFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@Nullable Trademark trademark) {
      this.arguments.put("trademark", trademark);
    }

    @NonNull
    public TrademarkFragmentArgs build() {
      TrademarkFragmentArgs result = new TrademarkFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setTrademark(@Nullable Trademark trademark) {
      this.arguments.put("trademark", trademark);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @Nullable
    public Trademark getTrademark() {
      return (Trademark) arguments.get("trademark");
    }
  }
}
