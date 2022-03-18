package com.doubleclick.marktinhome.ui.MainScreen.Comments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CommentsFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private CommentsFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private CommentsFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CommentsFragmentArgs fromBundle(@NonNull Bundle bundle) {
    CommentsFragmentArgs __result = new CommentsFragmentArgs();
    bundle.setClassLoader(CommentsFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("idProduct")) {
      String idProduct;
      idProduct = bundle.getString("idProduct");
      __result.arguments.put("idProduct", idProduct);
    } else {
      throw new IllegalArgumentException("Required argument \"idProduct\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CommentsFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    CommentsFragmentArgs __result = new CommentsFragmentArgs();
    if (savedStateHandle.contains("idProduct")) {
      String idProduct;
      idProduct = savedStateHandle.get("idProduct");
      __result.arguments.put("idProduct", idProduct);
    } else {
      throw new IllegalArgumentException("Required argument \"idProduct\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getIdProduct() {
    return (String) arguments.get("idProduct");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("idProduct")) {
      String idProduct = (String) arguments.get("idProduct");
      __result.putString("idProduct", idProduct);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("idProduct")) {
      String idProduct = (String) arguments.get("idProduct");
      __result.set("idProduct", idProduct);
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
    CommentsFragmentArgs that = (CommentsFragmentArgs) object;
    if (arguments.containsKey("idProduct") != that.arguments.containsKey("idProduct")) {
      return false;
    }
    if (getIdProduct() != null ? !getIdProduct().equals(that.getIdProduct()) : that.getIdProduct() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getIdProduct() != null ? getIdProduct().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "CommentsFragmentArgs{"
        + "idProduct=" + getIdProduct()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull CommentsFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@Nullable String idProduct) {
      this.arguments.put("idProduct", idProduct);
    }

    @NonNull
    public CommentsFragmentArgs build() {
      CommentsFragmentArgs result = new CommentsFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setIdProduct(@Nullable String idProduct) {
      this.arguments.put("idProduct", idProduct);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @Nullable
    public String getIdProduct() {
      return (String) arguments.get("idProduct");
    }
  }
}
