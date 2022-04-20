package com.doubleclick;

import java.lang.System;

/**
 * Created By Eslam Ghazy on 3/8/2022
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H&J(\u0010\u0007\u001a\u00020\u00032\u001e\u0010\b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tj\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\u000bH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\nH&\u00a8\u0006\u000f"}, d2 = {"Lcom/doubleclick/Tradmarkinterface;", "", "AllNameTradmark", "", "names", "", "", "AllTradmark", "tradmark", "Ljava/util/ArrayList;", "Lcom/doubleclick/marktinhome/Model/Trademark;", "Lkotlin/collections/ArrayList;", "OnItemTradmark", "onDeleteTradmark", "onEditTradmark", "app_debug"})
public abstract interface Tradmarkinterface {
    
    public abstract void AllTradmark(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.Trademark> tradmark);
    
    public abstract void AllNameTradmark(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> names);
    
    public abstract void OnItemTradmark(@org.jetbrains.annotations.Nullable()
    com.doubleclick.marktinhome.Model.Trademark tradmark);
    
    public abstract void onEditTradmark(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Model.Trademark tradmark);
    
    public abstract void onDeleteTradmark(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Model.Trademark tradmark);
}