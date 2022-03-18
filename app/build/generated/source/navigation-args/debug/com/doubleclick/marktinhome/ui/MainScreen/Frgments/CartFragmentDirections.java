package com.doubleclick.marktinhome.ui.MainScreen.Frgments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.doubleclick.marktinhome.R;

public class CartFragmentDirections {
  private CartFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionMenuCartToMenuProfile() {
    return new ActionOnlyNavDirections(R.id.action_menu_Cart_to_menu_profile);
  }

  @NonNull
  public static NavDirections actionMenuCartToAddressFragment() {
    return new ActionOnlyNavDirections(R.id.action_menu_Cart_to_addressFragment);
  }

  @NonNull
  public static NavDirections actionMenuCartToOrderSelllerFragment() {
    return new ActionOnlyNavDirections(R.id.action_menu_Cart_to_orderSelllerFragment);
  }
}
