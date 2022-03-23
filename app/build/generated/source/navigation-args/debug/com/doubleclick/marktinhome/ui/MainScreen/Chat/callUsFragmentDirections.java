package com.doubleclick.marktinhome.ui.MainScreen.Chat;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.doubleclick.marktinhome.R;

public class callUsFragmentDirections {
  private callUsFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionCallUsFragmentToAllUserFragment() {
    return new ActionOnlyNavDirections(R.id.action_callUsFragment_to_allUserFragment);
  }
}
