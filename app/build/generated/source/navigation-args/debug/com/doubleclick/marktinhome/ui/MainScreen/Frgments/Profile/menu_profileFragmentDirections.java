package com.doubleclick.marktinhome.ui.MainScreen.Frgments.Profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.doubleclick.marktinhome.R;

public class menu_profileFragmentDirections {
  private menu_profileFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionMenuProfileToRecentOrderFragment() {
    return new ActionOnlyNavDirections(R.id.action_menu_profile_to_recentOrderFragment);
  }

  @NonNull
  public static NavDirections actionMenuProfileToJoinUsFragment() {
    return new ActionOnlyNavDirections(R.id.action_menu_profile_to_joinUsFragment);
  }

  @NonNull
  public static NavDirections actionMenuProfileToGroupFragment() {
    return new ActionOnlyNavDirections(R.id.action_menu_profile_to_groupFragment);
  }
}
