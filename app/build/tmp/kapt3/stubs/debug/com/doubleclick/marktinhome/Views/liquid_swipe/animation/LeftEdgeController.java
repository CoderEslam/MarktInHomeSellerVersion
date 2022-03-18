package com.doubleclick.marktinhome.Views.liquid_swipe.animation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0006H\u0014R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/doubleclick/marktinhome/Views/liquid_swipe/animation/LeftEdgeController;", "Lcom/doubleclick/marktinhome/Views/liquid_swipe/EdgeController;", "viewWidth", "", "viewHeight", "waveCenterY", "", "density", "view", "Lcom/doubleclick/marktinhome/Views/liquid_swipe/ViewI;", "(IIFFLcom/doubleclick/marktinhome/Views/liquid_swipe/ViewI;)V", "touchOffset", "drawEdge", "", "canvas", "Landroid/graphics/Canvas;", "drawPath", "onDownTouch", "", "ev", "Landroid/view/MotionEvent;", "onMoveTouch", "onPageChanged", "newPosition", "onUpTouch", "updateProgress", "rawX", "app_debug"})
public final class LeftEdgeController extends com.doubleclick.marktinhome.Views.liquid_swipe.EdgeController {
    private final float touchOffset = 0.05F;
    
    public LeftEdgeController(int viewWidth, int viewHeight, float waveCenterY, float density, @org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Views.liquid_swipe.ViewI view) {
        super(0, 0, 0.0F, 0.0F, null);
    }
    
    @java.lang.Override()
    public void onPageChanged(int newPosition) {
    }
    
    @java.lang.Override()
    public boolean onDownTouch(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent ev) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onUpTouch(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent ev) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onMoveTouch(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent ev) {
        return false;
    }
    
    @java.lang.Override()
    public void drawEdge(@org.jetbrains.annotations.Nullable()
    android.graphics.Canvas canvas) {
    }
    
    @java.lang.Override()
    protected void updateProgress(float rawX) {
    }
    
    private final void drawPath(android.graphics.Canvas canvas) {
    }
}