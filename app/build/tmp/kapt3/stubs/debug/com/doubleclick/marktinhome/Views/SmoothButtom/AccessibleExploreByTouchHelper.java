package com.doubleclick.marktinhome.Views.SmoothButtom;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B>\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\b\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u0016\u0010\u0013\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0015H\u0014J\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\tH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/doubleclick/marktinhome/Views/SmoothButtom/AccessibleExploreByTouchHelper;", "Landroidx/customview/widget/ExploreByTouchHelper;", "host", "Lcom/doubleclick/marktinhome/Views/SmoothButtom/SmoothBottomBar;", "bottomBarItems", "", "Lcom/doubleclick/marktinhome/Views/SmoothButtom/BottomBarItem;", "onClickAction", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "id", "", "(Lcom/doubleclick/marktinhome/Views/SmoothButtom/SmoothBottomBar;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getVirtualViewAt", "x", "", "y", "getVisibleVirtualViews", "virtualViewIds", "", "onPerformActionForVirtualView", "", "virtualViewId", "action", "arguments", "Landroid/os/Bundle;", "onPopulateNodeForVirtualView", "node", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "updateBoundsForBottomItem", "Landroid/graphics/Rect;", "index", "app_debug"})
public final class AccessibleExploreByTouchHelper extends androidx.customview.widget.ExploreByTouchHelper {
    private final com.doubleclick.marktinhome.Views.SmoothButtom.SmoothBottomBar host = null;
    private final java.util.List<com.doubleclick.marktinhome.Views.SmoothButtom.BottomBarItem> bottomBarItems = null;
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> onClickAction = null;
    
    public AccessibleExploreByTouchHelper(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Views.SmoothButtom.SmoothBottomBar host, @org.jetbrains.annotations.NotNull()
    java.util.List<com.doubleclick.marktinhome.Views.SmoothButtom.BottomBarItem> bottomBarItems, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onClickAction) {
        super(null);
    }
    
    @java.lang.Override()
    protected void getVisibleVirtualViews(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> virtualViewIds) {
    }
    
    @java.lang.Override()
    protected int getVirtualViewAt(float x, float y) {
        return 0;
    }
    
    /**
     * setBoundsInParent is required by [ExploreByTouchHelper]
     */
    @kotlin.Suppress(names = {"DEPRECATION"})
    @java.lang.Override()
    protected void onPopulateNodeForVirtualView(int virtualViewId, @org.jetbrains.annotations.NotNull()
    androidx.core.view.accessibility.AccessibilityNodeInfoCompat node) {
    }
    
    @java.lang.Override()
    protected boolean onPerformActionForVirtualView(int virtualViewId, int action, @org.jetbrains.annotations.Nullable()
    android.os.Bundle arguments) {
        return false;
    }
    
    private final android.graphics.Rect updateBoundsForBottomItem(int index) {
        return null;
    }
}