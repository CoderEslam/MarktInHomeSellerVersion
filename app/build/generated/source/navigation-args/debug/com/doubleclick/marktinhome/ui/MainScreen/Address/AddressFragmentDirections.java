package com.doubleclick.marktinhome.ui.MainScreen.Address;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.doubleclick.marktinhome.R;

public class AddressFragmentDirections {
  private AddressFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionAddressFragmentToHomeFragment() {
    return new ActionOnlyNavDirections(R.id.action_addressFragment_to_homeFragment);
  }
}
