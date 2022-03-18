package com.doubleclick.marktinhome.Views.SmoothButtom;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/doubleclick/marktinhome/Views/SmoothButtom/NavigationComponentHelper;", "", "()V", "Companion", "app_debug"})
public final class NavigationComponentHelper {
    @org.jetbrains.annotations.NotNull()
    public static final com.doubleclick.marktinhome.Views.SmoothButtom.NavigationComponentHelper.Companion Companion = null;
    
    public NavigationComponentHelper() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/doubleclick/marktinhome/Views/SmoothButtom/NavigationComponentHelper$Companion;", "", "()V", "matchDestination", "", "destination", "Landroidx/navigation/NavDestination;", "destId", "", "setupWithNavController", "", "menu", "Landroid/view/Menu;", "smoothBottomBar", "Lcom/doubleclick/marktinhome/Views/SmoothButtom/SmoothBottomBar;", "navController", "Landroidx/navigation/NavController;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void setupWithNavController(@org.jetbrains.annotations.NotNull()
        android.view.Menu menu, @org.jetbrains.annotations.NotNull()
        com.doubleclick.marktinhome.Views.SmoothButtom.SmoothBottomBar smoothBottomBar, @org.jetbrains.annotations.NotNull()
        androidx.navigation.NavController navController) {
        }
        
        /**
         * Determines whether the given `destId` matches the NavDestination. This handles
         * both the default case (the destination's id matches the given id) and the nested case where
         * the given id is a parent/grandparent/etc of the destination.
         */
        public final boolean matchDestination(@org.jetbrains.annotations.NotNull()
        androidx.navigation.NavDestination destination, @androidx.annotation.IdRes()
        int destId) {
            return false;
        }
    }
}