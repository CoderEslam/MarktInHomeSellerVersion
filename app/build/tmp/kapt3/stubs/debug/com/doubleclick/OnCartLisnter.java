package com.doubleclick;

import java.lang.System;

/**
 * Created By Eslam Ghazy on 3/12/2022
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/doubleclick/OnCartLisnter;", "", "OnAddItemOrder", "", "cart", "Lcom/doubleclick/marktinhome/Model/Cart;", "OnDeleteItemOrder", "OnMinsItemOrder", "app_debug"})
public abstract interface OnCartLisnter {
    
    public abstract void OnAddItemOrder(@org.jetbrains.annotations.Nullable()
    com.doubleclick.marktinhome.Model.Cart cart);
    
    public abstract void OnMinsItemOrder(@org.jetbrains.annotations.Nullable()
    com.doubleclick.marktinhome.Model.Cart cart);
    
    public abstract void OnDeleteItemOrder(@org.jetbrains.annotations.Nullable()
    com.doubleclick.marktinhome.Model.Cart cart);
}