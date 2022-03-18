package com.doubleclick.marktinhome.Views.liquid_swipe;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\u0012\u0010\u001f\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J(\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bH\u0014J\u0010\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\'H\u0016J\b\u0010(\u001a\u00020\u0013H\u0016J\u0012\u0010)\u001a\u00020\u00132\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010,\u001a\u00020\u00132\b\b\u0001\u0010-\u001a\u00020\u000bJ\u0010\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u000bH\u0016J\u0010\u00100\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u000bH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/doubleclick/marktinhome/Views/liquid_swipe/LiquidPager;", "Landroidx/viewpager/widget/ViewPager;", "Landroid/view/ViewTreeObserver$OnDrawListener;", "Lcom/doubleclick/marktinhome/Views/liquid_swipe/ViewI;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "buttonDrawableId", "", "inputBlocked", "", "leftEdgeController", "Lcom/doubleclick/marktinhome/Views/liquid_swipe/animation/LeftEdgeController;", "rightEdgeController", "Lcom/doubleclick/marktinhome/Views/liquid_swipe/animation/RightEdgeController;", "blockInput", "", "block", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "getBitmap", "Landroid/graphics/Bitmap;", "direction", "getBitmapAt", "position", "getCount", "onDraw", "onDrawForeground", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "redraw", "setAdapter", "adapter", "Landroidx/viewpager/widget/PagerAdapter;", "setButtonDrawable", "drawableId", "setOffscreenPageLimit", "limit", "switchPage", "app_debug"})
public final class LiquidPager extends androidx.viewpager.widget.ViewPager implements android.view.ViewTreeObserver.OnDrawListener, com.doubleclick.marktinhome.Views.liquid_swipe.ViewI {
    private com.doubleclick.marktinhome.Views.liquid_swipe.animation.LeftEdgeController leftEdgeController;
    private com.doubleclick.marktinhome.Views.liquid_swipe.animation.RightEdgeController rightEdgeController;
    private boolean inputBlocked = false;
    private int buttonDrawableId = com.doubleclick.marktinhome.R.drawable.ic_button;
    private java.util.HashMap _$_findViewCache;
    
    public LiquidPager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    public LiquidPager(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public final void setButtonDrawable(@androidx.annotation.DrawableRes()
    int drawableId) {
    }
    
    @java.lang.Override()
    public int getCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.graphics.Bitmap getBitmap(int direction) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.graphics.Bitmap getBitmapAt(int position) {
        return null;
    }
    
    @java.lang.Override()
    public void redraw() {
    }
    
    @java.lang.Override()
    public void switchPage(int direction) {
    }
    
    @java.lang.Override()
    public void blockInput(boolean block) {
    }
    
    @java.lang.Override()
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    }
    
    @java.lang.Override()
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent ev) {
        return false;
    }
    
    @java.lang.Override()
    public void onDrawForeground(@org.jetbrains.annotations.Nullable()
    android.graphics.Canvas canvas) {
    }
    
    @java.lang.Override()
    protected void dispatchDraw(@org.jetbrains.annotations.Nullable()
    android.graphics.Canvas canvas) {
    }
    
    @java.lang.Override()
    public void onDraw() {
    }
    
    @java.lang.Override()
    public void setOffscreenPageLimit(int limit) {
    }
    
    @java.lang.Override()
    public void setAdapter(@org.jetbrains.annotations.Nullable()
    androidx.viewpager.widget.PagerAdapter adapter) {
    }
}