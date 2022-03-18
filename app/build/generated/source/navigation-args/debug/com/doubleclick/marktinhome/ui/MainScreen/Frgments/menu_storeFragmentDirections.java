package com.doubleclick.marktinhome.ui.MainScreen.Frgments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.doubleclick.marktinhome.R;

public class menu_storeFragmentDirections {
  private menu_storeFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionMenuStoreToMenuCart() {
    return new ActionOnlyNavDirections(R.id.action_menu_store_to_menu_Cart);
  }
}
