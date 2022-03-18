package com.doubleclick;

import java.lang.System;

/**
 * Created By Eslam Ghazy on 3/6/2022
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/doubleclick/OnProduct;", "", "onItemProduct", "", "product", "Lcom/doubleclick/marktinhome/Model/Product;", "app_debug"})
public abstract interface OnProduct {
    
    public abstract void onItemProduct(@org.jetbrains.annotations.Nullable()
    com.doubleclick.marktinhome.Model.Product product);
}