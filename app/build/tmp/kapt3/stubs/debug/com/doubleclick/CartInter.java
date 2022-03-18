package com.doubleclick;

import java.lang.System;

/**
 * Created By Eslam Ghazy on 3/3/2022
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/doubleclick/CartInter;", "", "getCart", "", "cart", "Ljava/util/ArrayList;", "Lcom/doubleclick/marktinhome/Model/Cart;", "app_debug"})
public abstract interface CartInter {
    
    public abstract void getCart(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.Cart> cart);
}