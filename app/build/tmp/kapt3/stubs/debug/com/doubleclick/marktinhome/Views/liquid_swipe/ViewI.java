package com.doubleclick.marktinhome.Views.liquid_swipe;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\u0010"}, d2 = {"Lcom/doubleclick/marktinhome/Views/liquid_swipe/ViewI;", "", "blockInput", "", "block", "", "getBitmap", "Landroid/graphics/Bitmap;", "direction", "", "getBitmapAt", "position", "getCount", "getCurrentItem", "redraw", "switchPage", "app_debug"})
public abstract interface ViewI {
    
    @org.jetbrains.annotations.Nullable()
    public abstract android.graphics.Bitmap getBitmap(int direction);
    
    @org.jetbrains.annotations.Nullable()
    public abstract android.graphics.Bitmap getBitmapAt(int position);
    
    public abstract int getCount();
    
    public abstract void redraw();
    
    public abstract void switchPage(int direction);
    
    public abstract int getCurrentItem();
    
    public abstract void blockInput(boolean block);
}