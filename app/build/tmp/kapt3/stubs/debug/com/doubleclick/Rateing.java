package com.doubleclick;

import java.lang.System;

/**
 * Created By Eslam Ghazy on 3/6/2022
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u001e\u0010\u0004\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/doubleclick/Rateing;", "", "AllRate", "", "arrayRate", "Ljava/util/ArrayList;", "Lcom/doubleclick/marktinhome/Model/Rate;", "Lkotlin/collections/ArrayList;", "MyRate", "rate", "app_debug"})
public abstract interface Rateing {
    
    public abstract void MyRate(@org.jetbrains.annotations.Nullable()
    com.doubleclick.marktinhome.Model.Rate rate);
    
    public abstract void AllRate(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.Rate> arrayRate);
}